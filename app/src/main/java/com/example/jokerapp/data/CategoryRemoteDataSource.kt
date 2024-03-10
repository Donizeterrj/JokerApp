package com.example.jokerapp.data

import android.os.Handler
import android.os.Looper
import android.util.Log

class CategoryRemoteDataSource {

    fun findAllCategories(callback: LIstCategoryCallback) {
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                "Categoria 1",
                "Categoria 2",
                "Categoria 3",
                "Categoria 4",
            )
            Log.i("teste", response.toString())

            callback.onSuccess(response)

            callback.onComplete()
        }, 5000)

    }

}