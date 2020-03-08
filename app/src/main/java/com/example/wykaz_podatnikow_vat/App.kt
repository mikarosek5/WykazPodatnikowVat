package com.example.wykaz_podatnikow_vat

import android.app.Application
import com.example.network.networkModule
import com.example.repository.repositoryModule
import com.example.wykaz_podatnikow_vat.ui.UiModule

import com.jakewharton.threetenabp.AndroidThreeTen
import database.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App :Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule,databaseModule, repositoryModule, UiModule))
            androidLogger()
            AndroidThreeTen.init(this@App)
        }
    }
}
