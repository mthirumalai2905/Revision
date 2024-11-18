class HashMapOpenAddressing {
    private static class Entry {
        String key;
        int value;
        boolean isDeleted;

        Entry(String key, int value) {
            this.key = key;
            this.value = value;
            this.isDeleted = false;
        }
    }

    private Entry[] table;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    public HashMapOpenAddressing() {
        this.table = new Entry[DEFAULT_CAPACITY];
        this.size = 0;
    }

    private int hash(String key) {
        return Math.abs(key.hashCode() % table.length);
    }

    public void put(String key, int value) {
        int index = hash(key);
        int originalIndex = index;
        while (table[index] != null && !table[index].key.equals(key) && !table[index].isDeleted) {
            index = (index + 1) % table.length;
            if (index == originalIndex) throw new RuntimeException("HashMap is full");
        }

        if (table[index] == null || table[index].isDeleted) size++;
        table[index] = new Entry(key, value);
    }

    public Integer get(String key) {
        int index = hash(key);
        int originalIndex = index;
        while (table[index] != null) {
            if (!table[index].isDeleted && table[index].key.equals(key)) {
                return table[index].value;
            }
            index = (index + 1) % table.length;
            if (index == originalIndex) break;
        }
        return null;
    }

    public void remove(String key) {
        int index = hash(key);
        int originalIndex = index;
        while (table[index] != null) {
            if (!table[index].isDeleted && table[index].key.equals(key)) {
                table[index].isDeleted = true;
                size--;
                return;
            }
            index = (index + 1) % table.length;
            if (index == originalIndex) break;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        HashMapOpenAddressing map = new HashMapOpenAddressing();
        map.put("key1", 10);
        map.put("key2", 20);
        map.put("key3", 30);

        System.out.println(map.get("key1")); // Output: 10
        System.out.println(map.get("key2")); // Output: 20
        map.remove("key1");
        System.out.println(map.get("key1")); // Output: null
        System.out.println("Size: " + map.size()); // Output: 2
    }
}
