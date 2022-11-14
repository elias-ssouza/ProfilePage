package com.example.profilepage.data

import android.telecom.Call

interface SoccerNewsApi {

    @get:GET("news.json")
    val news: Call<List<Profile?>?>?
