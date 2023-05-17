package com.example.app_03_02.model

import com.example.app_03_02.data.api.CentrosApi

class CentrosRepository {
    suspend fun  get(): List<Centro> = CentrosApi.retrofitService.getCentros()
}