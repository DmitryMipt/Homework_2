package ru.sbt.exceptions;

public class IncorrectPinException extends Throwable {
    public IncorrectPinException(String incorrect_pin) {
        System.out.println(incorrect_pin);

    }

    public IncorrectPinException() {

    }
}
