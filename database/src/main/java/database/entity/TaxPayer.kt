package database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime

@Entity(tableName = "TaxPayer")
data class TaxPayer(
    @PrimaryKey
    val uid: String,
    val downloadedDate:LocalDateTime
)