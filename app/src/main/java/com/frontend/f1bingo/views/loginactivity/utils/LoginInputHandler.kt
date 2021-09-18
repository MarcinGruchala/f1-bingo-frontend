package com.frontend.f1bingo.views.loginactivity.utils

object LoginInputHandler {
    fun validateLoginInput(mail: String, password: String): LoginInputStatus {
        if (mail.isEmpty() || password.isEmpty()) {
            return LoginInputStatus.EMPTY
        }
        return LoginInputStatus.OK
    }
}