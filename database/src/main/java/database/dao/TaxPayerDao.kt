package database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import database.embendded.TaxPayerWithSubject

@Dao
interface TaxPayerDao {
    @Transaction
    @Query("SELECT * FROM TaxPayer")
    fun getAllTaxPayers() : List<TaxPayerWithSubject>

    @Query("SELECT * FROM TaxPayer WHERE uid=:uid")
    fun getTaxPayerById(uid:String) : TaxPayerWithSubject

    @Insert
    fun insertTaxPayer(taxPayerWithSubject: TaxPayerWithSubject) //Completable Todo

}