package database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import database.entity.BankAccountNumber
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
internal interface BankAccountDao {

    @Insert
    fun insert(bankAccountNumber: BankAccountNumber):Completable

    @Insert
    fun insertMany(vararg representative: BankAccountNumber):Completable

    @Query("select * from BankAccountNumber where subjectId=:subjectId")
    fun getAllBySubjectId(subjectId:String):Flowable<List<BankAccountNumber>>
}
