package com.example.repository.datasource

import com.example.network.network_source.NetworkSource
import com.example.repository.dataConverter.convert
import database.dataSource.DatabaseSource
import database.dataSource.save.TaxToSave
import database.merged.TaxPayerWithSubjects
import io.reactivex.Flowable
import org.threeten.bp.LocalDate

internal class TaxPayerRepositoryImpl(
    private val networkSource: NetworkSource,
    private val databaseSource: DatabaseSource
) : TaxPayerRepository {


    override fun getTaxAndSaveIntoBase(
        bankNumber: String,
        date: LocalDate
    ): Flowable<TaxPayerWithSubjects> {
        val result = networkSource.getInfoByBankAccount(bankNumber, date).blockingGet().convert()
        saveResultToBase(result)
        return databaseSource.getTaxPayerWithSubjectsById(result.taxPayer.uid)
    }
    private fun saveResultToBase(taxToSave: TaxToSave){
        databaseSource.saveFullTax(taxToSave)
    }



    //    override suspend fun getByBankNumber(bankNumber: String, date: LocalDate) {
//        val result = networkSource.getInfoByBankAccount(bankNumber, date).convert()
//        val resultId = result.taxPayer.uid
//        databaseSource.saveFullTax(result)
//        _observable =
//            databaseSource.getTaxPayerWithSubjectsById(resultId).observeOn(Schedulers.io())
//                .toObservable()
//    }

    override suspend fun getByNipNumber() {
        TODO("implement cache")
    }

    override suspend fun getHistory() =
        databaseSource.getTaxPayerWithSubjects()
}