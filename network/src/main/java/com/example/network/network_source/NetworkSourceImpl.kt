package com.example.network.network_source

import com.example.network.service.TaxpayerList
import org.threeten.bp.LocalDate

internal class NetworkSourceImpl(private val service: TaxpayerList) : NetworkSource {

    override  fun getInfoByBankAccount(
        bankAccountNumber: String,
        date: LocalDate
    ) = service.getInfoByBankAccount(bankAccountNumber, date.toString())


    override  fun getInfoByRegon(regonNumber: Long, date: LocalDate) =
        service.getInfoByRegon(regonNumber, date.toString())

    override  fun getInfoByNip(nipNumber: Long, date: LocalDate) =
        service.getInfoByNip(nipNumber, date.toString())
}