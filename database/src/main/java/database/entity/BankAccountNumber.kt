package database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = Subject::class,
        parentColumns = ["subjectNip"],
        childColumns = ["subjectId"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.NO_ACTION

    )]
)
data class BankAccountNumber(@PrimaryKey val accountNumber: String,@ColumnInfo(index = true) val subjectId:String)
