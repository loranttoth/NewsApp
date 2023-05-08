package com.loranttoth.newsapp

import android.app.Application
import com.loranttoth.newsapp.di.*


class App: Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }


    override fun createNewsSubComponent(): NewsSubComponent {
        return appComponent.newsSubComponent().create()
    }


}