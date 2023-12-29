import java.util.*;
// Программа должна позволять добавлять проданные товары в коллекцию,
// выводить список проданных товаров, а также считать общую сумму
// продаж и наиболее популярный товар.
// Использовать TreeSet для хранения списка проданных
// товаров


public class Shop {
    public static void main(String[] args) {
        SalesManager salesManager = new SalesManager();

        Product p1 = new Product("Телефон", 50000);
        Product p2 = new Product("Ноутбук", 80000);
        Product p3 = new Product("Телевизор", 70000);
        Product p4 = new Product("Ноутбук", 80000);

        salesManager.addSoldProduct(p1);
        salesManager.addSoldProduct(p2);
        salesManager.addSoldProduct(p3);
        salesManager.addSoldProduct(p4);
        salesManager.addSoldProduct(p1); // Продажа повторного товара

        salesManager.printSoldProducts();
        System.out.println("--------------------------------------");
        System.out.println("Общая сумма продаж: " + salesManager.getTotalSales());
        
        System.out.println("--------------------------------------");
        String mostPopularProduct = salesManager.getMostPopularProduct();
        if (mostPopularProduct != null) {
            System.out.println("Самый популярный товар: " + mostPopularProduct);
        } else {
            System.out.println("В базе данных нет проданных товаров.");
        }
    }
}

class Product implements Comparable<Product> {
    private String name;
    private double price;
    private int count;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.count = 1;
    }

    public void incrementCount() {
        this.count++;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }


    @Override
    public int compareTo(Product other) {

        if (price < other.getPrice()) {
        return -1; // текущая цена меньше цены other
        } else if (price > other.getPrice()) {
        return 1; // текущая цена больше цены other
        }
        return 0; // текущая цена равна цене other
        }
    
}

class SalesManager {
    private TreeSet<Product> soldProducts;
    private double totalSales;

    public SalesManager() {
        soldProducts = new TreeSet<>();
        totalSales = 0;
    }

    public void addSoldProduct(Product product) {
        if (soldProducts.contains(product)) {
            //переходим к старому, чтобы добавить 1 
            product = soldProducts.ceiling(product);
            product.incrementCount();

        } else {
            soldProducts.add(product);


        }
        totalSales += product.getPrice();
    }

    public void printSoldProducts() {
        System.out.println("Список проданных товаров:");
        for (Product product : soldProducts) {
            System.out.println(product.getName() + " - " + product.getPrice() + " - продано " + product.getCount());
        }
    }

    public double getTotalSales() {
        return totalSales;
    }

    public String getMostPopularProduct() {
        String mostPopularProduct = "";
        int maxQuantity = 0;
            
        for (Product product : soldProducts) {
            if (product.getCount() >= maxQuantity) {

                mostPopularProduct += product.getName() + " ";
                maxQuantity = product.getCount();
            }
        }

        return mostPopularProduct;
    }
}


