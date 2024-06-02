package certification.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NpcCreator {

    Scanner scanner = new Scanner(System.in);
    private final List<Npc> npcList = new ArrayList<>();

    public void runNpcManagementLobby(String command) {
        switch (command) {
            case "exit" -> {
                System.out.println("Shutting down");
            }
            case "create" -> startCreatingNpc();
            case "print" -> printNpcList();
            default -> {
                System.out.println("Invalid command, please enter a valid command. Valid commands are: exit, create, print");
                String input = scanner.nextLine();
                scanner.nextLine();
                runNpcManagementLobby(input);
            }
        }
    }

    private void startCreatingNpc() {
        System.out.println("Starting to create an NPC");
        System.out.println("Please specify NPC type: W (warrior), M (merchant)");
        String npcType = scanner.nextLine();
        scanner.nextLine();
        createNpc(npcType);
    }

    private void createNpc(String type) {
        switch (type) {
            case "W", "w" -> {
                this.npcList.add(createWarrior());
                callManagementFunction();
            }
            case "M", "m" -> {
                this.npcList.add(createMerchant());
                callManagementFunction();
            }
            default -> {
                System.out.println("Invalid type. Valid types are: W, M");
                startCreatingNpc();
            }
        }
    }

    private void printNpcList() {
        System.out.println(npcList);
        callManagementFunction();
    }

    private <T extends Npc> void printNpc(T npc) {
        System.out.println(npc);
    }

    private Warrior createWarrior() {
        System.out.println("Starting to create a warrior");
        Npc baseNpc = getBaseNpcDetails();
        System.out.println("Enter NPC HP");
        int hp = scanner.nextInt();
        System.out.println("Enter NPC armour");
        int armour = scanner.nextInt();
        System.out.println("Enter NPC strength");
        int strength = scanner.nextInt();
        Warrior warrior = new Warrior(baseNpc.getName(), baseNpc.getAge(), baseNpc.getGender(),
                baseNpc.getRace(), baseNpc.getFaction(), hp, armour, strength);
        System.out.println("NPC with Warrior type has been created:");
        printNpc(warrior);
        return warrior;
    }

    private Merchant createMerchant() {
        System.out.println("Starting to create a merchant");
        Npc baseNpc = getBaseNpcDetails();
        System.out.println("Enter NPC gold");
        int gold = scanner.nextInt();
        Merchant merchant = new Merchant(baseNpc.getName(), baseNpc.getAge(), baseNpc.getGender(),
                baseNpc.getRace(), baseNpc.getFaction(), gold);
        System.out.println("NPC with Merchant type has been created: ");
        printNpc(merchant);
        return merchant;
    }

    private Npc getBaseNpcDetails() {
        System.out.println("Enter NPC name");
        String npcName = scanner.nextLine();
        System.out.println("Enter NPC age");
        int age = scanner.nextInt();
        System.out.println("Enter NPC gender");
        String gender = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter NPC race");
        String race = scanner.nextLine();
        System.out.println("Enter NPC faction");
        String faction = scanner.nextLine();

        return new Npc(npcName, age, gender, race, faction);
    }

    private void callManagementFunction() {
        System.out.println("Enter your command. Available commands are: exit, create, print");
        scanner.nextLine();
        String command = scanner.nextLine();
        runNpcManagementLobby(command);
    }
}
