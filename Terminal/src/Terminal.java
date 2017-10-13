import ru.sbt.exceptions.AccountIsLockedException;
import ru.sbt.exceptions.IncorrectSumException;
import ru.sbt.exceptions.NotEnoughMoneyOnBalanceException;

public interface Terminal {
    double checkBalance() throws AccountIsLockedException;

    void pushMoney() throws AccountIsLockedException, IncorrectSumException;

    void getMoney() throws AccountIsLockedException, IncorrectSumException, NotEnoughMoneyOnBalanceException;
}
