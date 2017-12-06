import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

class ContextImpl implements Context {
    private int com = 0;
    private int inter = 0;
    private int failed = 0;
    private List<Future> tass;

    public ContextImpl(List<Future> tass) {
        this.tass = tass;
    }

    @Override
    public int getCompletedTaskCount() {
        for (Future future : tass) {
            if (future.isDone() && !future.isCancelled())
                try {
                    future.get();
                    com++;
                } catch (InterruptedException | ExecutionException e) {
                }
        }
        return com;
    }

    @Override
    public int getFailedTaskCount() {
        for (Future future : tass) {
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                failed++;
            }

        }
        return failed;
    }

    @Override
    public int getInterruptedTaskCount() {
        for (Future future : tass) {
            if(future.isCancelled()) inter++;

        }
        return inter;
    }

    @Override
    public void interrupt() {
        for (Future future : tass) {
            future.cancel(false);
        }
    }

    @Override
    public boolean isFinished() {
        return this.getCompletedTaskCount() + this.getInterruptedTaskCount() == tass.size();
    }
}