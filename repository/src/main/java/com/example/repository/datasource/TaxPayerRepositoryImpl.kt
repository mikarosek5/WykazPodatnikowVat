package com.example.repository.datasource

import android.util.Log
import com.example.network.network_source.NetworkSource
import com.example.repository.dataConverter.convert
import database.dataSource.DatabaseSource
import database.dataSource.save.TaxToSave
import database.merged.TaxPayerWithSubjects
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import org.threeten.bp.LocalDate

internal class TaxPayerRepositoryImpl(
    private val networkSource: NetworkSource,
    private val databaseSource: DatabaseSource,
    private val taxDisposable: CompositeDisposable
) : TaxPayerRepository {


    override fun getTaxAndSaveIntoBase(
        bankNumber: String,
        date: LocalDate
    ): Flowable<TaxPayerWithSubjects> {
        return databaseSource.getLastTaxPayerWithSubjects().doOnSubscribe {
            makeNetworkCall(bankNumber,date)
        }
    }


    private fun makeNetworkCall(
        bankNumber: String,
        date: LocalDate
    ) {
        taxDisposable.add(networkSource.getInfoByBankAccount(bankNumber, date)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .map { it.convert() }
            .subscribeBy(
                onSuccess = {saveResultToBase(it) },
                onError = { Log.d("MYERROR",it.message?:"")}
            )
        )
    }

    private fun saveResultToBase(taxToSave: TaxToSave) {
        databaseSource.saveFullTax(taxToSave).test().assertComplete()
    }

    override fun getByNipNumber() {
        TODO("implement cache")
    }

    override fun getHistory() =
        databaseSource.getTaxPayerWithSubjects()
}