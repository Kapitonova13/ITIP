import java.util.LinkedList;

public class HashTable<K, V> {
    private LinkedList<Entry<K, V>>[] table;
    private int size;

    public HashTable() {
        this(13);
    }

    public HashTable(int defaultC) {
        table = new LinkedList[defaultC];
        size = 0;
    }

    public void put(K key, V value) {
        int index = key.hashCode();
        index = Math.abs(index%10);
        
        
        if (table[index] == null) {
            table[index] = new LinkedList<Entry<K, V>>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = key.hashCode();
        LinkedList<Entry<K, V>> list = table[index];
        
        if (list != null) {
            for (Entry<K, V> entry : list) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = key.hashCode();
        LinkedList<Entry<K, V>> list = table[index];
        if (list == null) {
            return;
        };
        for (Entry<K, V> entry : list) {
            if (entry.getKey().equals(key)) {
                list.remove(entry);
                size--;
            }
        }
    }

    public int size() { 
        return size; 
    }

    public boolean isEmpty() { 
        return size == 0; 
    }
    
    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() { 
            return key; 
        }
        public V getValue() { 
            return value; 
        }
        public void setValue(V value) { 
            this.value = value; 
        }
    }

    @Override
    public String toString() {
        String a = "{ \n";
        for (int i = 0; i < this.table.length; i++) {
            a += "Index " + i + ": (";
            if (this.table[i] != null) {
                for (int j = 0; j < this.table[i].size(); j++) {
                    a += " " + this.table[i].get(j).key + " , " + this.table[i].get(j).value;
                }
                a += "); \n";
            } else {
                a += "); \n";
            }

        }
        a += "} \n";
        return a;
    }
}


