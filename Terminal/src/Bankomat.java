import ru.sbt.exceptions.*;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Bankomat  {


    private int summa;
    private PinValidator pinValidator;
    private TerminalServer server;

    public Bankomat( PinValidator pinValidator, TerminalServer server) {


        this.pinValidator = pinValidator;
        this.server = server;
    }

    boolean enterPin() throws AccountIsLockedException, IncorrectPinException, PinCodeAlreadeEnteredException {
        if (this.pinValidator.isPinFlag()) {
            throw new PinCodeAlreadeEnteredException("Вы уже ввели пин код");
        }
        if (this.pinValidator.isBlockFlag()) {
            throw new AccountIsLockedException("Аккаунт разблокируется через 5 сек");
        }
        Scanner st = new Scanner(System.in);
        System.out.println("Введите пин-код:");
        return this.pinValidator.checkPin(st.nextInt());

        }


    void toCheckBalance() throws AccountIsLockedException, DidNotEnterPinCodeException {
        if (!this.pinValidator.isPinFlag()) {
            throw new DidNotEnterPinCodeException("Сначала введите пин-код!");
        }
        if (this.pinValidator.isBlockFlag()) {
            throw new AccountIsLockedException("Аккаунт разблокируется через 5 сек");
        }
        System.out.println(this.server.checkBalance());


    }


    void toPushMoney() throws AccountIsLockedException, DidNotEnterPinCodeException, IncorrectSumException {
        if (!this.pinValidator.isPinFlag()) {
            throw new DidNotEnterPinCodeException("Сначала введите пин-код!");
        }
        if (this.pinValidator.isBlockFlag()) {
            throw new AccountIsLockedException("Аккаунт разблокируется через 5 сек");
        }
        this.server.pushMoney();

    }


    void toGetMoney() throws AccountIsLockedException, DidNotEnterPinCodeException, IncorrectSumException, NotEnoughMoneyOnBalanceException {
        if (!this.pinValidator.isPinFlag()) {
            throw new DidNotEnterPinCodeException("Сначала введите пин-код!");
        }
        if (this.pinValidator.isBlockFlag()) {
            throw new AccountIsLockedException("Аккаунт разблокируется через 5 сек");
        }
        this.server.getMoney();

    }
}
