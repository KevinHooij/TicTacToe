package com.example.tictactoe.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.tictactoe.viewmodel.GameViewModel
import com.example.tictactoe.R
import kotlinx.android.synthetic.main.fragment_new_match.*

class NewMatchFragment : Fragment() {

    private val viewModel: GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_match, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }



    private fun initViews(){
        btnJoinNew.setOnClickListener{findNavController().navigate(R.id.action_newMatchFragment_to_enterCodeFragment)}

        btnCreateNew.setOnClickListener{
            viewModel.newGame()
            findNavController().popBackStack()
        }
    }
}