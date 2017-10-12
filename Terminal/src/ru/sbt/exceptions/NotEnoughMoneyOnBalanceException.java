package ru.sbt.exceptions;

public class NotEnoughMoneyOnBalanceException extends Throwable {
    public NotEnoughMoneyOnBalanceException(String message) {
        System.out.println(message);
    }
}
