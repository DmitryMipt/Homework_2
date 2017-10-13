import ru.sbt.exceptions.*;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Bankomat {


    private int summa;
    private PinValidator pinValidator;
    private TerminalServer server;

    public Bankomat(PinValidator pinValidator, TerminalServer server) {


        this.pinValidator = pinValidator;
        this.server = server;
    }

    boolean enterPin() throws AccountIsLockedException, IncorrectPinException, PinCodeAlreadeEnteredException {
        try {
            if (this.pinValidator.isBlockFlag()) {
                throw new AccountIsLockedException();
            }
            if (this.pinValidator.isPinFlag()) {
                throw new PinCodeAlreadeEnteredException();
            }

            Scanner st = new Scanner(System.in);
            System.out.println("Введите пин-код:");
            return this.pinValidator.checkPin(st.nextInt());
        } catch (AccountIsLockedException e) {
            System.out.println("Ваш Аккаунт заблокирован! Попробуйте снова через 5 сек.");
        } catch (PinCodeAlreadeEnteredException e) {
            System.out.println("Вы уже ввели пин-код! Выберите другое действие.");
        } catch (IncorrectPinException e) {
            System.out.println("Неверный пин-код!");
        }

        return false;
    }


    void toCheckBalance() throws AccountIsLockedException, DidNotEnterPinCodeException {
        try {
            if (this.pinValidator.isBlockFlag()) {
                throw new AccountIsLockedException();
            }
            if (!this.pinValidator.isPinFlag()) {
                throw new DidNotEnterPinCodeException();
            }

            System.out.println(this.server.checkBalance());
        } catch (AccountIsLockedException e) {
            System.out.println("Аккаунт разблокируется через 5 сек");
        } catch (DidNotEnterPinCodeException e) {
            System.out.println("Сначала введите пин-код!");
        }


    }


    void toPushMoney() throws AccountIsLockedException, DidNotEnterPinCodeException, IncorrectSumException {
        try {
            if (this.pinValidator.isBlockFlag()) {
                throw new AccountIsLockedException();
            }
            if (!this.pinValidator.isPinFlag()) {
                throw new DidNotEnterPinCodeException();
            }

            this.server.pushMoney();
        } catch (AccountIsLockedException e) {
            System.out.println("Аккаунт разблокируется через 5 сек");
        } catch (DidNotEnterPinCodeException e) {
            System.out.println("Сначала введите пин-код!");
        } catch (IncorrectSumException e) {
            System.out.println("Введите сумму кратную 100!");
        }

    }


    void toGetMoney() throws AccountIsLockedException, DidNotEnterPinCodeException, IncorrectSumException, NotEnoughMoneyOnBalanceException {
        try {
            if (this.pinValidator.isBlockFlag()) {
                throw new AccountIsLockedException();
            }
            if (!this.pinValidator.isPinFlag()) {
                throw new DidNotEnterPinCodeException();
            }

            this.server.getMoney();
        } catch (DidNotEnterPinCodeException e) {
            System.out.println("Сначала введите пин-код!");
        } catch (AccountIsLockedException e) {
            System.out.println("Аккаунт разблокируется через 5 сек");
        } catch (IncorrectSumException e) {
            System.out.println("Введите сумму кратную 100!");
        } catch (NotEnoughMoneyOnBalanceException e) {
            System.out.println("На Вашем счете недостаточно средств :(");
            ;
        }

    }
}
