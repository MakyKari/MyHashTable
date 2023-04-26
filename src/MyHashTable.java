public class MyHashTable<K, V> {
    private static class HashNode<K, V>{
        private final K key;
        private final V value;
        private HashNode<K, V> next;
        public HashNode (K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private final HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size = 0;
    public MyHashTable(){
        chainArray = new HashNode[M];
    }
    public MyHashTable(int M){
        chainArray = new HashNode[M];
        this.M = M;
    }
    private int hash(K key){
        return Math.abs(key.hashCode() % M);
    }
    public void put(K key, V value){
        int index = hash(key);
        size++;
        if(chainArray[index] == null){
            chainArray[index] = new HashNode(key, value);
        }
        else{
            HashNode<K, V> temp = chainArray[index];
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new HashNode(key, value);
        }
    }
    public V get(K key){
        int index = hash(key);
        HashNode<K, V> temp = chainArray[index];
        while (temp != null && !temp.key.equals(key)){
            temp = temp.next;
        }
        if(temp == null) throw new Error();
        return temp.value;
    }
    public V remove(K key){
        int index = hash(key);
        HashNode<K, V> temp = chainArray[index];
        HashNode<K, V> prev = temp;
        while (temp != null &&!temp.key.equals(key)){
            prev = temp;
            temp = temp.next;

        }
        if(temp == null) throw new Error();
        size--;
        prev.next = temp.next;
        return temp.value;
    }

    public boolean contains(V value){
        for(int i = 0; i < M; i++){
            HashNode<K, V> temp = chainArray[i];
            while(temp != null){
                if(temp.value.equals(value)) return true;
                temp = temp.next;
            }
        }

        return false;
    }
    public K getKey(V value){
        for(int i = 0; i < M; i++){
            HashNode<K, V> temp = chainArray[i];
            while(temp != null){
                if(temp.value.equals(value)) return temp.key;
                temp = temp.next;
            }
        }
        return null;
    }

    public int[] printBucketSize(){
        int[] res = new int[M];
        for(int i = 0; i < M; i++){
            HashNode<K, V> temp = chainArray[i];
            int s = 0;
            while(temp != null){
                temp = temp.next;
                s++;
            }
            res[i] = s;
        }
        return res;
    }
}
