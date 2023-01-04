package com.example.compozsitions.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.compozsitions.R
import com.example.compozsitions.databinding.FragmentGameBinding


class GameFragment : Fragment() {
    private val args by navArgs<GameFragmentArgs>()
    private var h = 0
    private val binding: FragmentGameBinding by lazy {
        FragmentGameBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btNextQuestion.setOnClickListener {
            binding.textViewdddd.text =getFunnyTasks()

        }
    }

    private fun getFunnyTasks(): String {
        h++
        val size = resources.getStringArray(R.array.funny_tasks).size-1
        if (h >= size){
            h = 0
            binding.btNextQuestion.setOnClickListener { launchGameFinishFragment() }}

        return resources.getStringArray(R.array.funny_tasks)[h]

    }

    private fun launchGameFinishFragment() {
        findNavController().navigate(
            GameFragmentDirections.actionGameFragmentToGameFinishFragment(
                "Надеюсь было весело и вы прикольно провели время!"

            )
        )
    }


}


