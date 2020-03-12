package com.example.network.network_response.shared


import com.squareup.moshi.Json

data class Subject(
    @Json(name = "accountNumbers")
    val accountNumbers: List<String>,
    @Json(name = "authorizedClerks")
    val authorizedClerks: List<AuthorizedClerk>,
    @Json(name = "hasVirtualAccounts")
    val hasVirtualAccounts: Boolean,
    @Json(name = "krs")
    val krs: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "nip")
    val nip: String,
    @Json(name = "partners")
    val partners: List<Partner>,
    @Json(name = "pesel")
    val pesel: String?,
    @Json(name = "registrationDenialBasis")
    val registrationDenialBasis: String?,
    @Json(name = "registrationDenialDate")
    val registrationDenialDate: String?,
    @Json(name = "registrationLegalDate")
    val registrationLegalDate: String?,
    @Json(name = "regon")
    val regon: String,
    @Json(name = "removalBasis")
    val removalBasis: String?,
    @Json(name = "removalDate")
    val removalDate: String?,
    @Json(name = "representatives")
    val representatives: List<Representative>,
    @Json(name = "residenceAddress")
    val residenceAddress: String?,
    @Json(name = "restorationBasis")
    val restorationBasis: String?,
    @Json(name = "restorationDate")
    val restorationDate: String?,
    @Json(name = "statusVat")
    val statusVat: String,
    @Json(name = "workingAddress")
    val workingAddress: String?
)