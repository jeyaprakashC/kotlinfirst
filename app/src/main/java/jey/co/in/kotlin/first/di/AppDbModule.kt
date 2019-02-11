package jey.co.`in`.kotlin.first.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import jey.co.`in`.kotlin.first.storage.AppDataBase
import jey.co.`in`.kotlin.first.storage.RoomDao

@Module
class AppDbModule(val application: Application) {

    var appDb: AppDataBase

    init {
        val DB_NAME = "App_database"
        appDb = Room.databaseBuilder(
            application.applicationContext, AppDataBase::class.java,
            DB_NAME
        )
            .build()
    }


    @Provides
    fun provideAppDb(): AppDataBase {
        return appDb
    }


    @Provides
    internal fun providesUsersDao(demoDatabase: AppDataBase): RoomDao {
        return demoDatabase.getDao()
    }


}