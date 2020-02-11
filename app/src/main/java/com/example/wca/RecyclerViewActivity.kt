package com.example.wca

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity : Activity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var Dataset: Array<String> = arrayOf("{\n" +
                "  \"user\": {\n" +
                "    \"class\": \"user\",\n" +
                "    \"url\": \"https://www.worldcubeassociation.org/persons/2014BOYK01\",\n" +
                "    \"id\": 53658,\n" +
                "    \"wca_id\": \"2014BOYK01\",\n" +
                "    \"name\": \"Anton Boyko\",\n" +
                "    \"gender\": \"m\",\n" +
                "    \"country_iso2\": \"RU\",\n" +
                "    \"delegate_status\": null,\n" +
                "    \"created_at\": \"2017-04-11T08:58:44.000Z\",\n" +
                "    \"updated_at\": \"2020-02-11T05:55:56.000Z\",\n" +
                "    \"teams\": [\n" +
                "\n" +
                "    ],\n" +
                "    \"avatar\": {\n" +
                "      \"url\": \"https://www.worldcubeassociation.org/uploads/user/avatar/2014BOYK01/1501332793.jpeg\",\n" +
                "      \"thumb_url\": \"https://www.worldcubeassociation.org/uploads/user/avatar/2014BOYK01/1501332793_thumb.jpeg\",\n" +
                "      \"is_default\": false\n" +
                "    }\n" +
                "  }\n" +
                "}")

        viewManager = LinearLayoutManager(this)
        viewAdapter = Adapter(Dataset)

        recyclerView = findViewById<RecyclerView>(R.id.persons_list).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }
    }
    // ...
}
