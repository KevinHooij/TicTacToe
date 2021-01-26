package com.example.tictactoe.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tictactoe.model.GameItem
import com.example.tictactoe.viewmodel.GameViewModel
import com.example.tictactoe.R
import kotlinx.android.synthetic.main.fragment_current_matches.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */

const val GAME_BUNDLE_KEY = "GAME_BUNDLE_KEY"
class CurrentMatchesFragment : Fragment() {

    private val viewModel: GameViewModel by activityViewModels()

    private val games = arrayListOf<GameItem>()
    private lateinit var gameAdapter: GameAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_current_matches, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        observeGames()
    }

    private fun initViews(){
        gameAdapter = GameAdapter(games, ::onItemClick)

        rvCurrentMatches.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvCurrentMatches.adapter = gameAdapter
        rvCurrentMatches.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }


    private fun onItemClick(gameItem: GameItem, index : Int) {
        val bundle = bundleOf(Pair(GAME_BUNDLE_KEY, index.toString()))

        findNavController().navigate(R.id.action_currentMatchesFragment_to_tictactoeFragment, bundle)
    }


    private fun observeGames(){
        viewModel.getAllGames()

        viewModel.games.observe(viewLifecycleOwner, Observer{
            games.clear()
            games.addAll(it)
            gameAdapter.notifyDataSetChanged()
        })
        // Observe the error message.
        viewModel.errorText.observe(viewLifecycleOwner, Observer {
            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
        })


    }


}
