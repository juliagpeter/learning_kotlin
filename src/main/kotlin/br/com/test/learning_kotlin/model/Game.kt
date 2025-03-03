package org.example.br.com.test.learning_kotlin.model

data class Game (val title:String, val image:String) {
    var description:String? = null

    override fun toString(): String {
        return  "Title: $title \n" +
                "Image: $image \n" +
                "Description: $description"
    }
}