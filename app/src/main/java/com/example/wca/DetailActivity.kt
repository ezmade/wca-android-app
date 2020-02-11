package com.example.wca

import android.os.Bundle
import android.widget.ImageView

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_card)
        val labelName: TextView = findViewById<TextView>(R.id.name)
        val avatar: ImageView = findViewById(R.id.avatar)
        val resGold: TextView = findViewById(R.id.resGold)
        val resSilver: TextView = findViewById(R.id.resSilver)
        val resBronze: TextView = findViewById(R.id.resBronze)
        val resTM: TextView = findViewById(R.id.resTM)
        val resNR: TextView = findViewById(R.id.resNR)
        val resCR: TextView = findViewById(R.id.resCR)
        val resWR: TextView = findViewById(R.id.resWR)
        val resTR: TextView = findViewById(R.id.resTR)

        intent
        val name = intent.getStringExtra("person_name")
        val avatar_url = intent.getStringExtra("person_avatar")
        val Gold = intent.getStringExtra("person_Gold" )
        val Silver = intent.getStringExtra("person_Silver")
        val Bronze = intent.getStringExtra("person_Bronze")
        val TM = intent.getStringExtra("person_TM")
        val NR = intent.getStringExtra("person_NR")
        val CR = intent.getStringExtra("person_CR")
        val WR = intent.getStringExtra("person_WR")
        val TR = intent.getStringExtra("person_TR")

        labelName.text = name
        Picasso.with(this).load(avatar_url).into(avatar)
        resGold.text = Gold.toString()
        resSilver.text = Silver.toString()
        resBronze.text = Bronze.toString()
        resTM.text = TM.toString()
        resNR.text = NR.toString()
        resCR.text = CR.toString()
        resWR.text = WR.toString()
        resTR.text = TR.toString()
    }
}