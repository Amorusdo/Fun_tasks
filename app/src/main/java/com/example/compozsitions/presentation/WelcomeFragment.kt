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
import com.example.compozsitions.R
import com.example.compozsitions.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
private val binding:FragmentWelcomeBinding by lazy {
    FragmentWelcomeBinding.inflate(layoutInflater)
}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View { return binding.root }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btNext.setOnClickListener {
            launchRuleFragment()
        }
    }
    private fun launchRuleFragment(){
        findNavController().navigate(
            WelcomeFragmentDirections.actionWelcomeFragmentToChooseLevelFragment(
                "Правила Игры:",
                "1. Лучше играть в компании от 4 человек.",
                "2. Чтобы было весело, выполняйте задания в точности.",
                "3. Раздайте карточки, тот кому попалась красная карта выполняет задание, потом собираете тусуете и опять раздаете.",
                "4. Не переходите к следующему заданию пока участник не выполнит свое до конца.",
                "5. Если хотите отменить свое задание, выполните задание любого участника, который вам его предложит.",
                "6. Для игры понадобится: карандаш или ручка, листок бумаги, 2 ореха, телефон с какой нибудь музыкой и хорощее настроение.",
                "7. В игре нет победителей."
            )
        )
    }
}