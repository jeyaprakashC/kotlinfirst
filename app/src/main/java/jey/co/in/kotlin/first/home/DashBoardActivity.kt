package jey.co.`in`.kotlin.first.home

import android.os.AsyncTask
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentTransaction
import jey.co.`in`.kotlin.first.AppDataRepository
import jey.co.`in`.kotlin.first.R
import jey.co.`in`.kotlin.first.di.AppDbModule
import jey.co.`in`.kotlin.first.di.DaggerAppComponent
import jey.co.`in`.kotlin.first.home.photos.PhotoListFragment
import jey.co.`in`.kotlin.first.home.users.UserDetailsFragment
import jey.co.`in`.kotlin.first.home.users.UsersListFragment
import kotlinx.android.synthetic.main.activity_dash_board.*
import javax.inject.Inject

class DashBoardActivity : AppCompatActivity() {


    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    @Inject
    lateinit var repository: AppDataRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        setSupportActionBar(toolbar)
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        container.adapter = mSectionsPagerAdapter
        val daggerAppComponent = DaggerAppComponent.builder().appDbModule(AppDbModule(application)).build()

        daggerAppComponent.inject(this)



       object :AsyncTask<Void,Void,Void?>(){
           override fun doInBackground(vararg params: Void?): Void? {

               val users=repository.getUsers()
               return null
           }
       }.execute()

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_dash_board, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }


    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment? {

            var fragment: Fragment? = null
            when (position) {
                0 ->
                    fragment = PhotoListFragment.newInstance()

                1 ->
                    fragment = UsersListFragment.newInstance()

            }
            return fragment
        }

        override fun getCount(): Int {
            return 2
        }
    }


    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        }
    }

    fun showDetailsFragment(position: Int) {

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val detailsFragment = UserDetailsFragment()
        val bundle: Bundle = Bundle()
        bundle.putInt("position", position)
        detailsFragment.arguments = bundle
        fragmentTransaction.replace(R.id.container, detailsFragment)
        fragmentTransaction.addToBackStack("details")
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        fragmentTransaction.commit()
    }


}
