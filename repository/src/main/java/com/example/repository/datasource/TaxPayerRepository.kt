package com.example.repository.datasource

import database.merged.TaxPayerWithSubjects
import io.reactivex.Flowable
import org.threeten.bp.LocalDate

interface TaxPayerRepository {

    fun getTaxAndSaveIntoBase(bankNumber:String, date:LocalDate):Flowable<TaxPayerWithSubjects>
    fun getByNipNumber()
    fun getHistory(): Flowable<List<TaxPayerWithSubjects>>
}