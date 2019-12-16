package com.example.network.network_source

import com.example.network.network_response.bank.BankAccountResponse
import com.example.network.network_response.nip.NipResponse
import com.example.network.network_response.regon.RegonResponse
import io.reactivex.Single
import org.threeten.bp.LocalDate

interface NetworkSource {
     fun getInfoByBankAccount(bankAccountNumber:String,date: LocalDate):Single<BankAccountResponse>
     fun getInfoByRegon(regonNumber:Long,date:LocalDate):Single<RegonResponse>
     fun getInfoByNip(nipNumber:Long,date:LocalDate):Single<NipResponse>
}