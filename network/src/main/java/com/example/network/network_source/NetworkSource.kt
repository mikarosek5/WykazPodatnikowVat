package com.example.network.network_source

import com.example.network.network_response.bank.BankAccountResponse
import com.example.network.network_response.nip.NipResponse
import com.example.network.network_response.regon.RegonResponse
import org.threeten.bp.LocalDate

interface NetworkSource {
    suspend fun getInfoByBankAccount(bankAccountNumber:String,date: LocalDate):BankAccountResponse
    suspend fun getInfoByRegon(regonNumber:Long,date:LocalDate):RegonResponse
    suspend fun getInfoByNip(nipNumber:Long,date:LocalDate):NipResponse
    //todo zmienic date na datetime
}