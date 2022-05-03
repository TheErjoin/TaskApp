package com.example.taskappkotlin

import android.app.Application
import android.content.Context
import com.example.taskappkotlin.di.AppModule
import com.example.taskappkotlin.di.DaggerShopComponent
import com.example.taskappkotlin.di.ShopComponent

class App : Application() {

    lateinit var shopComponent: ShopComponent

    override fun onCreate() {
        super.onCreate()

        shopComponent = DaggerShopComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()

    }

}

val Context.shopComponent: ShopComponent
    get() = when (this) {
        is App -> shopComponent
        else -> applicationContext.shopComponent
    }
