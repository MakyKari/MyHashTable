public class ProgrammingTeachers {
    String firstname;
    String lastname;
    private int age = 18;
    private int experience = 1;
    public ProgrammingTeachers(){}
    public ProgrammingTeachers(String firstname, String lastname, int age, int experience){
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.experience = experience;
    }
    @Override
    public int hashCode() {
        int hash = 1;
        for(char let: firstname.toCharArray()){
            hash = let + hash*31;
        }
        for(char let: lastname.toCharArray()){
            hash = let + hash*31;
        }
        hash *= (experience + age);
        return hash;
    }

    @Override
    public String toString() {
        return "ProgrammingTeachers{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", experience=" + experience +
                '}';
    }
}
