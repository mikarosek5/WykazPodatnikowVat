package database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Subject")
class Subject(
    val subjectNip: String?,
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
    val workingAdress: String?,
    val hasVirtualAccounts: Boolean?,
    val taxPayerUid:String
){
    @PrimaryKey(autoGenerate = true) var subjectId: Long=0
}