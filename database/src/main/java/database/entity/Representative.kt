package database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Representative",
    foreignKeys = [ForeignKey(
        entity = Subject::class,
        parentColumns = ["subjectNip"],
        childColumns = ["subjectId"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.NO_ACTION

    )]
)
data class Representative(
    @PrimaryKey
    val nip: String,
    val companyName: String?,
    val firstName: String?,
    val lastName: String?,
    val pesel: String?,
    @ColumnInfo(index = true)
    val subjectId: String
)

