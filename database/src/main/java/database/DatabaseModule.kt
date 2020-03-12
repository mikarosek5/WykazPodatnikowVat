package database

import android.content.Context
import androidx.room.Room
import database.dataSource.DatabaseSource
import database.dataSource.DatabaseSourceImpl
import database.tax_database.TaxDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single { setupTestDatabase(androidContext()) }
    single { get<TaxDatabase>().taxPayerDao() }
    single { get<TaxDatabase>().subjectDao() }
    single { get<TaxDatabase>().representativeDao() }
    single { get<TaxDatabase>().partnerDao() }
    single { get<TaxDatabase>().bankAccountDao() }
    single { get<TaxDatabase>().authorizedClerkDao() }
    single { DatabaseSourceImpl(get(),get(),get(),get(),get(),get()) as DatabaseSource }

}

private fun setupDatabase(context: Context) =
    Room.databaseBuilder(context.applicationContext, TaxDatabase::class.java, "Tax.db").build()

private fun setupTestDatabase(context: Context) = Room.inMemoryDatabaseBuilder(context,TaxDatabase::class.java).build()

//allowMainThreadDB