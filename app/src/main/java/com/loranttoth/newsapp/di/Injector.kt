package com.loranttoth.newsapp.di

interface Injector {
    fun createNewsSubComponent(): NewsSubComponent
}