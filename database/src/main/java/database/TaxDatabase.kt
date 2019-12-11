package database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import database.converters.DataConverter
import database.dao.TaxPayerDao
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
abstract class TaxDatabase : RoomDatabase() {

    abstract fun taxPayerDao(): TaxPayerDao
    companion object{

    }

}