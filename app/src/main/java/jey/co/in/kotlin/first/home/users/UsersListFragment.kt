package jey.co.`in`.kotlin.first.home.users

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jey.co.`in`.kotlin.first.R
import jey.co.`in`.kotlin.first.home.DashBoardActivity
import jey.co.`in`.kotlin.first.home.DashBoardViewModel
import kotlinx.android.synthetic.main.fragment_users_list.*

class UsersListFragment : Fragment(), UserListClickListener {


    lateinit var viewManager: RecyclerView.LayoutManager
    lateinit var viewAdaptor: UsersListAdaptor

    lateinit var viewmodel: DashBoardViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_users_list, container, false)

        viewManager = LinearLayoutManager(activity)
        viewmodel = ViewModelProviders.of(activity as DashBoardActivity).get(DashBoardViewModel::class.java)
        viewAdaptor = UsersListAdaptor()



        usersObserver()
        return view
    }


    fun usersObserver() {

        val activityObject = activity as DashBoardActivity
//        AppDataBase.getInstance(activityObject.applicationContext)?.getDao()?.getUsersLiveData()?.observe(this,
//            Observer<List<Users>> { t ->
//                if (t != null) {
//
//                    Log.d("UsersListFragment", "users data changed ${t.size}")
//                    viewAdaptor?.myDataLsit = t
//
//                    viewAdaptor?.notifyDataSetChanged()
//
//                }
//            })

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        object : AsyncTask<Void, Void, Void>() {

            override fun doInBackground(vararg params: Void?): Void? {

                viewAdaptor.myDataLsit = viewmodel.loadUsers()

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
        recyleview.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
            }

            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {


                val child = rv.findChildViewUnder(e.x, e.y)

                Log.d("onInterceptTouchEvent", "" + e.action)


                if (child != null && e.action == MotionEvent.ACTION_DOWN) {
                    val position = rv.getChildAdapterPosition(child)
                    onClick(position)

                }

                return false
            }

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })


    }

    companion object {

        fun newInstance(): UsersListFragment {
            return UsersListFragment()
        }
    }

    override fun onClick(position: Int) {
        val containerActivity = activity as DashBoardActivity
        containerActivity.showDetailsFragment(position)
    }
}