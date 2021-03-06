package database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import database.entity.AuthorizedClerk
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
internal interface AuthorizedClerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(authorizedClerk: AuthorizedClerk): Completable
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMany(vararg representative: AuthorizedClerk):Completable


    @Query("Select * from AuthorizedClerk where subjectId = :subjectId")
    fun getAllBySubjectId(subjectId: String): Flowable<List<AuthorizedClerk>>
}
