import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Matrix {

    private static final int[][] matrix = {
            {1, 2, 3, 7},
            {4, 12, 6, 8},
            {7, 8, 9, 99},
            {7, 8, 9, 100}
        };

    private static final int NUM_THREADS = matrix.length;  // количество потоков для обработки матрицы

    public static void main(String[] args) {
        // пул потоков
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);


        for (int i = 0; i < NUM_THREADS; i++) {
            int startRow = i ;
            int endRow = (i + 1) ;

            // Создаем задачу для обработки текущей части матрицы
            Runnable task = new MaxElementTask(matrix, startRow, endRow);

            // Передаем задачу в пул потоков для выполнения
            executor.execute(task);
        }

        // Останавливаем пул потоков после завершения всех задач
        executor.shutdown();

        try {
            // Ожидаем завершения всех задач в пуле
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        int maxElement = MaxElementTask.getMaxElement();
        System.out.println("Наибольший элемент в матрице -> " + maxElement);
    }




}


//создается класс, который реализует
//интерфейс Runnable, В методе run() задается код, который будет
//выполняться в потоке
class MaxElementTask implements Runnable {

    private final int[][] matrix;
    private final int startRow;
    private final int endRow;
    private static int max;

    public MaxElementTask(int[][] matrix, int startRow, int endRow) {
        this.matrix = matrix;
        this.startRow = startRow;
        this.endRow = endRow;
    }

    @Override
    public void run() {
        int maxElement = 0;
        for (int i = startRow; i < endRow; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > maxElement) {
                    maxElement = matrix[i][j];
                }
                if (maxElement > max) {
                    max = maxElement;
                }

            }
        }
        System.out.println("Наибольший элемент в " + startRow + " строке матрицы -> " + maxElement);
    }
    public static synchronized int getMaxElement() {
            return max;
        }

}
