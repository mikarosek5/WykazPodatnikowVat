package database.dataSource.save

import database.entity.*

data class TaxToSave(
    val taxPayer: TaxPayer,
    val subjectList:List<Subject>,
    val representativeList:List<Representative>,
    val partnerList: List<Partner>,
    val bankAccountNumberList:List<BankAccountNumber>,
    val authorizedClerkList: List<AuthorizedClerk>
)