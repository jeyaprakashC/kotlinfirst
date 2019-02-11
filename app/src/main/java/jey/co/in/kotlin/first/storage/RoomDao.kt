package jey.co.`in`.kotlin.first.storage

import androidx.lifecycle.LiveData
import androidx.room.*
import jey.co.`in`.kotlin.first.models.Photos
import jey.co.`in`.kotlin.first.models.Users

@Dao
interface RoomDao {


    @Query("SELECT * FROM Photos")
    fun getPhotos(): List<Photos>


    @Query("SELECT * FROM Photos")
    fun getPhotosLiveData(): LiveData<List<Photos>>

    @Query("select * from Photos where id = :id")
    fun getphotos(id: String): Photos

    @Insert
    fun addphots(vararg photos: Photos)

    @Update
    fun updatePhotos(vararg photos: Photos)

    @Delete
    fun removePhotos(vararg photos: Photos)


    //Users
    @Query("SELECT * FROM Users")
    fun getUsers(): List<Users>



    @Query("SELECT * FROM Users")
    fun getUsersLiveData(): LiveData<List<Users>>

    @Query("select * from Users where id = :id")
    fun getUser(id: String): Users

    @Insert
    fun addUsers(vararg users: Users)

    @Update
    fun updateUsers(vararg users: Users)

    @Delete
    fun removeUsers(vararg users: Users)


}