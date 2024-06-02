package certification.generics;

import java.util.Scanner;

public class GenericsApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NpcCreator npcCreator = new NpcCreator();
        System.out.println("Welcome to NPC creator");
        System.out.println("Enter your command. Available commands are: exit, create, print");
        npcCreator.runNpcManagementLobby(scanner.nextLine());
    }

}
