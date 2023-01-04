package com.example.compozsitions.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.compozsitions.databinding.FragmentChooseLevelBinding


class ChooseLevel : Fragment() {

    private val args by navArgs<ChooseLevelArgs>()

private val binding: FragmentChooseLevelBinding by lazy {
    FragmentChooseLevelBinding.inflate(layoutInflater)
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
        binding.btStartGame.setOnClickListener {
            launchGameFragment()
        }
        binding.tvRule.text = args.rule
        binding.tvRule1.text = args.rule1
        binding.tvRule2.text = args.rule2
        binding.tvRule3.text = args.rule3
        binding.tvRule4.text = args.rule4
        binding.tvRule5.text = args.rule5
        binding.tvRule6.text = args.rule6
        binding.tvRule7.text = args.rule7

    }

    private fun launchGameFragment() {
        findNavController().navigate(
           ChooseLevelDirections.actionChooseLevelFragmentToGameFragment(
        "Покажи на что способен"
            )
        )
    }


}

