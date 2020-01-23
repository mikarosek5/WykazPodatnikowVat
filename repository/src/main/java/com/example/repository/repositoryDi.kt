package com.example.repository

import com.example.repository.datasource.TaxPayerRepository
import com.example.repository.datasource.TaxPayerRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single{TaxPayerRepositoryImpl(get(),get()) as TaxPayerRepository }
}