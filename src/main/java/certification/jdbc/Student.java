package certification.jdbc;

public class Student {

    private int id;
    private String name;
    private int age;
    private String gender;
    private String faculty;

    public Student(int id, String name, int age, String gender, String faculty) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.faculty = faculty;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
