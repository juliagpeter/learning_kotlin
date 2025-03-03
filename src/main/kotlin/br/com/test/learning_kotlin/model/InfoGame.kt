package org.example.br.com.test.learning_kotlin.model

data class InfoGame(val info: InfoShark) {
    override fun toString(): String {
        return info.toString()
    }

}