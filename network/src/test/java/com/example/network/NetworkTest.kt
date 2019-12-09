package com.example.network

import com.example.network.network_source.NetworkSource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import org.threeten.bp.LocalDate

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class NetworkTest: KoinTest {

    val networkSource:NetworkSource by inject()

    @Before
    fun start(){
        startKoin { modules(networkModule) }
    }
    @After
    fun stop(){
        stopKoin()
    }
    @Test
    fun checkByNip(){

        runBlocking {
            val nipResponse = networkSource.getInfoByNip(1424034322, LocalDate.of(2019,12,9))
            assert(nipResponse.result.subject.nip == "1424034322")
        }
    }
    @Test
    fun checkByRegon(){
        runBlocking {
            val regonResponse = networkSource.getInfoByRegon(73048407072664,LocalDate.of(2019,12,9)).result.subject.accountNumbers[0]
            assert(regonResponse=="20182432668907075444215211")
        }
    }
    @Test fun checkByBankingAccount(){
        runBlocking {
            val bankAccResponse =
                networkSource.getInfoByBankAccount("31872831997646186715413833", LocalDate.of(2019,12,9))
            assert(bankAccResponse.result.subjects[0].partners[0].nip=="1100291110")
        }
    }


}
