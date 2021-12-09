package com.example.testdesignpattern

import android.graphics.Color
import android.util.Log
import java.util.*

class StrategyPattern(private var formatterPrintStategy: (String) -> String = { "" }, private val colorFormatterStrategy: () -> Int = {Color.BLACK}) {

    fun printStategy(string: String): String = formatterPrintStategy(string)
    fun colorStrategy(): Int = colorFormatterStrategy()

}

val lowerCaseFormatter: (String) -> String = { it.lowercase(Locale.getDefault()) }
val upperCaseFormatter = {it: String -> it.uppercase(Locale.getDefault()) }

val colorRed: () -> Int = {Color.RED}
val colorGreen: () -> Int = {Color.GREEN}