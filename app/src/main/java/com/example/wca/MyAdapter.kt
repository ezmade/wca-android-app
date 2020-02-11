package com.example.wca

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.persons_list_item.view.*

class MyAdapter(val persons : ArrayList<JSON>, val context: Context)  : RecyclerView.Adapter<ViewHolder>() {

    // Gets the number of persons in the list
    override fun getItemCount(): Int {
        return persons.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.persons_list_item, parent, false))
    }

    // Binds each person in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val avatarURL = persons[position].person.avatar.thumb_url
        Picasso.with(context).load(avatarURL).into(holder.PersonAvatar)
        holder.PersonName?.text = persons[position].person.name
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("person_name", persons[position].person.name)
            intent.putExtra("person_avatar", persons[position].person.avatar.url)
            intent.putExtra("person_Gold", persons[position].medals.gold.toString())
            intent.putExtra("person_Silver", persons[position].medals.silver.toString())
            intent.putExtra("person_Bronze", persons[position].medals.bronze.toString())
            intent.putExtra("person_TM", persons[position].medals.total.toString())
            intent.putExtra("person_NR", persons[position].records.national.toString())
            intent.putExtra("person_CR", persons[position].records.continental.toString())
            intent.putExtra("person_WR", persons[position].records.world.toString())
            intent.putExtra("person_TR", persons[position].records.total.toString())

            context.startActivity(intent)
        }

    }


}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each person to
    val PersonName = view.person_name
    val PersonAvatar = view.person_avatar
}