package com.example.jokerapp.presentation

import com.example.jokerapp.data.JokeCallback
import com.example.jokerapp.data.JokeRemoteDataSource
import com.example.jokerapp.model.Joke
import com.example.jokerapp.view.JokeFragment

class JokePresenter(
    private val view: JokeFragment,
    private val dataSource: JokeRemoteDataSource = JokeRemoteDataSource()
): JokeCallback {

    fun findBy(categoryName: String){
        view.visibilityProgressBar(true)
        dataSource.findBy(categoryName, this)
    }
    override fun onSuccess(response: Joke) {
        view.showJoke(response)
    }

    override fun onError(response: String) {
        view.showFailure(response)

    }

    override fun onComplete() {
        view.visibilityProgressBar(false)
    }
}