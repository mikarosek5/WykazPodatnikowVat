package database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Subject")
class Subject(
    @PrimaryKey val subjectId: Long,
    val name: String?,
    val nip: String?,
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
//    val accountNumbers: List<BankAccountNumber>,
//    val representatives: List<Representative>?,
//    val authorizedClerks: List<AuthorizedClerk>?,
//    val partners: List<Partner>?,
    val taxPayerUid:String
)