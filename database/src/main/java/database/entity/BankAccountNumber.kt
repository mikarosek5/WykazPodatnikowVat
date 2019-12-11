package database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BankAccountNumber(@PrimaryKey val accountNumber: String,val subjectId:String)
