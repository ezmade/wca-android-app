package com.example.wca

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.persons_list_item.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyAdapter( val context: Context)  : RecyclerView.Adapter<ViewHolder>() {

    var users: ArrayList<JSON_User> = ArrayList()
    val detailActivity: DetailActivity = DetailActivity()

    fun setListUsers(user: JSON_User) {
        this.users.add(user)
        notifyDataSetChanged()
    }
    // Gets the number of persons in the list
    override fun getItemCount(): Int {
        return users.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.persons_list_item, parent, false))
    }

    // Binds each person in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val avatarURL = users[position].user.avatar.thumb_url
        Picasso.with(context).load(avatarURL).into(holder.PersonAvatar)
        holder.PersonName.text = users[position].user.name
        //(detailActivity as AppCompatActivity).supportActionBar?.title = users[position].user.wca_id
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)


            val person_wca_id = "person_wca_id"
            val person_name = "person_name"
            val person_avatar = "person_avatar"
            val person_Gold = "person_Gold"
            val person_Silver = "person_Silver"
            val person_Bronze = "person_Bronze"
            val person_TM = "person_TM"
            val person_NR = "person_NR"
            val person_CR = "person_CR"
            val person_WR = "person_WR"
            val person_TR = "person_TR"
            val person_Comps = "person_Comps"

            var service = RetrofitService.makeRetrofitService()
            service.getPersonInfo(users[position].user.wca_id).enqueue(object : Callback<JSON_Person> {
                override fun onResponse(call: Call<JSON_Person>, response: Response<JSON_Person>) {
                    if (response.body() != null) {
                        intent.putExtra(person_wca_id, users[position].user.wca_id)
                        intent.putExtra(person_name, response.body()!!.person.name)
                        intent.putExtra(person_avatar, response.body()!!.person.avatar.url)
                        intent.putExtra(person_Gold, response.body()!!.medals.gold.toString())
                        intent.putExtra(person_Silver, response.body()!!.medals.silver.toString())
                        intent.putExtra(person_Bronze, response.body()!!.medals.bronze.toString())
                        intent.putExtra(person_TM, response.body()!!.medals.total.toString())
                        intent.putExtra(person_NR, response.body()!!.records.national.toString())
                        intent.putExtra(person_CR, response.body()!!.records.continental.toString())
                        intent.putExtra(person_WR, response.body()!!.records.world.toString())
                        intent.putExtra(person_TR, response.body()!!.records.total.toString())
                        intent.putExtra(person_Comps, response.body()!!.competition_count.toString())

                        context.startActivity(intent)
                    }
                }

                override fun onFailure(call: Call<JSON_Person>, t: Throwable) {
                    println("Failed")
                }
            })
        }

    }


}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each person to
    val PersonName = view.person_name
    val PersonAvatar = view.person_avatar
}