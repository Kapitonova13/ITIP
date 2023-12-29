import java.util.concurrent.Semaphore;

public class Warehouse {
    public static void main(String[] args) {
        int[] array = {30,30,30,30,30,30, 50, 123};
        int numThreads = 3; //3 грузчика

        // Общая переменная суммы
        SumHolder sumHolder = new SumHolder();

        // Создаем семафор для общей переменной суммы
        Semaphore sumSemaphore = new Semaphore(1);

        // Создаем семафоры для каждого элемента массива
        Semaphore[] elementSemaphores = new Semaphore[array.length];
        for (int i = 0; i < array.length; i++) {
            elementSemaphores[i] = new Semaphore(1);
        }

        // Создаем и запускаем потоки
        for (int i = 0; i < numThreads; i++) {
            new Thread(new Worker(i, array, sumHolder, sumSemaphore, elementSemaphores)).start();
        }
    }
}

class Worker implements Runnable {
    private final int id; //номер рабочего
    private final int[] array; //Массив, из которого будем брать вес товара
    private final SumHolder sumHolder; //общая сумма
    private final Semaphore sumSemaphore; //семафор для работы с общей суммой
    private final Semaphore[] elementSemaphores; //семафор для доступа к элементама массива

    public Worker(int id, int[] array, SumHolder sumHolder, Semaphore sumSemaphore, Semaphore[] elementSemaphores) {
        this.id = id+1;
        this.array = array;
        this.sumHolder = sumHolder;
        this.sumSemaphore = sumSemaphore;
        this.elementSemaphores = elementSemaphores;
    }

    @Override
    public void run() {
        while (true) { //идти будет всё по кругу, чтобы гарантированно забрать все грузы со склада
            for (int i = 0; i < array.length; i++) {
                try {
                    int flag=0; //флаг того, что можно грузить товар
                    // Пытаемся захватить семафор для элемента массива
                    if (elementSemaphores[i].tryAcquire()) {//Если получилось, то мы элемент захватили
                        int element = array[i]; //Получаем этот элемента

                        // Захватываем семафор для общей переменной суммы
                        sumSemaphore.acquire(); //Для того, чтобы один грузчик работал с суммой, а не все сразу, мы даём ему доступ
                        if (sumHolder.getSum()+element <=150 ){//Можем ли мы добавить
                            if (i==array.length-1){
                                flag=1;

                            }

                            sumHolder.add(element);
                            System.out.println("Грузчик " + id + ": взял товар с весом " + element + ", Текущий вес: " + sumHolder.getSum());}

                        else{
                            flag=1; // флаг того, что больше нельзя грузить товар
                            elementSemaphores[i].release(); //разблокируем этот семафор для дрyугих грузчиков
                        }
                        sumSemaphore.release(); //Разрешаем другим грузчикам работать с переменной суммы

                        // Если сумма превышает 150, обнуляем сумму
                        if (flag==1) { //отгрузка товара на другой склад

                            sumSemaphore.acquire();
                            sumHolder.reset();
                            System.out.println("Грузчик " + id + ": не может взять товар, тк с ним суммарная сумма превышает 150.");
//                            System.out.println("Грузчики отправляются на другой склад, разгружают товары и возвращаются.");
                            System.out.println("Грузчики отправляются на другой склад.");
                            Thread.sleep(1000);
                            System.out.println("Грузчики разгружают товары.");
                            Thread.sleep(1000);
                            System.out.println("Грузчики возвращаются.");
                            Thread.sleep(1000);
                            sumSemaphore.release();
//                            flag=0;
                        }
                        Thread.sleep(500);//загрузка

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Если все семафоры элементов заблокированы, завершаем поток
            boolean allSemaphoresBlocked = true;
            for (Semaphore semaphore : elementSemaphores) {
                if (semaphore.availablePermits() > 0) {
                    allSemaphoresBlocked = false;
                    break;
                }
            }

            if (allSemaphoresBlocked) {
                System.out.println("Грузчик " + id + " закончил рабту");
                break;
            }
        }
    }
}

// Несколько потоков будут работать с одной и той же переменной, поэтому необходимо синхронизировать доступ к этому ресурсу
class SumHolder {
    private int sum = 0;

    public synchronized void add(int value) {
        sum += value;
    }

    public synchronized void reset() {
        sum = 0;
    }

    public synchronized int getSum() {
        return sum;
    }
}
