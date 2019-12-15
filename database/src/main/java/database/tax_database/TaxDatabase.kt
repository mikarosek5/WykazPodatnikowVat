package database.tax_database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import database.converters.DataConverter
import database.dao.*
import database.entity.*
@TypeConverters(DataConverter::class)
@Database(
    entities = [TaxPayer::class,
        Subject::class,
        Representative::class,
        Partner::class,
        BankAccountNumber::class,
        AuthorizedClerk::class
    ],
    version = 1,
    exportSchema = false
)
internal abstract class TaxDatabase : RoomDatabase() {
    abstract fun taxPayerDao():TaxPayerDao
    abstract fun subjectDao():SubjectDao
    abstract fun bankAccountDao(): BankAccountDao
    abstract fun partnerDao(): PartnerDao
    abstract fun representativeDao(): RepresentativeDao
    abstract fun authorizedClerkDao(): AuthorizedClerDao
}