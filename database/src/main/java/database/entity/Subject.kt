package database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Subject",
    foreignKeys = [ForeignKey(
        entity = TaxPayer::class,
        parentColumns = ["uid"],
        childColumns = ["taxPayerUid"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.NO_ACTION

    )])
class Subject(
    @PrimaryKey
    val subjectNip: String,
    val name: String?,
    val regon: String?,
    val pesel: String?,
    val krs: String,
    val registrationLegalDate: String?,
    val registrationDenialBasis: String?,
    val registrationDenialDate: String?,
    val restorationBasis: String?,
    val restorationDate: String?,
    val removalBasis: String?,
    val removalDate: String?,
    val residenceAddress: String?,
    val workingAddress: String?,
    val hasVirtualAccounts: Boolean?,
    @ColumnInfo(index = true)
    val taxPayerUid:String
)