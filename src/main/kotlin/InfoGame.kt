package org.example

data class InfoGame(val info: InfoShark) {
    override fun toString(): String {
        return info.toString()
    }

}