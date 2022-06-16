package com.aarafrao.cashflowquadrant

import android.R
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aarafrao.cashflowquadrant.databinding.ActivityBookmarkBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class BookmarkActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var bookmarksList: List<BookmarkModel>? = null
    private lateinit var binding: ActivityBookmarkBinding

    private var preferences: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null
    private var gson: Gson? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBookmarkBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        preferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
//        editor = preferences.edit()
//        gson = Gson()
//
//        getBookmarks()
//
//        val layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation = RecyclerView.VERTICAL
//
//        binding.rvBookmarks.setLayoutManager(layoutManager)
//
//        val adapter = BookmarkAdapter(bookmarksList)
//        binding.rvBookmarks.setAdapter(adapter)

    }
//
//    private fun getBookmarks() {
//        val json = preferences!!.getString(KEY_NAME, "")
//        val type: Type = object : TypeToken<List<BookmarkModel?>?>() {}.type
//        bookmarksList = gson!!.fromJson(json, type)
//        if (bookmarksList == null) {
//            bookmarksList = ArrayList()
//        }
//    }
//
//    private fun storeBookmarks() {
//        val json = gson!!.toJson(bookmarksList)
//        editor!!.putString(KEY_NAME, json)
//        editor!!.commit()
//
//    }
}