package com.example.repository

import com.example.network.network_source.NetworkSource
import com.example.repository.dataConverter.convert
import database.dataSource.DatabaseSource
import database.merged.TaxPayerWithSubjects
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject
import org.threeten.bp.LocalDate

internal class TaxPayerRepositoryImpl(
    private val networkSource: NetworkSource,
    private val databaseSource: DatabaseSource
) : TaxPayerRepository {

    //    private val subject:Subject<TaxPayerWithSubjects> = BehaviorSubject.create<TaxPayerWithSubjects>()
//    val observable = subject.observeOn(AndroidSchedulers.mainThread())
    private var _observable: Observable<TaxPayerWithSubjects> = BehaviorSubject.create()
    val observable: Observable<TaxPayerWithSubjects>
        get() = _observable


    override suspend fun getByBankNumber(bankNumber: String, date: LocalDate) {
        val result = networkSource.getInfoByBankAccount(bankNumber, date).convert()
        val resultId = result.taxPayer.uid
        databaseSource.saveFullTax(result)
        _observable =
            databaseSource.getTaxPayerWithSubjectsById(resultId).observeOn(Schedulers.io())
                .toObservable()
    }

    override suspend fun getByNipNumber() {
        TODO("implement cache")
    }

    override suspend fun getHistory() =
        databaseSource.getTaxPayerWithSubjects()

}