package com.example.jokerapp.presentation

import com.example.jokerapp.view.JokeDayFragment
import com.example.jokerapp.data.JokeCallback
import com.example.jokerapp.data.JokeDayRemoteDataSource
import com.example.jokerapp.model.Joke

class JokeDayPresenter(
    private val view: JokeDayFragment,
    private val dataSource: JokeDayRemoteDataSource = JokeDayRemoteDataSource()
): JokeCallback {

    fun findRandom(){
        view.visibilityProgressBar(true)
        dataSource.findRandom(this)
    }

    override fun onSuccess(response: Joke) {
        view.showJokeDay(response)
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.visibilityProgressBar(false)
    }
}