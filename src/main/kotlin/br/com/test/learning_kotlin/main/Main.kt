package org.example

import com.google.gson.Gson
import com.google.gson.JsonParser
import com.google.gson.JsonSyntaxException
import org.example.br.com.test.learning_kotlin.model.Game
import org.example.br.com.test.learning_kotlin.model.InfoGame
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
    var testGame: InfoGame? = null

    // Converte a string JSON para JsonElement
    val jsonElement = JsonParser.parseString(json)

    if (jsonElement.isJsonObject) {
        testGame = gson.fromJson(jsonElement, InfoGame::class.java)
    } else if (jsonElement.isJsonArray) {
        println("Invalid Id. Try again.")
        return
    }

    var myGame: Game? = null

    val result = runCatching {
        if (testGame != null) {
            myGame = Game(
                testGame.info.title,
                testGame.info.thumb
            )
        }
    }

    result.onFailure {
        println("Game not found. Try again.")
    }

    result.onSuccess {
        print("Do you want to add a description to the game? (y/n): ")
        val answer = read.nextLine()
        if (answer.equals("y", ignoreCase = true)) {
            print("Enter the description: ")
            val desc = read.nextLine()
            // Atenção: para alterar a descrição, a propriedade 'description' em Game deve ser 'var' e não 'val'
            myGame?.description = desc
        } else {
            myGame?.description = myGame?.title ?: ""
        }
        println(myGame)
    }
}