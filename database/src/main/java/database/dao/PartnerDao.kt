package database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import database.entity.Partner
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface PartnerDao {

    @Insert
    fun insert(partner: Partner):Completable

    @Query("Select * from partner where subjectId=:subject_id")
    fun getAllBySubjectId(subject_id:Long): Flowable<List<Partner>>


}
