package com.example.wykaz_podatnikow_vat.ui

import com.example.wykaz_podatnikow_vat.ui.bank.BankViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val UiModule = module {
    viewModel { BankViewModel(get(),get(named("bankDisposable"))) }
}