package com.example.network

import com.example.network.network_source.NetworkSource
import org.junit.After
import org.junit.Test

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
class NetworkTest : KoinTest {

    val networkSource: NetworkSource by inject()

    @Before
    fun start() {
        startKoin { modules(networkModule) }
    }

    @After
    fun stop() {
        stopKoin()
    }

    @Test
    fun checkByNip() {

        networkSource.getInfoByNip(
            1424034322,
            LocalDate.of(2019, 12, 9)
        )
            .test().assertNoErrors().assertValue {
                it.result.subject?.nip == "1424034322"
            }
    }

    @Test
    fun checkByRegon() {
        networkSource.getInfoByRegon(73048407072664, LocalDate.of(2019, 12, 9)).test()
            .assertNoErrors().assertValue {
                it.result.subject?.accountNumbers?.first() == "20182432668907075444215211"
            }
    }

    @Test
    fun checkByBankingAccount() {
        networkSource.getInfoByBankAccount(
            "31872831997646186715413833", LocalDate.of(2019, 12, 9)
        )
            .test().assertNoErrors().assertValue {
                it.result.subjects.first().partners.first().nip == "1100291110"
            }

    }

    @Test
    fun checkByNipEmpty() {
        networkSource.getInfoByNip(5219586281, LocalDate.of(2019, 12, 9)).test()
            .assertNoErrors().assertValue {
                it.result.subject == null
            }
    }

    @Test
    fun checkByRegonEmpty() {
        networkSource.getInfoByRegon(236757803, LocalDate.of(2019, 12, 9)).test()
            .assertNoErrors().assertValue {
                it.result.subject == null
            }
    }

    @Test
    fun checkByAccountNumberEmpty() {
        networkSource.getInfoByBankAccount(
            "58820010349588884152033320", LocalDate.of(2019, 12, 9)
        ).test()
            .assertNoErrors().assertValue {
                it.result.subjects.isEmpty()
            }

    }


}
