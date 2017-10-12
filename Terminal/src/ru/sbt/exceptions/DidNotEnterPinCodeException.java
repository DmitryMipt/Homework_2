package ru.sbt.exceptions;

public class DidNotEnterPinCodeException extends Throwable {
    public DidNotEnterPinCodeException(String s) {
        System.out.println(s);
    }
}
