package com.example.repository

import database.merged.TaxPayerWithSubjects
import io.reactivex.Flowable
import org.threeten.bp.LocalDate

interface TaxPayerRepository {

    suspend fun getByBankNumber(bankNumber:String,date:LocalDate)
    suspend fun getByNipNumber()
    suspend fun getHistory(): Flowable<List<TaxPayerWithSubjects>>
}