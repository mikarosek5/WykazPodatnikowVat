package com.example.repository.dataConverter

import com.example.network.network_response.bank.BankAccountResponse
import com.example.network.network_response.nip.NipResponse
import com.example.network.network_response.regon.RegonResponse
import database.dataSource.save.TaxToSave
import database.entity.*
import org.threeten.bp.LocalDate


//This is not best way to convert data types better option is to create secondary constructor in
// entity and use .map function, it require additional module like core to make visible
// response and entity for both modules, this solution is kind of hack if somebody want to add new
//things in app he have to refactor network and database module
fun BankAccountResponse.convert(): TaxToSave {
    return TaxToSave(
        TaxPayer(this.result.requestId, LocalDate.now()),
        subject(this.result.subjects, this.result.requestId),
        representative(result.subjects, this.result.requestId),
        partner(result.subjects, this.result.requestId),
        bankAccount(result.subjects, this.result.requestId),
        authorizedClerk(result.subjects, this.result.requestId)
    )
}

fun NipResponse.convert(): TaxToSave {
    return TaxToSave(
        TaxPayer(this.result.requestId, LocalDate.now()),
        subject(listOf(this.result.subject), this.result.requestId),
        representative(listOf(this.result.subject), this.result.requestId),
        partner(listOf(this.result.subject), this.result.requestId),
        bankAccount(listOf(this.result.subject), this.result.requestId),
        authorizedClerk(listOf(this.result.subject), this.result.requestId)
    )
}

fun RegonResponse.convert(): TaxToSave {
    return TaxToSave(
        TaxPayer(this.result.requestId, LocalDate.now()),
        subject(listOf(this.result.subject), this.result.requestId),
        representative(listOf(this.result.subject), this.result.requestId),
        partner(listOf(this.result.subject), this.result.requestId),
        bankAccount(listOf(this.result.subject), this.result.requestId),
        authorizedClerk(listOf(this.result.subject), this.result.requestId)
    )
}

private fun authorizedClerk(
    subjects: List<com.example.network.network_response.shared.Subject?>,
    requestId: String
): List<AuthorizedClerk> {
    val converted = ArrayList<AuthorizedClerk>()
    subjects.forEach {
        it?.authorizedClerks?.forEach {
            converted.add(
                AuthorizedClerk(
                    it.nip,
                    it.companyName,
                    it.firstName,
                    it.lastName,
                    it.pesel,
                    requestId
                )
            )
        }
    }
    return converted
}

private fun bankAccount(
    subjects: List<com.example.network.network_response.shared.Subject?>,
    requestId: String
): List<BankAccountNumber> {
    val converted = ArrayList<BankAccountNumber>()
    subjects.forEach {
        it?.accountNumbers?.forEach {
            converted.add(
                BankAccountNumber(it, requestId)
            )
        }
    }
    return converted
}

private fun partner(
    subjects: List<com.example.network.network_response.shared.Subject?>,
    requestId: String
): List<Partner> {
    val converted = ArrayList<Partner>()
    subjects.forEach {
        it?.partners?.forEach {
            converted.add(
                Partner(
                    it.nip,
                    it.companyName,
                    it.firstName,
                    it.lastName,
                    it.pesel,
                    requestId
                )
            )
        }
    }
    return converted
}


private fun subject(
    subjects: List<com.example.network.network_response.shared.Subject?>,
    taxUuid: String
): List<Subject> {
    val converted = ArrayList<Subject>()

    subjects.forEach { subjects ->
        subjects?.let {
            converted.add(
                Subject(
                    it.nip,
                    it.name,
                    it.regon,
                    it.pesel,
                    it.krs,
                    it.registrationLegalDate,
                    it.registrationDenialBasis,
                    it.registrationDenialDate,
                    it.restorationBasis,
                    it.restorationDate,
                    it.removalBasis,
                    it.removalDate,
                    it.residenceAddress,
                    it.workingAddress,
                    it.hasVirtualAccounts,
                    taxUuid
                )
            )
        }
    }
    return converted
}

private fun representative(
    networkSubject: List<com.example.network.network_response.shared.Subject?>,
    taxUuid: String
): List<Representative> {
    val converted = ArrayList<Representative>()
    networkSubject.forEach {
        it?.representatives?.forEach {
            converted.add(
                Representative(
                    it.nip,
                    it.companyName,
                    it.firstName,
                    it.lastName,
                    it.pesel,
                    taxUuid
                )
            )
        }
    }

    return converted
}