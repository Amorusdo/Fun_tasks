package com.example.compozsitions

import android.annotation.SuppressLint
import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.compozsitions.databinding.ActivityMainBinding
import org.w3c.dom.Text
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var titleList: ArrayList<String>
    private lateinit var audioManager: AudioManager
    private lateinit var fistMusicx: MediaPlayer

    private var spinnerAdapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        player()
        initLists()
        initSpinner()
        nav()

        binding.changeFon.setOnClickListener {
            onGetRandomImage()
        }
        binding.switchCompat.setOnClickListener {
            playMusik()
        }
    }

       private fun nav()= with(binding){
        settings.setOnClickListener {
          if (btMainNavigation.isGone){
              btMainNavigation.visibility =View.VISIBLE
          }
            else btMainNavigation.visibility =View.GONE
        }

    }
    private fun initSpinner() {
        binding.spinner.onItemSelectedListener = this
        spinnerAdapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_dropdown_item, titleList
        )
        binding.spinner.adapter = spinnerAdapter

    }

    private fun playMusik() = with(binding) {
        if (switchCompat.isChecked) {
          settingsPlayerOn()
        } else {
           settingsPlayerOff()
        }
    }

    private fun onGetRandomImage(): Boolean {
        val kebord = binding.editTx.text.toString()
        if (kebord.isBlank()) {
            binding.editTx.error = "Keyword is empty"
            return true
        }
        val enCod = URLEncoder.encode(kebord, StandardCharsets.UTF_8.name())
        Glide.with(this)
            .load("https://source.unsplash.com/random/800×600?$enCod")
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .placeholder(R.drawable.cmeh)
            .into(binding.imageView)
        return false
    }

    private fun initLists() {
        titleList = ArrayList()
        titleList.add("Drums")
        titleList.add("Guitar")
        titleList.add("Rock")
        titleList.add("Keyboard")
        titleList.add("Music")
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {

        when (binding.spinner.selectedItem.toString()) {
            "Drums" -> {
                fistMusicx.pause()
                audioManager = getSystemService(AUDIO_SERVICE) as AudioManager
                fistMusicx = MediaPlayer.create(this, R.raw.abba_happy_new_year)
               setMusic()
            }
            "Guitar" -> {
                fistMusicx.pause()
                audioManager = getSystemService(AUDIO_SERVICE) as AudioManager
                fistMusicx = MediaPlayer.create(this, R.raw.ocean)
               setMusic()
            }
            "Rock" -> {
                fistMusicx.pause()
                fistMusicx= MediaPlayer.create(this, R.raw.let_it_snow)
               setMusic()
            }
            "Keyboard" -> {
                fistMusicx.pause()
                fistMusicx = MediaPlayer.create(this, R.raw.some)
                setMusic()
            }
            "Music" -> {
                fistMusicx.pause()
                fistMusicx= MediaPlayer.create(this, R.raw.in_the_dark)
               setMusic()
            }
        }
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun settingsPlayerOn() = with(binding) {
        setMusic()
        textSound.text = "Звук включен"
        textSound.background = getDrawable(R.color.green1)
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun settingsPlayerOff() = with(binding) {
        textSound.text = "Звук выключен"
        textSound.background = getDrawable(R.color.red)
        fistMusicx.pause()
    }
    private fun setMusic(){
        fistMusicx.seekTo(0)
        fistMusicx.start()
        fistMusicx.isLooping
    }
    private fun player(){
        audioManager = getSystemService(AUDIO_SERVICE) as AudioManager
        fistMusicx = MediaPlayer.create(this, R.raw.abba_happy_new_year)
        fistMusicx.start()
        fistMusicx.isLooping
    }
    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}


