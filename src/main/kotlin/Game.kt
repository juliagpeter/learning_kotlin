package org.example

data class Game (val title:String, val image:String) {
    var description:String? = null

    override fun toString(): String {
        return  "Title: $title \n" +
                "Image: $image \n" +
                "Description: $description"
    }
}