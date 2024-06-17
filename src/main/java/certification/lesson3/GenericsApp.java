package certification.lesson3;

import certification.lesson3.generics.NpcCreator;

import java.util.Scanner;

/**The entire purpose of this REPOSITORY is testing stuff
    There are many cases that validations and handlings are missing,
        as the focus is not creating a business level application, but rather learning and re-learning**/

public class GenericsApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NpcCreator npcCreator = new NpcCreator();
        System.out.println("Welcome to NPC creator");
        System.out.println("Enter your command. Available commands are: exit, create, print");
        npcCreator.runNpcManagementLobby(scanner.nextLine());
    }

}
