package org.example

data class Game (val title:String, val image:String) {
    val description = ""

    override fun toString(): String {
        return  "Title: $title \n" +
                "Image: $image \n" +
                "Description: $description"
    }
}