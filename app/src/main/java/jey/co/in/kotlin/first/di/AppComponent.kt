package jey.co.`in`.kotlin.first.di

import dagger.Component
import jey.co.`in`.kotlin.first.home.DashBoardActivity
import jey.co.`in`.kotlin.first.storage.RoomDao

@Component(modules = arrayOf(AppDbModule::class))
interface AppComponent {

    fun inject(activity: DashBoardActivity)

    fun getRoomDao(): RoomDao
}