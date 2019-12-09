package com.example.network.network_source

import com.example.network.service.TaxpayerList
import org.threeten.bp.LocalDate

class NetworkSourceImpl(private val service: TaxpayerList) : NetworkSource {
    override suspend fun getInfoByBankAccount(
        bankAccountNumber: String,
        date: LocalDate
    ) = service.getInfoByBankAccount(bankAccountNumber, date.toString())

    override suspend fun getInfoByRegon(regonNumber: Long, date: LocalDate) =
        service.getInfoByRegon(regonNumber, date.toString())

    override suspend fun getInfoByNip(nipNumber: Long, date: LocalDate) =
        service.getInfoByNip(nipNumber, date.toString())

}