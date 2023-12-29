public class Main {
    public static void main(String[] args) {
        HashTable<Integer, Book> books = new HashTable<>();

        HashTable<String, Book> books1 = new HashTable<>();

        books1.put("Q", new Book("'Гарри Поттер и философский камень'", "Джоан Роулинг", 1500));
        books1.put("o", new Book("'Гордость и предубеждение'", "Джейн Остин", 1000));
        books.put(12, new Book("'Гарри Поттер и философский камень'", "Джоан Роулинг", 1500));
        books.put(2, new Book("'Гордость и предубеждение'", "Джейн Остин", 1000));
        // books.put(4, new Book("'Старик и море'", "Эрнест Хемингуэй", 500));
        // books.put(7, new Book("'Убийство в 'Восточном экспрессе''", "Агата Кристи", 750));

        System.out.println("HashTable:");
        System.out.println(books);
        System.out.println(books1);

        System.out.println("Размер HashTable: " + books.size());

        // System.out.println("Элемент HashTable с ключом 1: " + books.get(1));
        System.out.println("Элемент HashTable с ключом : " + books.get(1));
        System.out.println("Элемент HashTable с ключом : " + books.get(3));

        System.out.println("Удаление элемента с ключом 2 из HashTable");
        books.remove(2);

        // System.out.println("Элемент HashTable с ключом 1: " + books.get(1));
        // System.out.println(books);
        System.out.println("Текущий размер HashTable: " + books.size());
        System.out.println("Пуста ли HashTable в данный момент? " + books.isEmpty());

        System.out.println("Удаление всех элементов из HashTable");
        // books.remove(2);
        // books.remove(4);
        // books.remove(7);
        // System.out.println(books);

        System.out.println("Пуста ли HashTable в данный момент? " + books.isEmpty());
        System.out.println("Количество элементов HashTable: " + books.size());
    }
}

//Реализация хэш-таблицы для хранения информации о книгах
// в библиотеке. Ключом будет ISBN книги, а значением - объект класса Book,
// содержащий информацию о названии, авторе и количестве копий.
// Необходимо реализовать операции вставки, поиска и удаления книги по ISBN.
// Вариант 4

// ISBN - Международный стандартный книжный номер

class Book {
    public String bookTitle;
    public String author;
    public int numberofCopies;

    public Book(String bookTitle, String author, int numberofCopies) {
        this.bookTitle=bookTitle;
        this.author = author;
        this.numberofCopies = numberofCopies;
    }

    @Override
    public String toString() {
        return bookTitle + ", " + author + ", " + numberofCopies;
    }
}

