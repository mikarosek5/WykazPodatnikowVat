package database.dataSource

import database.dataSource.save.TaxToSave
import database.entity.AuthorizedClerk
import database.entity.BankAccountNumber
import database.entity.Partner
import database.entity.Representative
import database.merged.TaxPayerWithSubjects
import io.reactivex.Completable
import io.reactivex.Flowable

interface DatabaseSource {

    fun getTaxPayerWithSubjects():Flowable<List<TaxPayerWithSubjects>>

    fun getTaxPayerWithSubjectsById(uid:String):Flowable<TaxPayerWithSubjects>

    fun getLastTaxPayerWithSubjects():Flowable<TaxPayerWithSubjects>

    fun saveFullTax(taxToSave: TaxToSave):Completable

    suspend fun getBankAccounts(subjectId:String):Flowable<List<BankAccountNumber>>

    suspend fun getPartner(subjectId: String):Flowable<List<Partner>>

    suspend fun getRepresentative(subjectId: String):Flowable<List<Representative>>

    suspend fun getAuthorizedClerk(subjectId: String):Flowable<List<AuthorizedClerk>>

    suspend fun deleteByTaxUid(taxUid:String):Completable

}