import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Top {
    public static void main(String[] args) {
        // указываем путь к файлу
        String filePath = "aaa.txt";    
        // создаем объект File
        File file = new File(filePath);        
        // создаем объект Scanner для чтения файла
        Scanner scanner = null; 

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // создаем объект Map для хранения слов и их количества
        Map<String, Integer> map = new HashMap<>();  

        // читаем файл по словам и добавляем их в Map
        for (Scanner a = scanner; a.hasNext(); ) {

            String str = a.next().toLowerCase().replaceAll("[^a-zA-Zа-яА-Я]", "");
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.replace(str, map.get(str)+1);
            }
        }
        // закрываем Scanner
        scanner.close();   


        // создаем список из элементов Map
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());   

        // сортируем список по убыванию количества повторений
        // Вторым аргументом передаем новый компаратор, который будет определять порядок сортировки
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            // анонимный класс, который реализует интерфейс Comparator и переопределяет метод compare
            // Этот метод принимает два объекта типа Map.Entry<String, Integer> для сравнения
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                //сравниваем значения Integer двух объектов Map.Entry<String, Integer>, 
                // сравниваем полученные значения с помощью compareTo, если результат отрицателен, означает, что o2 больше o1, а если результат положителен - наоборот
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        
        // выводим топ-10 слов
        System.out.println("Топ-10 самых часто встречающихся слов:");
        int count = 0;
        for (Map.Entry<String, Integer> entry : list) {
            if (count < 10) {
                //выводим результат
                System.out.println(entry.getKey() + " -> " + entry.getValue());
                count++;
            } else {
                break;
            }
        }
    }

}




