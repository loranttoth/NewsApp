package com.loranttoth.newsapp.di

import com.loranttoth.newsapp.presentation.MainActivity
import dagger.Subcomponent


@NewsScope
@Subcomponent(modules = [NewsModule::class])
interface NewsSubComponent {
    fun inject(newsActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): NewsSubComponent
    }



}