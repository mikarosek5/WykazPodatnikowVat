package database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import database.entity.Representative
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
internal interface RepresentativeDao {

    @Insert
    fun insert(representative: Representative):Completable

    @Insert
    fun insertMany(vararg representative: Representative):Completable

    @Query("Select * from Representative where subjectId = :subjectId")
    fun getAllBySubjectId(subjectId:String):Flowable<List<Representative>>
}
