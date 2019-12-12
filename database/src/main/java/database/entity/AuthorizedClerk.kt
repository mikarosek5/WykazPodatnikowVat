package database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.ForeignKey.NO_ACTION
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = Subject::class,
        parentColumns = ["subjectId"],
        childColumns = ["subjectId"],
        onDelete = CASCADE,
        onUpdate = NO_ACTION

    )]
)
class AuthorizedClerk(
    @PrimaryKey
    val nip: String,
    val companyName: String?,
    val firstName: String?,
    val lastName: String?,
    val pesel: String?,
    val subjectId: Long
)
