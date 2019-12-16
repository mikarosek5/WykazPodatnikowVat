package database.dao
import androidx.room.Dao
import androidx.room.Insert
import database.entity.Subject
import io.reactivex.Completable

@Dao
internal interface SubjectDao {
    @Insert
    fun insert(subject: Subject):Completable
    @Insert
    fun insertMany(vararg subject: Subject):Completable
}