package com.example.languageapp.adapters

import android.view.LayoutInflater.from
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import coil.load
import coil.transform.CircleCropTransformation
import com.example.languageapp.R
import com.example.languageapp.R.layout.item_user_rating
import com.example.languageapp.R.string.first_second_names_pair
import com.example.languageapp.database.User

class LeaderBoardAdapter (
    private val itemList: List<User>
) : Adapter<LeaderBoardAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivUserPhoto: ImageView = itemView.findViewById(R.id.ivUserPhoto)
        private val tvUserName: TextView = itemView.findViewById(R.id.tvUserName)
        private val tvPoints: TextView = itemView.findViewById(R.id.tvPoints)

        fun bind(user: User) {
            val context = ivUserPhoto.context
            ivUserPhoto.load(user.photoUrl) {
                fallback(R.drawable.default_user_photo)
                transformations(CircleCropTransformation())
            }
            tvUserName.text = context.getString(first_second_names_pair, user.firstName, user.secondName)
            tvPoints.text = user.points.toString()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = from(parent.context).inflate(item_user_rating, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(itemList[position])

    override fun getItemCount(): Int = itemList.size
}