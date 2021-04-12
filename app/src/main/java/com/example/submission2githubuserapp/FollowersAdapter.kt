package com.example.submission2githubuserapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.user_item.view.*

var followersFilterList = ArrayList<UserData>()

class FollowersAdapter(listUser: ArrayList<UserData>) :
    RecyclerView.Adapter<FollowersAdapter.ListViewHolder>() {
    init {
        followersFilterList = listUser
    }

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): FollowersAdapter.ListViewHolder {
        val view: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.user_item, viewGroup, false)
        val sch = ListViewHolder(view)
        mcontext = viewGroup.context
        return sch
    }

    override fun getItemCount(): Int = followersFilterList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = followersFilterList[position]
        Glide.with(holder.itemView.context)
            .load(data.avatar)
            .apply(RequestOptions().override(250, 250))
            .into(holder.imgAvatar)
        holder.txtUsername.text = data.username
        holder.txtName.text = data.name
        holder.txtCompany.text = data.company
        holder.txtLocation.text = data.location
        holder.itemView.setOnClickListener {
            //DO NOTHING
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(UserData: UserData)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgAvatar: CircleImageView = itemView.img_avatar
        var txtUsername: TextView = itemView.txt_username
        var txtName: TextView = itemView.txt_name
        var txtCompany: TextView = itemView.txt_company
        var txtLocation: TextView = itemView.txt_location
    }

}