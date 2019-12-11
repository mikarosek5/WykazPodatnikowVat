package database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Partner(
    @PrimaryKey
    val nip: String,
    val companyName: String,
    val firstName: String,
    val lastName: String,
    val pesel: String?
)
