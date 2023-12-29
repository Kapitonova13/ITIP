import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Sum {
    private static final int NUM_THREADS = 3; // количество потоков

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        // массив разбивается на равные части, каждая из которых обрабатывается отдельным потоком в классе SumArrayThread
        int chunkSize = (int) Math.ceil((double) array.length / NUM_THREADS);

        // пул потоков
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        int startIndex = 0;
        int endIndex = chunkSize;

        for (int i = 0; i < NUM_THREADS; i++) {
            if (endIndex > array.length) {
                endIndex = array.length;
            }

            int[] subArray = new int[endIndex - startIndex];
            System.arraycopy(array, startIndex, subArray, 0, endIndex - startIndex);
//            System.out.println(Arrays.toString(subArray));

            Runnable worker = new SumArrayThread(subArray);

            //Метод execute запускает данную задачу в одном из потоков из пула
            executorService.execute(worker);

            startIndex = endIndex;
            endIndex += chunkSize;
        }
        // Останавливаем пул потоков после завершения всех задач
        executorService.shutdown();

        try {
            // Ожидаем завершения всех задач в пуле потоков
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int sum = SumArrayThread.getTotalSum();
        System.out.println("Сумма -> " + sum);
    }
//создается класс, который реализует
//интерфейс Runnable, В методе run() задается код, который будет
//выполняться в потоке
    static class SumArrayThread implements Runnable {
        private final int[] array;
        private static int totalSum = 0;

        SumArrayThread(int[] array) {
            this.array = array;
        }

        // использована синхронизация для общей переменной totalSum, чтобы избежать гонки за ресурсами
        // при одновременном доступе нескольких потоков к этой переменной
        public static synchronized int getTotalSum() {
            return totalSum;
        }

        @Override
        public void run() {
            int sum = 0;
            for (int value : array) {
                sum += value;
            }

            synchronized (SumArrayThread.class) {
                totalSum += sum;
            }
        }
    }
}