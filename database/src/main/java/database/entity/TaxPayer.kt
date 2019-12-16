package database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.threeten.bp.LocalDate

@Entity(tableName = "TaxPayer")
class TaxPayer(
    @PrimaryKey
    val uid: String,
    val downloadedDate:LocalDate
)