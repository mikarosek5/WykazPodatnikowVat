package database.embendded

import androidx.room.Embedded
import androidx.room.Relation
import database.entity.*

data class SubjectWithAllParams(
    @Embedded val subject:Subject,
    @Relation(parentColumn = "subjectId",entityColumn = "subjectId", entity = Subject::class)
    val bankAccountNumbers: List<BankAccountNumber>,
    @Relation(parentColumn = "subjectId",entityColumn = "subjectId",entity = Subject::class)
    val representatives : List<Representative>,
    @Relation(parentColumn = "subjectId",entityColumn = "subjectId",entity = Subject::class)
    val authorizedClerks : List<AuthorizedClerk>,
    @Relation(parentColumn = "subjectId",entityColumn = "subjectId",entity = Subject::class)
    val partners:List<Partner>
)