import java.util.concurrent.*;

public class Main {

    static int n;

    public static void main(String[] args) {
        n = 100;
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            Future[] futures = new Future[n];
            for(int i=0; i<n; i++){
                executorService.submit(new Callable<Long>() {
                    @Override
                    public Long call() throws Exception {
                        long start = System.currentTimeMillis();
                        for(int i=0; i<100000000/n; i++) {

                        }
                        long end = System.currentTimeMillis();
                        return (end-start);
                    }
                });
            }
            long sum = 0;
            for(int i=0; i<n; i++){
                sum += (Long)(futures[i].get());
            }
            System.out.println(sum);
            executorService.shutdown();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}