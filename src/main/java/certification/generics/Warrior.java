package certification.generics;

public class Warrior extends Npc {

    private int HP;
    private int armour;
    private int strength;


    public Warrior(String name, int age, String gender, String race, String faction, int HP, int armour, int strength) {
        super(name, age, gender, race, faction);
        this.HP = HP;
        this.armour = armour;
        this.strength = strength;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d, Gender: %s, Race: %s, Faction: %s, HP: %d, Armour: %d, Strength: %d",
                super.getName(), super.getAge(), super.getGender(), super.getRace(), super.getFaction(), this.HP, this.armour, this.strength);

    }
}
