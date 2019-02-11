package jey.co.`in`.kotlin.first

import jey.co.`in`.kotlin.first.models.Users
import jey.co.`in`.kotlin.first.storage.RoomDao
import javax.inject.Inject


class AppDataRepository @Inject constructor(val roomDao: RoomDao) {


    fun getUsers(): List<Users> {
        return roomDao.getUsers()
    }


}