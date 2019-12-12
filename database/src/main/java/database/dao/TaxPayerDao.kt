package database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import database.entity.TaxPayer
import database.entity.TaxPayerWithSubjects
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface TaxPayerDao {

    @Insert
    fun insert(taxPayer:TaxPayer):Completable

    @Transaction
    @Query("SELECT * FROM TaxPayer")
    fun getTaxPayerWithSubjects() : Flowable<List<TaxPayerWithSubjects>>
}
