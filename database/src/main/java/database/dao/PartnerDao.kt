package database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import database.entity.Partner
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
internal interface PartnerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(partner: Partner):Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMany(vararg representative: Partner):Completable

    @Query("Select * from partner where subjectId=:subject_id")
    fun getAllBySubjectId(subject_id:String): Flowable<List<Partner>>


}
