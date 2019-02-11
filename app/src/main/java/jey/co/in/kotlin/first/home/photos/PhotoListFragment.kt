package jey.co.`in`.kotlin.first.home.photos

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import jey.co.`in`.kotlin.first.R
import jey.co.`in`.kotlin.first.home.DashBoardActivity
import jey.co.`in`.kotlin.first.home.DashBoardViewModel
import jey.co.`in`.kotlin.first.models.Photos
import kotlinx.android.synthetic.main.fragment_users_list.*

class PhotoListFragment : Fragment() {


    var viewManager: LinearLayoutManager? = null

    lateinit var viewAdaptor: PhotoListAdaptor

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_users_list, container, false)

        viewManager = LinearLayoutManager(this.context)

        val viewmodel = ViewModelProviders.of(activity as DashBoardActivity).get(DashBoardViewModel::class.java)


        viewmodel.getPhotos().observe(this, object : Observer<List<Photos>> {
            override fun onChanged(t: List<Photos>?) {

                if (t != null) {

                    Log.d("PhotoListFragment", "onChanged")
                    viewAdaptor?.setCollections(t)
                    viewAdaptor?.notifyDataSetChanged()
                }
            }
        })

        viewAdaptor = PhotoListAdaptor()

        object : AsyncTask<Void, Void, Void>() {

            override fun doInBackground(vararg params: Void?): Void? {

                viewAdaptor?.setCollections(viewmodel.loadPhotos())
                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)

                recyleview.apply {
                    adapter = viewAdaptor
                    layoutManager = viewManager
                    setHasFixedSize(true)
                }
            }


        }.execute()

        return view
    }


    companion object {

        fun newInstance(): PhotoListFragment {
            return PhotoListFragment()
        }
    }
}