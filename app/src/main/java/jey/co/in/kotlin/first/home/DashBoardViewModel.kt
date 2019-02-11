package jey.co.`in`.kotlin.first.home

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import jey.co.`in`.kotlin.first.models.Photos
import jey.co.`in`.kotlin.first.models.Users
import jey.co.`in`.kotlin.first.network.AppNetworkInterface
import jey.co.`in`.kotlin.first.network.NetworkDataProvider
import retrofit2.Call


class DashBoardViewModel(application: Application) : AndroidViewModel(application) {


    var appContext: Context

    init {
        appContext = application.applicationContext
    }

    var photos: List<Photos> = mutableListOf()
    var users: List<Users> = mutableListOf()


    private val photosLiveData = MutableLiveData<List<Photos>>()

    fun getPhotos(): LiveData<List<Photos>> {

        return photosLiveData
    }





    fun loadPhotos(): List<Photos> {

//        if (photos.size == 0) {
//
//
//            val values: List<Photos>? = AppDataBase.getInstance(appContext)?.getDao()?.getPhotos()
//
//           // fetchPhotosFromServer()
//
//            if (values != null) {
//                return values
//            }
//
//
//            return photos
//        }

        return photos
    }


    fun loadUsers(): List<Users> {

        if (users.size == 0) {


            //val values: List<Users>? = AppDataBase.getInstance(appContext)?.getDao()?.getUsers()

           // fetchUsersFromServer()

//            if (values != null) {
//                return values
//            }


            return users
        }

        return users
    }


    fun fetchPhotosFromServer() {
        val photos = NetworkDataProvider().getPlaceHolderClient().create(AppNetworkInterface::class.java)

        val response: Call<List<Photos>> = photos.getAlbums()

//        response.enqueue(object : Callback<List<Photos>> {
//            override fun onFailure(call: Call<List<Photos>>, t: Throwable) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onResponse(call: Call<List<Photos>>, response: Response<List<Photos>>) {
//
//                object : AsyncTask<Void, Void, Void>() {
//
//                    override fun doInBackground(vararg params: Void?): Void? {
//
//                        val photosResponse: List<Photos>? = response.body()
//
//                        if (photosResponse != null)
//                            for (photo in photosResponse) {
//
//                                val album = AppDataBase.getInstance(appContext)?.getDao()?.getphotos(photo.id)
//                                if (album != null) {
//                                    AppDataBase.getInstance(appContext)?.getDao()?.updatePhotos(photo)
//                                } else {
//                                    AppDataBase.getInstance(appContext)?.getDao()?.addphots(photo)
//                                }
//                            }
//                        Log.d("PhotoListFragment", "posting")
//
//                        photosLiveData.postValue(photosResponse)
//
//                        return null
//                    }
//
//
//                }.execute()
//
//            }
//        })
    }


    fun fetchUsersFromServer() {
        val nwinterface = NetworkDataProvider().getPlaceHolderClient().create(AppNetworkInterface::class.java)

        val response: Call<List<Users>> = nwinterface.getUsers()

//        response.enqueue(object : Callback<List<Users>> {
//            override fun onFailure(call: Call<List<Users>>, t: Throwable) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
//
//                object : AsyncTask<Void, Void, Void>() {
//
//                    override fun doInBackground(vararg params: Void?): Void? {
//
//                        val responseBody: List<Users>? = response.body()
//
//                        if (responseBody != null)
//                            for (user in responseBody) {
//
//                                val usrfromdb = AppDataBase.getInstance(appContext)?.getDao()?.getUser(user.id)
//                                if (usrfromdb != null) {
//                                    AppDataBase.getInstance(appContext)?.getDao()?.updateUsers(user)
//                                } else {
//                                    AppDataBase.getInstance(appContext)?.getDao()?.addUsers(user)
//                                }
//                            }
//
//                        return null
//                    }
//
//
//                }.execute()
//
//            }
//        })
    }

}