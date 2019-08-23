package com.example.ktaqiproject.network

interface INetworkController {
    fun initRetrofit()

    // api 1.1
    fun loadAqiData()
}