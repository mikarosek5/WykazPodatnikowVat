package database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import database.entity.BankAccountNumber
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface BankAccountDao {

    @Insert
    fun insert(bankAccountNumber: BankAccountNumber):Completable

    @Query("select * from BankAccountNumber where subjectId=:subjectId")
    fun getAllBySubjectId(subjectId:Long):Flowable<List<BankAccountNumber>>
}
