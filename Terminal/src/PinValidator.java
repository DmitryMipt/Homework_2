import ru.sbt.exceptions.AccountIsLockedException;
import ru.sbt.exceptions.IncorrectPinException;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class PinValidator {
    private boolean pinFlag = false;
    private static int pin;
    private static int n = 0;
    private boolean blockFlag = false;

    boolean isBlockFlag() {
        return blockFlag;
    }

    public PinValidator(int pin) {
        PinValidator.pin = pin;
    }

    boolean isPinFlag() {
        return pinFlag;
    }

    private void blockAccount() {

        System.out.println("Ваш аккаунт заблокирован");
        Timer blocker = new Timer();
        TimerTask indicator = new TimerTask() {
            @Override
            public void run() {
                blockFlag = true;

            }
        };
        blocker.schedule(indicator, new Date(5000));


    }

    boolean checkPin(int pincode) throws AccountIsLockedException, IncorrectPinException {


        if (pincode == pin) {
            pinFlag = true;

            n = 0;
            System.out.println("Корректный пин");
            return true;

        } else {
            n += 1;
            if (n >= 3) {
                blockAccount();
                throw new AccountIsLockedException();

            }
            throw new IncorrectPinException();
        }


    }

}


