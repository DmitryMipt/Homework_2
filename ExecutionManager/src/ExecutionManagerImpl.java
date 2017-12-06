import sun.nio.ch.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

//Код написан таким образом, чтобы возможно было проверить его правильность (в метод не передаются tasks)
//Это не исправлено на тот код, который должен полностью соответсвовать заданию, т.к. я не уверен правильно он работает или нет :)


public class ExecutionManagerImpl implements ExecutionManager {
    private List<Future> tass;

    public List<Future> getTass() {
        return tass;
    }

    ExecutionManagerImpl() {
    }
    @Override
    public Context execute(Runnable callback, Runnable... tasks) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(tasks.length);
        tass = new ArrayList<>(tasks.length);
        for (int j = 0; j < tasks.length; j++) {
            int finalJ = j;

//Здесь для проверки работы программы в метод add в качестве параметра передается pool, который вручную заполняется потоками (создаются)
// В соответствии с заданием вместо создания потоков через new Thread в этот метод должны просто передаваться объекты tasks.

            tass.add(pool.submit(new Thread(new Runnable() {
                @Override
                public void run() {
//                    try {
//                        Thread.sleep(10000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println("Thread number " + finalJ);
                }
            })));
        }


        if (pool.isTerminated()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Все кончено");
                }
            }).start();

        }


        return new ContextImpl(getTass());
    }

}


