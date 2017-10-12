import ru.sbt.exceptions.*;

public class Main {
    public static void main(String[] args) throws AccountIsLockedException, DidNotEnterPinCodeException, IncorrectPinException, PinCodeAlreadeEnteredException, IncorrectSumException, NotEnoughMoneyOnBalanceException {
        PinValidator pinValidator = new PinValidator(4253);
        TerminalServer server = new TerminalServer(6389);
        Bankomat account = new Bankomat(pinValidator, server);
       // account.toCheckBalance();
        //account.enterPin();
        //account.enterPin();
        account.enterPin();
        account.toPushMoney();
        account.toPushMoney();
        account.toGetMoney();
        account.toGetMoney();
        account.toCheckBalance();
// Необходимо везде обработать исключения, чтобы программа не завершалась при каждой ошибке


    }
}
