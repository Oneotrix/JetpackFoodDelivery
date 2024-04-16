package com.oneotrix.nti

import android.app.Application
import com.oneotrix.nti.di.appModule
import com.oneotrix.nti.di.repositoryModule
import com.oneotrix.nti.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NTI : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidLogger()

            androidContext(this@NTI)

            modules(listOf(
                appModule,
                repositoryModule,
                useCaseModule
            ))
        }
    }
}

