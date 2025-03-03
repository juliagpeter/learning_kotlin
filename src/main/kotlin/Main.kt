package org.example

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner

fun main() {
    val read = Scanner(System.`in`)
    println("Enter the game id: ")
    val id = read.nextLine()
    val address = "https://www.cheapshark.com/api/1.0/games?id=$id"
    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(address))
        .build()

    val response = client.send(request, BodyHandlers.ofString())
    val json = response.body()

    println(json)

    val gson = Gson()
    val testGame = gson.fromJson(json, InfoGame::class.java)

    // código omitido

    val result = runCatching {
        val myGame = Game(
            testGame.info.title,
            testGame.info.thumb)
        println(myGame)
    }

    result.onFailure{
        println("Game not found. Try again.")
    }

    result.onSuccess {

    }



}