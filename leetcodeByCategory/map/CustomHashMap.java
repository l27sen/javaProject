package leetcodeByCategory.map;

import java.util.LinkedList;

public class CustomHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] buckets;
    private int size;

    public CustomHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public CustomHashMap(int capacity) {
        this.buckets = new LinkedList[capacity];
        this.size = 0;
    }

    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = getBucket(bucketIndex);

        // Check if the key already exists in the bucket
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        // If the key is not found, add a new entry to the bucket
        bucket.add(new Entry<>(key, value));
        size++;

        // Check if the load factor exceeds a threshold, and if so, resize the HashMap
        if (size > buckets.length * 0.75) {
            resize();
        }
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = getBucket(bucketIndex);

        // Search for the key in the bucket and return its value if found
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null; // Key not found
    }

    public void remove(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = getBucket(bucketIndex);

        // Search for the key in the bucket and remove it if found
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                size--;
                return;
            }
        }
    }

    public int size() {
        return size;
    }

    private int getBucketIndex(K key) {
        return key.hashCode() % buckets.length;
    }

    private LinkedList<Entry<K, V>> getBucket(int bucketIndex) {
        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new LinkedList<>();
        }
        return buckets[bucketIndex];
    }

    private void resize() {
        int newCapacity = buckets.length * 2;
        LinkedList<Entry<K, V>>[] newBuckets = new LinkedList[newCapacity];

        for (LinkedList<Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    int newBucketIndex = entry.key.hashCode() % newCapacity;
                    if (newBuckets[newBucketIndex] == null) {
                        newBuckets[newBucketIndex] = new LinkedList<>();
                    }
                    newBuckets[newBucketIndex].add(entry);
                }
            }
        }

        buckets = newBuckets;
    }

    private static class Entry<K, V> {
        private final K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
