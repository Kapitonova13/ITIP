public class Est {
    public static void main(String[] args) {
        Cafe cafe = new Cafe("Cafe", 3, 2, "Street", 10, 20);
        Cafe cafe1 = new Cafe();

        System.out.println("Место: " + cafe.getLocation());
        cafe.setLocation("aaaa");
        System.out.println("Место: " + cafe.getLocation());

        System.out.println("Колчество объектов: " + Cafe.getObjectCount());
        // System.out.println(cafe.start());
        // System.out.println(cafe.start("str"));

        cafe.display();
        cafe1.display();

        Shop shop = new Shop("Shop", 6, 3, "Street", 15, 11);
        shop.display();

        Library library = new Library("Library", 2, 4, "Street", 500, 25);
        library.display();
    }
}

 abstract class Establishment {
    private String name;
    private int amount;
    private int windows;

    public Establishment() {
        this.name = "Unknown";
        this.amount = 0;
        this.windows = 0;
    }

    public Establishment(String name, int amount, int windows) {
        this.name = name;
        this.amount = amount;
        this.windows = windows;
    }

    public String getName() { 
        return name; 
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAmount() { 
        return amount; 
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getWindows() { 
        return windows; 
    }
    public void setWindows(int windows) {
        this.windows = windows;
    }

    public void start() {
        System.out.println("Заведение открыто!");
    }

    public void stop() {
        System.out.println("Заведение закрыто!");
    }
  
    public abstract void display();
}
 

class Cafe extends Establishment{
    private String location;
    private int tables;
    private int chairs;

    private static int objectCount = 0;

    public String getLocation() { 
        return location; 
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getTables() { 
        return tables; 
    }
    public void setTables(int tables) {
        this.tables = tables;
    }
    public int getChairs() { 
        return chairs; 
    }
    public void setChairs(int chairs) {
        this.chairs = chairs;
    }

    public static int getObjectCount() {
        return objectCount;
    }

    @Override
    public void start() {
        System.out.println("Кафе открыто!");
    }
    
    public void start(String location) {
        System.out.printf("%s", location);
    }

    public void stop() {
        System.out.println("Кафе закрыто!");
    }

    public Cafe() {
        super.setName("Неизвестно");
        super.setAmount(0);
        super.setWindows(0);
        this.location = "Неизвестно";
        this.tables = 0;
        this.chairs = 0;
        objectCount++;
    }
     
    public Cafe(String name, int amount, int windows, String location, int tables, int chairs) {
        super(name, amount, windows);
        this.location = location;
        this.tables = tables;
        this.chairs = chairs;
        // start(location+"\n");
        // start();

        objectCount++;
    }
     
    public void display(){
        System.out.printf("-----\nНазвание кафе: %s \nКоличество сотрудников: %s \nКоличество окон: %s \nУлица: %s \nКоличество столов: %s \nКоличество стульев: %s \n----- \n", super.getName(), super.getAmount(), super.getWindows(), location, tables, chairs);
    }
}

class Shop extends Establishment{
    private String location;
    private int racks;
    private int carts;

    public String getLocation() { 
        return location; 
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getRacks() { 
        return racks; 
    }
    public void setRacks(int racks) {
        this.racks = racks;
    }
    public int getCarts() { 
        return carts; 
    }
    public void setCarts(int carts) {
        this.carts = carts;
    }

    // public void start() {
    //     System.out.println("Магазин открыт!");
    // }

    public void stop() {
        System.out.println("Магазин закрыт");
    }

    public Shop() {
        super.setName("Неизвестно");
        this.location = "Неизвестно";
        this.racks = 0;
        this.carts = 0;
    }
     
    public Shop(String name, int amount, int windows, String location, int racks, int carts) {
        super(name, amount, windows);
        this.location = location;
        this.racks = racks;
        this.carts = carts;
    }
     
    public void display(){
        System.out.printf("-----\nНазвание магазина: %s \nКоличество сотрудников: %s \nКоличество окон: %s \nУлица: %s \nКоличество стелажей с продуктами: %s \nКоличество тележек: %s\n-----\n", super.getName(), super.getAmount(), super.getWindows(), location, racks, carts);
    }
}

class Library extends Establishment{
    public String location;
    public int books;
    public int sofas;

    public String getLocation() { 
        return location; 
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getBooks() { 
        return books; 
    }
    public void setBooks(int books) {
        this.books = books;
    }
    public int getSofas() { 
        return sofas; 
    }
    public void setSofas(int sofas) {
        this.sofas = sofas;
    }

    // public void start() {
    //     System.out.println("Библиотека открыта!");
    // }

    public void stop() {
        System.out.println("Библиотека закрыта!");
    }

    public Library() {
        super.setName("Неизвестно");
        this.location = "Неизвестно";
        this.books = 0;
        this.sofas = 0;
    }
     
    public Library(String name, int amount, int windows, String location, int books, int sofas) {
        super(name, amount, windows);
        this.location = location;
        this.books = books;
        this.sofas = sofas;
    }
     
    public void display(){
        System.out.printf("-----\nНазвание библиотеки: %s \nКоличество сотрудников: %s \nКоличество окон: %s \nУлица: %s \nКоличество книг: %s \nКоличество диванов: %s \n-----\n", super.getName(), super.getAmount(), super.getWindows(), location, books, sofas);
    }
}