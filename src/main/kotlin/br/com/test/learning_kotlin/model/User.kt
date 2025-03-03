package br.com.test.learning_kotlin.model

data class User(var name:String, var email:String) {
    var birthdate:String? = null
    var username:String? = null
    val idUser:String? = null

    constructor(name:String, email:String, birthdate:String, username:String, idUser:String) :
            this(name, email) {
            this.birthdate = birthdate
            this.username = username
    }

    override fun toString(): String {
        return  "Name: $name \n" +
                "Email: $email \n" +
                "Birthdate: $birthdate \n" +
                "Username: $username \n" +
                "Id: $idUser"
    }


}