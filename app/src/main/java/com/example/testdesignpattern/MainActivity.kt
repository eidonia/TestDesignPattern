package com.example.testdesignpattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testdesignpattern.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var text = "Strategy Pattern test"

        binding.strategyPatternLower.text = text

        val lowerCase = StrategyPattern(formatterPrintStategy = lowerCaseFormatter)
        val upperCase = StrategyPattern(formatterPrintStategy = upperCaseFormatter)

        val colorRed = StrategyPattern(colorFormatterStrategy = colorRed)
        val colorGreen = StrategyPattern(colorFormatterStrategy = colorGreen)

        binding.btnStrategyPatternUpper.setOnClickListener {
            binding.strategyPatternLower.text = upperCase.printStategy(text)
        }

        binding.btnStrategyPatternLower.setOnClickListener {
            binding.strategyPatternLower.text = lowerCase.printStategy(text)
        }

        binding.btnStrategyPatternRed.setOnClickListener {
            binding.strategyPatternLower.setTextColor(colorRed.colorStrategy())
        }

        binding.btnStrategyPatternGreen.setOnClickListener {
            binding.strategyPatternLower.setTextColor(colorGreen.colorStrategy())
        }

    }
}