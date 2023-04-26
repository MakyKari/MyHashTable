import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<ProgrammingTeachers, String> table = new MyHashTable<>();
        Random r = new Random();

        for(int i = 0; i < 10000; i++){
            StringBuilder firstname = new StringBuilder();
            StringBuilder secondname = new StringBuilder();
            StringBuilder profession = new StringBuilder();
            int age = r.nextInt(18, 60), experience = r.nextInt(1, 20);
            for(int j = 0; j < 10; j++){
                firstname.append(r.nextInt(65, 90));
            }
            for(int j = 0; j < 10; j++){
                secondname.append(r.nextInt(65, 90));
            }
            for(int j = 0; j < 10; j++){
                profession.append(r.nextInt(65, 90));
            }
            table.put(new ProgrammingTeachers(firstname.toString(), secondname.toString(), age, experience), profession.toString());
        }

        System.out.println("HashTable has 11 buckets and every bucket has X elements: " + Arrays.toString(table.printBucketSize()));
        ProgrammingTeachers our = new ProgrammingTeachers("Askhar", "Khaimuldin", 18, 17);
        ProgrammingTeachers pastOur = new ProgrammingTeachers("Nursultan", "Khaimuldin", 19, 17);
        table.put(our, "ADS professor");
        table.put(pastOur, "OOP professor");
        System.out.println("Putting the key - Askhar Khaimuldin and value - ADS professor, now sizes: " + Arrays.toString(table.printBucketSize()));
        System.out.println("Putting the key - Nursultan Khaimuldin and value - OOP professor, now sizes: " + Arrays.toString(table.printBucketSize()));
        System.out.println("Get value by the key Askhar Khaimuldin: " + table.get(our));
        System.out.println("Remove by key - Nursultan Khaimuldin: " + table.remove(pastOur));
        System.out.println("Does hashtable has ADS professor?: " + table.contains("ADS professor"));
        System.out.println("Does hashtable has OOP professor?: " + table.contains("OOP professor"));
        System.out.println("Getting key by value ADS professor: " + table.getKey("ADS professor").toString()
        );
    }
}