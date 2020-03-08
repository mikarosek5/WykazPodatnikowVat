package database

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import database.dataSource.DatabaseSource
import database.dataSource.save.TaxToSave
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class DatabaseTest : KoinTest {


    @get:Rule
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    //    private val taxDatabase:TaxDatabase by inject()
    private val taxPayerData: DatabaseSource by inject()

    @Before
    fun before() {
        startKoin {
            androidContext(InstrumentationRegistry.getInstrumentation().targetContext)
            modules(databaseModule)
        }
    }

    @After
    fun after() {
        stopKoin()
    }

    private fun setupTestData() {
        runBlocking {
            taxPayerData.saveFullTax(
                TaxToSave(
                    taxPayer, listOf(subject, subject2), listOf(
                        representative, representative2, representative3
                    ), listOf(partner, partner2), listOf(
                        bankAccountNumber,
                        bankAccountNumber2,
                        bankAccountNumber3,
                        bankAccountNumber4
                    ), listOf(
                        authorizedClerk, authorizedClerk2, authorizedClerk3
                    )
                )
            ).test().assertNoErrors().assertComplete()

            taxPayerData.saveFullTax(
                TaxToSave(
                    taxPayer2, listOf(subject, subject2), listOf(
                        representative, representative2, representative3
                    ), listOf(partner, partner2), listOf(
                        bankAccountNumber,
                        bankAccountNumber2,
                        bankAccountNumber3,
                        bankAccountNumber4
                    ), listOf(
                        authorizedClerk, authorizedClerk2, authorizedClerk3
                    )
                )
            ).test().assertNoErrors().assertComplete()
        }
    }


    @Test
    fun emptyTaxPayer() {
        runBlocking {
            taxPayerData.getTaxPayerWithSubjects().test().assertNoErrors().assertValue {
                it.isEmpty()
            }
        }
    }

    @Test
    fun testTaxPayer() {
        runBlocking {
            setupTestData()
            taxPayerData.getTaxPayerWithSubjects().test().assertNoErrors().assertValue {
                it.first().taxPayer.uid == "1"
            }

        }
    }

    @Test
    fun testSubject() {
        runBlocking {
            setupTestData()
            taxPayerData.getTaxPayerWithSubjects().test().assertNoErrors().assertValue {
                it.first().subjects.isNotEmpty()
            }

        }
    }


    @Test
    fun testBank() {
        runBlocking {
            setupTestData()
            taxPayerData.getBankAccounts("55555").test().assertNoErrors().assertValue {
                it.first().accountNumber=="1234"
            }
        }
    }
    @Test
    fun testEmptyBank(){
        runBlocking {
            taxPayerData.getBankAccounts("123123123").test().assertNoErrors().assertValue {
                it.isEmpty()
            }
        }
    }

    @Test
    fun testPartner() {
        runBlocking {
            setupTestData()
            taxPayerData.getPartner("55555").test().assertNoErrors().assertValue {
                it.first().companyName == "adamowo"
            }
        }
    }

    @Test
    fun testEmptyPartner() {
        runBlocking {
            taxPayerData.getPartner("9999999").test().assertNoErrors().assertValue {
                it.isEmpty()
            }
        }
    }

    //
    @Test
    fun testEmptyRepresentative() {
        runBlocking {
            taxPayerData.getRepresentative("9999").test().assertNoErrors().assertValue {
                it.isEmpty()
            }
        }
    }

    @Test
    fun testRepresentative() {
        runBlocking {
            setupTestData()
            taxPayerData.getRepresentative("1234321").test().assertNoErrors().assertValue {
                it.first().companyName =="iksde"
            }
        }
    }
    @Test
    fun testEmptyAuthorizedClerk() {
        runBlocking {
            taxPayerData.getAuthorizedClerk("9999").test().assertNoErrors().assertValue {
                it.isEmpty()
            }
        }
    }
    @Test
    fun testAuthorizedClerk(){
        runBlocking {
            setupTestData()
            taxPayerData.getAuthorizedClerk("1234321").test().assertNoErrors().assertValue {
                it.first().nip == "1234"
            }
        }
    }
    @Test
    fun testCascadeDelete(){
        runBlocking {
            setupTestData()
            taxPayerData.getTaxPayerWithSubjects().test().assertNoErrors().assertValue {
                it.isNotEmpty()
            }
            taxPayerData.deleteByTaxUid("1").test().assertNoErrors().assertComplete()
            taxPayerData.getTaxPayerWithSubjectsById("1").test().assertEmpty()
        }
    }
    @Test
    fun testGetLast(){
        runBlocking {
            setupTestData()
            taxPayerData.getLastTaxPayerWithSubjects()
                .test()
                .assertNoErrors()
                .assertValue {
                    it.taxPayer.uid=="2"
                }

        }
    }



}


