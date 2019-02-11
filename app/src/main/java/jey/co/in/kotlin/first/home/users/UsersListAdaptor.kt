package jey.co.`in`.kotlin.first.home.users

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import jey.co.`in`.kotlin.first.R
import jey.co.`in`.kotlin.first.models.Users
import kotlinx.android.synthetic.main.activity_user_list.view.*

class UsersListAdaptor() :
    RecyclerView.Adapter<UsersListAdaptor.UsersViewHolder>() {
    lateinit var myDataLsit: List<Users>

    override fun onCreateViewHolder(view: ViewGroup, p1: Int): UsersViewHolder {

        val layoutInflator = LayoutInflater.from(view.context)
        val mView = layoutInflator.inflate(R.layout.activity_user_list, view, false)
        return UsersViewHolder(mView)


    }

    override fun getItemCount(): Int {
        return myDataLsit.size
    }

    override fun onBindViewHolder(viewHolder: UsersViewHolder, position: Int) {

        viewHolder.name.text = myDataLsit.get(position).name
    }


    inner class UsersViewHolder(val view: View) : RecyclerView.ViewHolder(view) {


        val icon: ImageView = view.imageView

        val name: TextView = view.textView3


    }


}


