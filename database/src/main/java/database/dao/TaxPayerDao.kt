package database.dao

import androidx.room.*
import database.entity.TaxPayer
import database.merged.TaxPayerWithSubjects
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
internal interface TaxPayerDao {

    @Insert
    fun insert(taxPayer:TaxPayer):Completable

    @Transaction
    @Query("SELECT * FROM TaxPayer")
    fun getTaxPayerWithSubjects() : Flowable<List<TaxPayerWithSubjects>>

    @Query("DELETE FROM TAXPAYER WHERE uid = :uid")
    fun deleteById(uid:String):Completable
}
