package com.example.taskappkotlin.di

import com.example.taskappkotlin.presentation.add.AddActivity
import com.example.taskappkotlin.presentation.main.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface ShopComponent {

    fun inject(mainActivity: MainActivity)

    fun injectAddActivity(addActivity: AddActivity)

}