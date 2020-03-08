package database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import database.entity.TaxPayer
import database.merged.TaxPayerWithSubjects
import io.reactivex.Completable
import io.reactivex.Flowable
import java.time.LocalDateTime

@Dao
internal interface TaxPayerDao {

    @Insert
    fun insert(taxPayer:TaxPayer):Completable

    @Transaction
    @Query("SELECT * FROM TaxPayer")
    fun getTaxPayerWithSubjects() : Flowable<List<TaxPayerWithSubjects>>

    @Transaction
    @Query("SELECT * FROM TAXPAYER where uid =:uid")
    fun findTaxPayerWithSubjectsById(uid:String) : Flowable<TaxPayerWithSubjects>

    @Query("DELETE FROM TAXPAYER WHERE uid = :uid")
    fun deleteById(uid:String):Completable

    @Transaction
    @Query("SELECT * FROM TAXPAYER ORDER BY downloadedDate DESC LIMIT 1")
    fun getLastTaxPayerWithSubjects() : Flowable<TaxPayerWithSubjects>
}
