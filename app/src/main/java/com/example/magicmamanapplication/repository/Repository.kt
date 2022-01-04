package com.example.magicmamanapplication.repository

import com.example.magicmamanapplication.Retrofit.RetrofitInstance
import com.example.magicmamanapplication.data.*
import retrofit2.Response

class Repository {

    suspend fun getCustomtete(userId: Int, sort: String, order: String): Response<List<teteItem>> {
        return RetrofitInstance.api.gettete(userId, sort, order)
    }

    suspend fun getCustomsolide(userId: Int, sort: String, order: String): Response<List<SolideItem>> {
        return RetrofitInstance.api.getsolide(userId, sort, order)
    }

    suspend fun getCustombibron(userId: Int, sort: String, order: String): Response<List<BibronItem>> {
        return RetrofitInstance.api.getbibron(userId, sort, order)
    }

    suspend fun getCustomsommeil(userId: Int, sort: String, order: String): Response<List<SommeilItem>> {
        return RetrofitInstance.api.getsommeil(userId, sort, order)
    }

    suspend fun getCustomtaille(userId: Int, sort: String, order: String): Response<List<TailleItem>> {
        return RetrofitInstance.api.gettaille(userId, sort, order)
    }

    suspend fun getCustompoids(userId: Int, sort: String, order: String): Response<List<PoidsItem>> {
        return RetrofitInstance.api.getpoids(userId, sort, order)
    }

    suspend fun getCustomvaccin(userId: Int, sort: String, order: String): Response<List<VaccinItem>> {
        return RetrofitInstance.api.getvaccin(userId, sort, order)
    }

    suspend fun getCustommedicament(userId: Int, sort: String, order: String): Response<List<MedicamentItem>> {
        return RetrofitInstance.api.getmedicament(userId, sort, order)
    }

    suspend fun getCustomtemperature(userId: Int, sort: String, order: String): Response<List<TemperatureItem>> {
        return RetrofitInstance.api.gettemperature(userId, sort, order)
    }

}