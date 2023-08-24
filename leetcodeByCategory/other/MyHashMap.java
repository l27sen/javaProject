package leetcodeByCategory.other;

public class MyHashMap {


  public static void main(String[] args) {
    MyHashMap myHashMap = new MyHashMap();
    myHashMap.put("a", "avalue");
    HashEntry entry = myHashMap.get("a");
    System.out.println(entry.value);
  }

  class HashEntry {

    private Object key;
    private Object value;
    private HashEntry next;
  }

  private int size;

  private int threshold;

  private HashEntry[] tables;

  MyHashMap() {
    tables = new HashEntry[16];
  }

  public void put(Object key, Object value) {
    int index = hashValue(key);
    HashEntry hashEntry = tables[index];
    while (hashEntry != null) {
      if (hashEntry.key.hashCode() == key.hashCode() && hashEntry.key.equals(key) || hashEntry.key
          .equals(key)) {
        hashEntry.value = value;
        return;

      }
      hashEntry = hashEntry.next;
    }
    //if no found
    addNew(key, value, index);
  }

  public void addNew(Object key, Object value, int index) {
    HashEntry hashEntry = new HashEntry();
    hashEntry.key = key;
    hashEntry.value = value;
    HashEntry currentEnty = tables[index];
    hashEntry.next = currentEnty;
    tables[index] = hashEntry;

  }


  public HashEntry get(Object key) {
    int index = hashValue(key);
    HashEntry hashEntry = tables[index];
    while (hashEntry != null) {
      if (hashEntry.key.hashCode() == key.hashCode() && hashEntry.key.equals(key) || hashEntry.key
          .equals(key)) {
        return hashEntry;
      }
      hashEntry = hashEntry.next;

    }
    return null;
  }

  int hashValue(Object key) {
    int hash = key.hashCode() % tables.length;
    return hash;
  }

}
