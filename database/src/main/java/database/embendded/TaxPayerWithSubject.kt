package database.embendded

import androidx.room.Embedded
import androidx.room.Relation
import database.entity.TaxPayer

data class TaxPayerWithSubject(
    @Embedded val taxPayer: TaxPayer,
    @Relation(parentColumn = "uid",entityColumn = "taxPayerUid")
    val subjects:List<SubjectWithAllParams>
)