public class Main {
    private static Runnable call;
    private Runnable[] tasks;

    public static void main(String[] args) throws InterruptedException {
        Runnable[] tasks = new Runnable[10];
        ExecutionManagerImpl exec = new ExecutionManagerImpl();
       // System.out.println(exec.execute(call, tasks).getCompletedTaskCount());
       // System.out.println(exec.execute(call, tasks).getFailedTaskCount());
      //  exec.execute(call, tasks).interrupt();
     //   System.out.println(exec.execute(call, tasks).getCompletedTaskCount());
        System.out.println(exec.execute(call, tasks).getInterruptedTaskCount());
        System.out.println(exec.execute(call, tasks).isFinished());

    }
}
