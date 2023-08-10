package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()

        val recyclerView = findViewById<RecyclerView>(R.id.rvMultipleViews)
        var isAppear = true

        val button = findViewById<Button>(R.id.btnShowHideRv)

        button.setOnClickListener {

            isAppear = !isAppear
            recyclerView.isVisible = isAppear
        }

    }


    private fun setUpRecyclerView() {

        val itemList = listOf(
            ListItem.Header("Header1"),
            ListItem.TextItem("text item 1"),
            ListItem.TextItem("text item 2"),
            ListItem.TextItem("text item 3"),
            ListItem.TextItem("text item 4"),
            ListItem.Header("Header2"),
            ListItem.ImageItem(R.drawable.cr7),
            ListItem.ImageItem(R.drawable.cr7),
            ListItem.ImageItem(R.drawable.cr7),
            ListItem.ImageItem(R.drawable.cr7),
            ListItem.Header("Header3"),
            ListItem.TextItem("text item 5"),
            ListItem.TextItem("text item 6"),
            ListItem.TextItem("text item 7"),
            ListItem.TextItem("text item 8"),
            ListItem.Header("Header4"),
            ListItem.ImageItem(R.drawable.cr7),
            ListItem.ImageItem(R.drawable.cr7),
            ListItem.ImageItem(R.drawable.cr7),
            ListItem.ImageItem(R.drawable.cr7),

            )
        val multipleViewsAdapter = MultipleViewsAdapter(itemList)

        val recyclerView = findViewById<RecyclerView>(R.id.rvMultipleViews)
        recyclerView.apply {
            adapter = multipleViewsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }






}