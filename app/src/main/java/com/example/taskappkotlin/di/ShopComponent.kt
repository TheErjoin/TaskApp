package com.example.taskappkotlin.di

import com.example.taskappkotlin.presentation.activity.MainActivity
import com.example.taskappkotlin.presentation.fragment.add.AddFragment
import com.example.taskappkotlin.presentation.fragment.main.MainFragment
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface ShopComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(fragment: MainFragment)

    fun inject(fragment: AddFragment)

}