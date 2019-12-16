package database.dataSource

import database.dao.*
import database.dataSource.save.TaxToSave
import database.entity.*
import database.merged.TaxPayerWithSubjects
import io.reactivex.Completable
import io.reactivex.Flowable

internal class DatabaseSourceImpl(
    private val taxPayerDao: TaxPayerDao,
    private val subjectDao: SubjectDao,
    private val representativeDao: RepresentativeDao,
    private val partnerDao: PartnerDao,
    private val bankAccountDao: BankAccountDao,
    private val authorizedClerDao: AuthorizedClerDao
) : DatabaseSource {
    override suspend fun saveFullTax(taxToSave: TaxToSave): Completable {
        return Completable.concatArray(
            taxPayerDao.insert(taxToSave.taxPayer),
            saveSubjects(taxToSave.subjectList),
            saveAuthorizedClerk(taxToSave.authorizedClerkList),
            saveBankAccount(taxToSave.bankAccountNumberList),
            savePartner(taxToSave.partnerList),
            saveRepresentative(taxToSave.representativeList)
        )

    }

    override suspend fun deleteByTaxUid(taxUid: String) =
        taxPayerDao.deleteById(taxUid)

    override suspend fun getTaxPayerWithSubjects(): Flowable<List<TaxPayerWithSubjects>> =
        taxPayerDao.getTaxPayerWithSubjects()


    override suspend fun getBankAccounts(subjectId: String) =
        bankAccountDao.getAllBySubjectId(subjectId)

    override suspend fun getPartner(subjectId: String) =
        partnerDao.getAllBySubjectId(subjectId)

    override suspend fun getRepresentative(subjectId: String) =
        representativeDao.getAllBySubjectId(subjectId)

    override suspend fun getAuthorizedClerk(subjectId: String) =
        authorizedClerDao.getAllBySubjectId(subjectId)

    override suspend fun getTaxPayerWithSubjectsById(uid: String) = taxPayerDao.findTaxPayerWithSubjectsById(uid)

    private fun saveSubjects(subjects: List<Subject>) =
        subjectDao.insertMany(*subjects.toTypedArray())

    private fun savePartner(partners: List<Partner>) =
        partnerDao.insertMany(*partners.toTypedArray())

    private fun saveRepresentative(representatives: List<Representative>) =
        representativeDao.insertMany(*representatives.toTypedArray())

    private fun saveBankAccount(bankAccountNumbers: List<BankAccountNumber>) =
        bankAccountDao.insertMany(*bankAccountNumbers.toTypedArray())

    private fun saveAuthorizedClerk(authorizedClerks: List<AuthorizedClerk>) =
        authorizedClerDao.insertMany(*authorizedClerks.toTypedArray())

}