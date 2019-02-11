package jey.co.`in`.kotlin.first.home.photos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import jey.co.`in`.kotlin.first.R
import jey.co.`in`.kotlin.first.models.Photos
import kotlinx.android.synthetic.main.list_photos.view.*

class PhotoListAdaptor() : RecyclerView.Adapter<PhotoListAdaptor.PhotoViewHolder>() {


    var context: Context? = null
    var mCollection: List<Photos> = mutableListOf()


    fun setCollections(collections: List<Photos>) {

        if (collections != null)
            mCollection = collections
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.list_photos, parent, false)
        return PhotoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mCollection.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {

        holder.photoName.text = mCollection.get(position).title

        Picasso.with(context)
            .load(mCollection.get(position).thumbnailUrl).fit().centerCrop()
            .placeholder(R.mipmap.ic_launcher)
            .into(holder.thumbnail);
    }


    inner class PhotoViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val thumbnail: ImageView = view.thumbnail
        val photoName: TextView = view.photoname

    }
}