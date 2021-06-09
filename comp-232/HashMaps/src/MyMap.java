public class MyMap <K, V> {

    private Entry<K, V>[] buckets;
    private int capacity;
    private int size = 0;
    private double lf = 0.75;

    static class Entry <K, V> {
        final K key;
        V value; Entry<K, V> next;
        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
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
        public Entry<K, V> getNext() {
            return next;
        }
        public void setNext(Entry<K, V> next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == this) return true;
            if(obj instanceof Entry) {
                Entry entry = (Entry) obj;
                return key.equals(entry.getKey()) && value.equals(entry.getValue());
            }
            return false;
        }
        @Override
        public int hashCode() {
            int hash = 13;
            hash = 17 * hash + ((key == null) ? 0 : key.hashCode());
            hash = 17 * hash + ((value == null) ? 0 : value.hashCode());
            return hash;
        }
        @Override
        public String toString() {
            return "{" + key + ", " + value + "}";
        }
    }

    public MyMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new Entry[this.capacity];
    }

    public int size() {
        return size;
    }

    private int getBucketSize() {
        return buckets.length;
    }

    public void put(K key, V value) {
        if(size == lf * capacity) {
            // rehash
            Entry<K , V>[] old = buckets;
            capacity *= 2;
            size = 0;
            buckets = new Entry[capacity];

            for(Entry<K, V> e : old) {
                while(e != null) {
                    put(e.key, e.value);
                    e = e.next;
                }
            }
        }
        Entry<K, V> entry = new Entry<>(key, value, null);
        int bucket = getHash(key) % getBucketSize();
        Entry<K, V> existing = buckets[bucket];
        if(existing == null) {
            buckets[bucket] = entry;
            size++;
        } else {
            // compare keys to see if key already exists
            while(existing.next != null) {
                if(existing.key.equals(key)) {
                    existing.value = value;
                    return;
                }
                existing = existing.next;
            }
            if(existing.key.equals(key)) {
                existing.value = value;
            } else {
                existing.next = entry;
                size++;
            }
        }
    }

    public V get(K key) {
        Entry<K, V> bucket = buckets[getHash(key) % getBucketSize()];
        while(bucket != null) {
            if(key == bucket.key) {
                return bucket.value;
            }
            bucket = bucket.next;
        }
        return null;
    }

    private int getHash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }
}
