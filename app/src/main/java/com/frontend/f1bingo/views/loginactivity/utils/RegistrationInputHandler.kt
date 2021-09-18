package com.frontend.f1bingo.views.loginactivity.utils

object RegistrationInputHandler {
    fun validateRegistrationInput(
        email: String,
        password: String,
        repeatPassword: String
    ): RegistrationInputStatus {
        if (email.isEmpty() ||
            password.isEmpty() ||
            repeatPassword.isEmpty()
        ) {
            return RegistrationInputStatus.EMPTY
        }
        if (password != repeatPassword) {
            return RegistrationInputStatus.INVALID_PASSWORD
        }
        return RegistrationInputStatus.OK
    }
}