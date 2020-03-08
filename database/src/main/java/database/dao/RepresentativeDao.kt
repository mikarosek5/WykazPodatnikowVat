package database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import database.entity.Representative
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
internal interface RepresentativeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(representative: Representative):Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMany(vararg representative: Representative):Completable

    @Query("Select * from Representative where subjectId = :subjectId")
    fun getAllBySubjectId(subjectId:String):Flowable<List<Representative>>
}
