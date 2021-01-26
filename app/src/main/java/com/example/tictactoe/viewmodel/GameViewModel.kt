package com.example.tictactoe.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.tictactoe.api.Zet
import com.example.tictactoe.repository.GameRepository
import kotlinx.coroutines.launch

class GameViewModel(application: Application) : AndroidViewModel(application){

    private val gameRepository = GameRepository()

    val game = gameRepository._game
    val games = gameRepository._games

    private val _errorText: MutableLiveData<String> = MutableLiveData()

    val errorText: LiveData<String>
        get() = _errorText


    fun getGameInfo(id : Int){
        viewModelScope.launch{
            try{
                gameRepository.getGameInfo(id)
            }
            catch(error: GameRepository.LoadError){
                _errorText.value = error.message
                Log.e("ERROR", error.cause.toString())
            }
        }
    }

    fun getAllGames(){
        viewModelScope.launch{
            try{
                gameRepository.getAllGames()
            }
            catch(error: GameRepository.LoadError){
                _errorText.value = error.message
                Log.e("ERROR", error.cause.toString())
            }
        }
    }

    fun newGame(){
        viewModelScope.launch{
            try{
                gameRepository.newGame()
            }
            catch(error: GameRepository.LoadError){
                _errorText.value = error.message
            }
        }
    }

   fun updateGame(zet: Zet){
       viewModelScope.launch{
           try {
               gameRepository.updateGame(zet)
           }
           catch(error: GameRepository.LoadError){
               _errorText.value = error.message
           }
       }
   }
}

