public class ArrayAverage {
    public static void main(String[] args) {
    String[] arr = {"1", "2", "3", "4", "a"};
    int sum = 0;

    try{
    int[] numbers = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
        numbers[i] = Integer.parseInt(arr[i]);
    }

    for (int i = 0; i < numbers.length; i++) {
        sum += numbers[i];
    }
    if (arr.length == 0) {
        System.out.println("Пусто");
    } else {
        double average = (double) sum / arr.length;
        System.out.println("Среднее арифметическое: " + average);
    }

    } catch (NumberFormatException e) {
        System.out.println("Ошибка: неверный формат числа!");
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Ошибка: выход за границы массива!");}
}
}







