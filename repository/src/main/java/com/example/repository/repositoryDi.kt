package com.example.repository

import com.example.repository.datasource.TaxPayerRepository
import com.example.repository.datasource.TaxPayerRepositoryImpl
import io.reactivex.disposables.CompositeDisposable
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {

    single{TaxPayerRepositoryImpl(get(),get(),get(named("bankDisposable"))) as TaxPayerRepository }
    single(named("bankDisposable")) { CompositeDisposable() }
}