package com.example.jokerapp.presentation

import com.example.jokerapp.data.CategoryRemoteDataSource
import com.example.jokerapp.data.LIstCategoryCallback
import com.example.jokerapp.model.Category
import com.example.jokerapp.view.HomeFragment

class HomePresenter(private val view: HomeFragment,
                    private val dataSource: CategoryRemoteDataSource = CategoryRemoteDataSource()
): LIstCategoryCallback{
//    VIEW <- PRESENTER
//    PRESENTER <- VIEW

    fun findAllCategories() {
        view.visibilityProgressBar(true)
        dataSource.findAllCategories(this)
    }

    override fun onSuccess(response: List<String>){
        val categories = response.map { Category( it, 0xFFFF0000)}
        view.showCategories(categories)
    }

    override fun onError(response: String){
        view.showFailure(response)
    }

    override fun onComplete(){
        view.visibilityProgressBar(false)
    }

}

