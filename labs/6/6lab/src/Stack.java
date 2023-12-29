import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<T> {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push(4);
        System.out.println(stack.pop());
    }


    private T[] data;
    private int size;

    public Stack(int capacity) {
        //Создается массив типа Object нужной вместимости, который затем приводится к типу T
        data = (T[]) new Object[capacity];
        size = 0;
    }
    public Stack() {    
        this(5);    
    }

    public void push(T element) {
        // проверяется, достигнут ли предел вместимости стека, и, если да, то происходит увеличение его размера
        if (this.size==this.data.length) {
            this.data = Arrays.copyOf(this.data, this.data.length+1);
        }
        this.data[this.size]=element;
        this.size++;
    }

    
    public T pop() {
        // проверяется пуст ли стек, если да, генерируется исключение
        if (this.size == 0) {
            throw new EmptyStackException();
        }
        //Размер стека уменьшается, затем извлекаемый элемент возвращается, заменяется на null в массиве данных
        this.size--;
        T popped = this.data[this.size];
        this.data[this.size]=null;
        return popped;
    }


    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return this.data[this.size-1];
    }
}    

