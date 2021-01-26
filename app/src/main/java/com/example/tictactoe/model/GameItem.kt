package com.example.tictactoe.model

import com.google.gson.annotations.SerializedName

data class GameItem(

        @SerializedName ("id") var id : Int,
        @SerializedName ("nameP1") var nameP1 : String,
        @SerializedName("nameP2") var nameP2 : String,
        @SerializedName("turn") var turn : Int,

        @SerializedName("moves") var moves : Moves,

        )

data class Moves(

        @SerializedName("a1") var a1 : Int,
        @SerializedName("a2") var a2 : Int,
        @SerializedName("a3") var a3 : Int,

        @SerializedName("b1") var b1 : Int,
        @SerializedName("b2") var b2 : Int,
        @SerializedName("b3") var b3 : Int,

        @SerializedName("c1") var c1 : Int,
        @SerializedName("c2") var c2 : Int,
        @SerializedName("c3") var c3 : Int

)