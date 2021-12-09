package com.example.testdesignpattern

interface Command {
    fun execute(): String
}

class OrderAddCommand(private val id: Int): Command {
    override fun execute(): String = "Adding order $id"
}

class OrderPayCommand(private val id: Int): Command {
    override fun execute(): String = "Paying order $id"
}

class CommandProcessor {
    private val queue = ArrayList<Command>()

    fun addToQueue(command: Command): CommandProcessor =
        apply {
            queue.add(command)
        }

    fun processCommand(): CommandProcessor =
        apply {
            queue.forEach { it.execute() }
            queue.clear()
        }
}