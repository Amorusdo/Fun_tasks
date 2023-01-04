package com.example.compozsitions.presentation

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.compozsitions.R
import com.example.compozsitions.databinding.FragmentGameFinishBinding
import kotlin.system.exitProcess

class GameFinishFragment : Fragment() {
    private val args by navArgs<GameFinishFragmentArgs>()

    private val binding: FragmentGameFinishBinding by lazy {
    FragmentGameFinishBinding.inflate(layoutInflater)
}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txFinish.text = args.finishText
        binding.btClose.setOnClickListener {;
            exitProcess(-1) }
        binding.btPlayAgain.setOnClickListener {  launchChooseLevelFragment() }

    }

    private fun launchChooseLevelFragment() {
        findNavController().navigate(
            GameFinishFragmentDirections.actionGameFinishFragmentToChooseLevelFragment(
                    "Правила Игры:",
                    "1. Лучше играть в компании от 4 человек.",
                    "2. Чтобы было весело, выполняйте задания в точности.",
                    "3. Раздайте карточки, тот кому попалась красная карта выполняет задание, потом собираете тусуете и опять раздаете.",
                    "4. Не переходите к следующему заданию пока участник не выполнит свое до конца.",
                    "5. Если хотите отменить свое задание, выполните задание любого участника, который вам его предложит.",
                    "6. Для игры понадобится: карандаш или ручка, листок бумаги, 2 ореха, телефон с какой нибудь музыкой хорощее настроение.",
                    "7. В игре нет победителей."
                )
            )
    }
}
