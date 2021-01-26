package com.example.tictactoe.api

import com.example.tictactoe.model.GameItem
import retrofit2.http.*

interface GameApiService{

    @GET("/game/{game_id}")
    suspend fun getGameInfo(
            @Path ("game_id")id : Int
    ) : GameItem

    @GET("/games/getAll")
    suspend fun getAllGames() : List<GameItem>

    @POST("/games/newGame")
    suspend fun newGame() : List<GameItem>

    @POST("/games/update")
    suspend fun updateGame(@Body zet: Zet) : GameItem


}

data class Zet(
        var RoomID: Int,
        var zetGebruiker: String
)