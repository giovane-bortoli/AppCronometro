package com.example.cronometro

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.example.cronometro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var running = false
    var pause: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var cronometro = binding.cronometro
        var botaoIniciar = binding.btIniciar
        var botaoPausar = binding.btPausar
        var botaoZerar = binding.btZerar

        binding.btIniciar.setOnClickListener {
            IniciarCronometro()
        }

        binding.btPausar.setOnClickListener {
            PausarCronometro()
        }

        binding.btZerar.setOnClickListener {
            ZerarCronometro()
        }

    }

    private fun IniciarCronometro(){
        if(!running){
            binding.cronometro.base = SystemClock.elapsedRealtime() - pause
            binding.cronometro.start()
            running = true
        }
    }

    private fun PausarCronometro(){
        if(running){
            binding.cronometro.stop()
            pause = SystemClock.elapsedRealtime() - binding.cronometro.base
            running = false
        }
    }

    private fun ZerarCronometro(){
        binding.cronometro.base = SystemClock.elapsedRealtime()
        pause = 0
    }
}