package database

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import database.entity.*
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.threeten.bp.LocalDate

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class DatabaseTest {

    @get:Rule
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var taxDatabase: TaxDatabase

    @Before
    fun initializeDatabase() {
        taxDatabase = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context,
            TaxDatabase::class.java
        ).allowMainThreadQueries().build()
    }

    @After
    fun closeDatabase() {
        taxDatabase.close()
    }


    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.database.test", appContext.packageName)
    }

    @Test
    fun emptyTaxPayer() {
        taxDatabase.taxPayerDao().getTaxPayerWithSubjects().test().assertValue {
            it.isEmpty()
        }
    }

    @Test
    fun testTaxPayerWithSubjects() {
        val taxPayer = TaxPayer("1", LocalDate.now())
        val subject = Subject(
            "xd",
            "111",
            "222",
            "999",
            "321",
            "123:321",
            "aaaaaa",
            "bbbbbbb",
            "ccccc",
            "asdasd",
            "sdgfdfsgfd",
            "sdfsdfsdf",
            "sdfsdf",
            "sdfsdf",
            false,
            "1"
        )
        taxDatabase.taxPayerDao().insert(taxPayer).test().assertComplete()
        taxDatabase.subjectDao().insert(subject).test().assertComplete()
        taxDatabase.taxPayerDao().getTaxPayerWithSubjects().test().assertValue {
            it.first().taxPayer.uid == "1"
        }

    }

    @Test
    fun emptyBank() {
        taxDatabase.bankAccountDao().getAllBySubjectId(5).test().assertValue {
            it.isEmpty()
        }
    }

    @Test
    fun testAccountNumbers() {
        val bankAccountNumber = BankAccountNumber("1234", 1)
        val bankAccountNumber2 = BankAccountNumber("4321", 2)
        val bankAccountNumber3 = BankAccountNumber("2222", 3)
        val bankAccountNumber4 = BankAccountNumber("1111", 4)
        taxDatabase.bankAccountDao().insert(bankAccountNumber).test().assertComplete()
        taxDatabase.bankAccountDao().insert(bankAccountNumber2).test().assertComplete()
        taxDatabase.bankAccountDao().insert(bankAccountNumber3).test().assertComplete()
        taxDatabase.bankAccountDao().insert(bankAccountNumber4).test().assertComplete()
        taxDatabase.bankAccountDao().getAllBySubjectId(2).test().assertValue {
            it.first().accountNumber == "4321"
        }
        taxDatabase.bankAccountDao().getAllBySubjectId(1).test().assertValue {
            it.first().accountNumber == "1234"
        }
    }

    @Test
    fun testEmptyPartner() {
        taxDatabase.partnerDao().getAllBySubjectId(99999).test().assertValue {
            it.isEmpty()
        }
    }

    @Test
    fun testPartner() {
        val partner = Partner("111", "adamowo", "abc", "gggg", null, 1234321)
        val partner2 = Partner("222", "michalowo", "abasdc", "gffgg", "12334", 1234321)
        taxDatabase.partnerDao().insert(partner).test().assertComplete()
        taxDatabase.partnerDao().insert(partner2).test().assertComplete()
        taxDatabase.partnerDao().getAllBySubjectId(1234321).test().assertValue {
            it.first().lastName == "gggg"
        }

    }

    @Test
    fun testEmptyRepresentative() {
        taxDatabase.representativeDao().getAllBySubjectId(9999).test().assertValue {
            it.isEmpty()
        }
    }

    @Test
    fun testRepresentative() {
        val representative = Representative("1234", "iksde", "bekol", null, "111111", 1234321)
        val representative2 = Representative("4321", "policja", null, null, "0000000", 1234321)
        val representative3 = Representative("1111", "kurnik", "kogut", "kurzy", "44444", 1234321)
        taxDatabase.representativeDao().insert(representative).test().assertComplete()
        taxDatabase.representativeDao().insert(representative2).test().assertComplete()
        taxDatabase.representativeDao().insert(representative3).test().assertComplete()
        taxDatabase.representativeDao().getAllBySubjectId(1234321).test().assertValue {
            it.first().nip == "1234"
        }
    }


    @Test
    fun testEmptyAuthorizedClerk() {
        taxDatabase.authorizedClerkDao().getAllBySubjectId(9999).test().assertValue {
            it.isEmpty()
        }
    }

    @Test
    fun testAuthorizedClerk() {
        val authorizedClerk = AuthorizedClerk("1234", "", "", "", "", 1234321)
        val authorizedClerk2 = AuthorizedClerk("4321", "", "", "", "", 1234321)
        val authorizedClerk3 = AuthorizedClerk("5555", "", "", "", "", 1234321)
        taxDatabase.authorizedClerkDao().insert(authorizedClerk).test().assertComplete()
        taxDatabase.authorizedClerkDao().insert(authorizedClerk2).test().assertComplete()
        taxDatabase.authorizedClerkDao().insert(authorizedClerk3).test().assertComplete()
        taxDatabase.authorizedClerkDao().getAllBySubjectId(1234321).test().assertValue {
            it.first().nip == "1234"
        }

    }

}
