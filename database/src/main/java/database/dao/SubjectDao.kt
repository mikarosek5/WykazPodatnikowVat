package database.dao
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import database.entity.Subject
import io.reactivex.Completable

@Dao
internal interface SubjectDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(subject: Subject):Completable
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMany(vararg subject: Subject):Completable
}