package certification.generics;

public class Npc {

    private String name;
    private int age;
    private String gender;
    private String race;
    private String faction;

    public Npc(String name, int age, String gender, String race, String faction) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.race = race;
        this.faction = faction;
    }

    public int getAge() {
        return age;
    }

    public String getFaction() {
        return faction;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }
}
