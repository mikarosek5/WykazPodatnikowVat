package com.example.wykaz_podatnikow_vat

import android.app.Application
import com.example.network.networkModule
import com.example.repository.repositoryModule

import com.jakewharton.threetenabp.AndroidThreeTen
import database.databaseModule
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App :Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(networkModule,databaseModule, repositoryModule))
            androidLogger()
            AndroidThreeTen.init(this@App)
        }
    }
}
