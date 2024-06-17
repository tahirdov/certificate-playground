package certification.lesson3.generics;

public class Merchant extends Npc {

    private int gold;

    public Merchant(String name, int age, String gender, String race, String faction, int gold) {
        super(name, age, gender, race, faction);
        this.gold = gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public String toString() {
        return String.format("[Name: %s, Age: %d, Gender: %s, Race: %s, Faction: %s, Gold: %d]",
                super.getName(), super.getAge(), super.getGender(), super.getRace(), super.getFaction(), this.gold);

    }
}
