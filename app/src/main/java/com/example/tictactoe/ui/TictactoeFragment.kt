package com.example.tictactoe.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.tictactoe.viewmodel.GameViewModel
import com.example.tictactoe.R
import com.example.tictactoe.api.Zet
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_tictactoe.*

class TictactoeFragment : Fragment() {

    private val viewModel: GameViewModel by viewModels()
    var gameId : Int = -1

    var winner : Boolean = false

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tictactoe, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeGameResults()
        observeGame()



        if (!winner) {
            onButtonPress()
        }

        Snackbar.make(view, "3 in a row wins you the game!", 5000).show()

    }

    private fun observeGameResults(){
        arguments?.let{
            val id = it.getString(GAME_BUNDLE_KEY)
            if (id != null){
                gameId = id.toInt()
                viewModel.getGameInfo(gameId)
            }
        }
    }

    private fun observeGame(){
        viewModel.game.observe(viewLifecycleOwner, {

            if (it.moves.a1 == 1){
                btnA1.setImageResource(R.drawable.cross)
            }
            if (it.moves.a2 == 1){
                btnA2.setImageResource(R.drawable.cross)
            }
            if (it.moves.a3 == 1){
                btnA3.setImageResource(R.drawable.cross)
            }

            if (it.moves.b1 == 1){
                btnB1.setImageResource(R.drawable.cross)
            }
            if (it.moves.b2 == 1){
                btnB2.setImageResource(R.drawable.cross)
            }
            if (it.moves.b3 == 1){
                btnB3.setImageResource(R.drawable.cross)
            }

            if (it.moves.c1 == 1){
                btnC1.setImageResource(R.drawable.cross)
            }
            if (it.moves.c2 == 1){
                btnC2.setImageResource(R.drawable.cross)
            }
            if (it.moves.c3 == 1){
                btnC3.setImageResource(R.drawable.cross)
            }

            if (it.moves.a1 == 2){
                btnA1.setImageResource(R.drawable.ic_launcher_background)
            }
            if (it.moves.a2 == 2){
                btnA2.setImageResource(R.drawable.ic_launcher_background)
            }
            if (it.moves.a3 == 2){
                btnA3.setImageResource(R.drawable.ic_launcher_background)
            }

            if (it.moves.b1 == 2){
                btnB1.setImageResource(R.drawable.ic_launcher_background)
            }
            if (it.moves.b2 == 2){
                btnB2.setImageResource(R.drawable.ic_launcher_background)
            }
            if (it.moves.b3 == 2){
                btnB3.setImageResource(R.drawable.ic_launcher_background)
            }

            if (it.moves.c1 == 2){
                btnC1.setImageResource(R.drawable.ic_launcher_background)
            }
            if (it.moves.c2 == 2){
                btnC2.setImageResource(R.drawable.ic_launcher_background)
            }
            if (it.moves.c3 == 2){
                btnC3.setImageResource(R.drawable.ic_launcher_background)
            }

//            if (it.moves.a1 == 1 && it.moves.a2 == 1 && it.moves.a3 == 1
//                    || it.moves.b1 == 1 && it.moves.b2 == 1 && it.moves.b3 == 1
//                    || it.moves.c1 == 1 && it.moves.c2 == 1 && it.moves.c3 == 1
//                    || it.moves.a1 == 1 && it.moves.b1 == 1 && it.moves.c1 == 1
//                    || it.moves.a2 == 1 && it.moves.b2 == 1 && it.moves.c2 == 1
//                    || it.moves.a3 == 1 && it.moves.b3 == 1 && it.moves.c3 == 1
//                    || it.moves.a1 == 1 && it.moves.b2 == 1 && it.moves.c3 == 1
//                    || it.moves.c1 == 1 && it.moves.b2 == 1 && it.moves.a3 == 1){
//
//                tvWinner.text = "VICTORY"
//                winner = true
//            }
//            else if (it.moves.a1 == 2 && it.moves.a2 == 2 && it.moves.a3 == 2
//                    || it.moves.b1 == 2 && it.moves.b2 == 2 && it.moves.b3 == 2
//                    || it.moves.c1 == 2 && it.moves.c2 == 2 && it.moves.c3 == 2
//                    || it.moves.a1 == 2 && it.moves.b1 == 2 && it.moves.c1 == 2
//                    || it.moves.a2 == 2 && it.moves.b2 == 2 && it.moves.c2 == 2
//                    || it.moves.a3 == 2 && it.moves.b3 == 2 && it.moves.c3 == 2
//                    || it.moves.a1 == 2 && it.moves.b2 == 2 && it.moves.c3 == 2
//                    || it.moves.c1 == 2 && it.moves.b2 == 2 && it.moves.a3 == 2){
//
//                tvWinner.text = "DEFEAT"
//                winner = true
//            }

            decideWinner(1, "VICTORY")
            decideWinner(2, "DEFEAT")
        })

    }

    private fun decideWinner(move : Int, announcement : String){
        viewModel.game.observe(viewLifecycleOwner, {

            if (it.moves.a1 == move && it.moves.a2 == move && it.moves.a3 == move
                    || it.moves.b1 == move && it.moves.b2 == move && it.moves.b3 == move
                    || it.moves.c1 == move && it.moves.c2 == move && it.moves.c3 == move
                    || it.moves.a1 == move && it.moves.b1 == move && it.moves.c1 == move
                    || it.moves.a2 == move && it.moves.b2 == move && it.moves.c2 == move
                    || it.moves.a3 == move && it.moves.b3 == move && it.moves.c3 == move
                    || it.moves.a1 == move && it.moves.b2 == move && it.moves.c3 == move
                    || it.moves.c1 == move && it.moves.b2 == move && it.moves.a3 == move) {

                tvWinner.text = announcement
                winner = true
            }
        })

    }

    private fun onButtonPress(){
        viewModel.game.observe(viewLifecycleOwner, {

            Log.d("tag", it.toString())

            if (it.moves.a1 == 0) {
                btnA1.setOnClickListener {

                    giveMove("a1")

                }
            }

            if (it.moves.a2 == 0) {
                btnA2.setOnClickListener {

                    giveMove("a2")
                }
            }

            if (it.moves.a3 == 0) {
                btnA3.setOnClickListener {

                    giveMove("a3")
                }
            }

            if (it.moves.b1 == 0) {
                btnB1.setOnClickListener {

                    giveMove("b1")
                }
            }

            if (it.moves.b2 == 0) {
                btnB2.setOnClickListener {

                    giveMove("b2")
                }
            }

            if (it.moves.b3 == 0) {
                btnB3.setOnClickListener {

                    giveMove("b3")
                }
            }

            if (it.moves.c1 == 0) {
                btnC1.setOnClickListener {

                    giveMove("c1")
                }
            }

            if (it.moves.c2 == 0) {
                btnC2.setOnClickListener {

                    giveMove("c2")
                }
            }

            if (it.moves.c3 == 0) {
                btnC3.setOnClickListener {

                    giveMove("c3")
                }
            }

        })
    }

    private fun giveMove(zet : String){

        viewModel.updateGame(Zet(gameId, zet))
        findNavController().popBackStack()

    }



}