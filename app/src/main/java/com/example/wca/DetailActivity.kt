package com.example.wca

import android.R.attr
import android.R.id
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toBitmap
import com.google.firebase.analytics.FirebaseAnalytics
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_person_card.*
import java.io.File
import java.io.FileOutputStream


class DetailActivity : AppCompatActivity(){
    private var mFirebaseAnalytics: FirebaseAnalytics? = null

    private fun share(image: Bitmap?, name: String, comps: Int, id: String) {
        val file = File(this.externalCacheDir?.path + "/image.png")
        val shareText = "Hey there! " + name + " has already taken part at " + comps + " speedcubing competitions! Do you want to see the results? Visit the profile at https://www.worldcubeassociation.org/persons/" + id
        FileOutputStream(file).apply {
            image?.compress(Bitmap.CompressFormat.PNG, 100, this)
            flush()
            close()
        }
        val intent = Intent(Intent.ACTION_SEND)
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        intent.putExtra(Intent.EXTRA_STREAM,  FileProvider.getUriForFile(this, "com.ezmade.fileprovider", file))
        intent.putExtra(Intent.EXTRA_TEXT, shareText)
        intent.type = "image/*"
        startActivity(Intent.createChooser(intent, "Share results"))
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_card)
    }

    override fun onStart() {
        super.onStart()
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
        val resComps: TextView = findViewById(R.id.resComps)


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

        intent
        val wca_id = intent.getStringExtra(person_wca_id)
        val name = intent.getStringExtra(person_name)
        val avatar_url = intent.getStringExtra(person_avatar)
        val Gold = intent.getStringExtra(person_Gold)
        val Silver = intent.getStringExtra(person_Silver)
        val Bronze = intent.getStringExtra(person_Bronze)
        val TM = intent.getStringExtra(person_TM)
        val NR = intent.getStringExtra(person_NR)
        val CR = intent.getStringExtra(person_CR)
        val WR = intent.getStringExtra(person_WR)
        val TR = intent.getStringExtra(person_TR)
        val Comps = intent.getStringExtra(person_Comps)

        this.supportActionBar?.title = wca_id
        labelName.text = name
        Picasso.with(this).load(avatar_url).into(avatar)
        resGold.text = Gold?.toString()
        resSilver.text = Silver?.toString()
        resBronze.text = Bronze?.toString()
        resTM.text = TM?.toString()
        resNR.text = NR?.toString()
        resCR.text = CR?.toString()
        resWR.text = WR?.toString()
        resTR.text = TR?.toString()
        resComps.text = Comps?.toString()

        btn_ViewProfile.setOnClickListener{
            val bundle = Bundle()
            bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "btn_ViewProfile")
            bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "button_view_click")
            mFirebaseAnalytics!!.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
            val urls: String = this.supportActionBar?.title.toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.worldcubeassociation.org/persons/" + urls))
            startActivity(intent)
        }

        btn_Share.setOnClickListener{
            val bundle = Bundle()
            bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "btn_Share")
            bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "button_share_click")
            mFirebaseAnalytics!!.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)

            share(avatar.drawable.toBitmap(), name.toString(), Comps.toInt(), this.supportActionBar?.title.toString())
        }
    }
}