import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = benchmark(arrayQueue, 0);
        System.out.println("Array Queue spend time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = benchmark(loopQueue, opCount);
        System.out.println("Loop Queue spend time: " + time2 + " s");


    }

    private static double benchmark(Queue<Integer> queue, int opCount)
    {
        long startTime = System.nanoTime();

        Random random = new Random();
        // enqueue
        for(int i = 0; i < opCount; i ++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        // dequeue
        for(int i = 0; i < opCount; i ++) {
            queue.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
