package database.merged

import androidx.room.Embedded
import androidx.room.Relation
import database.entity.Subject
import database.entity.TaxPayer

data class TaxPayerWithSubjects(
    @Embedded val taxPayer: TaxPayer,
    @Relation(parentColumn = "uid" ,entityColumn = "taxPayerUid")
    val subjects: List<Subject>
)
