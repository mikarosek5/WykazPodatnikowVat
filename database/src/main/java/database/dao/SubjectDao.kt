package database.dao
import io.reactivex.Completable
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import database.entity.Subject

@Dao
interface SubjectDao {

    @Insert
    fun insert(subject: Subject):Completable
}