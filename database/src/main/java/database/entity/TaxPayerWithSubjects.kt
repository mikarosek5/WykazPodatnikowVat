package database.entity

import androidx.room.Embedded
import androidx.room.Relation

class TaxPayerWithSubjects(
    @Embedded val taxPayer: TaxPayer,
    @Relation(parentColumn = "uid" ,entityColumn = "taxPayerUid")
    val subjects: List<Subject>
)
