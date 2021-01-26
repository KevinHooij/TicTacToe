package com.example.tictactoe.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tictactoe.model.GameItem
import com.example.tictactoe.api.GameApi
import com.example.tictactoe.api.GameApiService
import com.example.tictactoe.api.Zet
import kotlinx.coroutines.withTimeout

class GameRepository{
    private val gameApiService : GameApiService = GameApi.createApi()

    private val game: MutableLiveData<GameItem> = MutableLiveData()
    private val games: MutableLiveData<List<GameItem>> = MutableLiveData()

    val _game: LiveData<GameItem>
        get()  = game

    val _games: LiveData<List<GameItem>>
        get() = games


    suspend fun getGameInfo(id : Int){
        try {
            val result = withTimeout(5_000){
                gameApiService.getGameInfo(id)
            }
            game.value = result
        }
        catch (error: Throwable){
            throw LoadError("Something went wrong!", error)
        }
    }

    suspend fun getAllGames() {
        try {
            val result = withTimeout(5_000) {
                gameApiService.getAllGames()
            }

            games.value = result
        }
        catch (error: Throwable){
            throw LoadError("List couldn't be obtained", error)
        }


    }

    suspend fun newGame(){
        try{
            val result = withTimeout(5_000) {
                gameApiService.newGame()
            }

            games.value = result
        }
        catch(error: Throwable){
            throw LoadError("CAN'T MAKE NEW GAME :(", error)
        }
    }

   suspend fun updateGame(zet: Zet){

       try{
           val result = withTimeout(5_000){
                   gameApiService.updateGame(zet)
           }

           game.value = result
       }
       catch(error: Throwable){
           throw LoadError("Can't update game :'(", error)
       }

   }

    class LoadError(message: String, cause: Throwable) : Throwable(message, cause)
}