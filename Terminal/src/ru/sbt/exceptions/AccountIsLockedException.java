package ru.sbt.exceptions;

public class AccountIsLockedException extends Throwable {
    public AccountIsLockedException(String s) {
        System.out.println(s);

    }
}
