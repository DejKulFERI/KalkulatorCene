package com.feri.kalkulatorcene

import android.app.Application

import android.content.ComponentCallbacks2
import android.content.Context
import androidx.viewbinding.BuildConfig
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.apache.commons.io.FileUtils.readFileToString
import org.apache.commons.io.FileUtils.writeStringToFile
import java.io.File
import java.io.IOException
import java.util.*
import kotlin.random.Random

const val MY_FILE_NAME = "mydata.json"

class MyApplication : Application() {
    var articleList: MutableList<Article> = arrayListOf()
    private lateinit var gson: Gson
    private lateinit var file: File
    override fun onCreate() {
        super.onCreate()
        gson = Gson()
        file = File(filesDir, MY_FILE_NAME)
        initData()
    }

    fun initData() {
        articleList = try {
            val sType = object : TypeToken<MutableList<Article>>() {}.type
            gson.fromJson(readFileToString(file), sType)
        } catch (e: IOException) {
            val articles: MutableList<Article> = arrayListOf()
            articles
        }
    }

    fun saveToFile() {
        try {
            writeStringToFile(file, gson.toJson(articleList))

        } catch (e: IOException) {

        }
    }

    override fun onTerminate() {
        saveToFile()
        super.onTerminate()
    }
}