package jey.co.`in`.kotlin.first.home.users

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import jey.co.`in`.kotlin.first.R
import jey.co.`in`.kotlin.first.home.DashBoardActivity
import jey.co.`in`.kotlin.first.home.DashBoardViewModel
import kotlinx.android.synthetic.main.fragment_user_details_view.*

class UserDetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_user_details_view, container, false)



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewmodel = ViewModelProviders.of(activity as DashBoardActivity).get(DashBoardViewModel::class.java)
        val position: Int? = arguments?.getInt("position")


        object : AsyncTask<Void, Void, String>() {

            override fun doInBackground(vararg params: Void?): String? {
                if (position != null) {
                    val nameText: String = viewmodel.loadUsers().get(position).name
                    name.text = nameText

                }
                return null
            }
        }.execute()


    }
}