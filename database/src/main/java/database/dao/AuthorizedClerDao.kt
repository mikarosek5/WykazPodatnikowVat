package database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import database.entity.AuthorizedClerk
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface AuthorizedClerDao {
    @Insert
    fun insert(authorizedClerk: AuthorizedClerk): Completable


    @Query("Select * from AuthorizedClerk where subjectId = :subjectId")
    fun getAllBySubjectId(subjectId: Long): Flowable<List<AuthorizedClerk>>
}
