import java.util.Collections;
import java.util.Scanner;

public class Battlefield {
    // inisiasi generics yang digunakan
    private Scanner scanner = new Scanner(System.in);
    private WarriorList<Warrior> warriors = new WarriorList<>();

    public void runMenu() {

        while (true) {
            // Menu utama
            System.out.println("\nWelcome to the Battlefield Simulator!");
            System.out.println("1. Add Warrior");
            System.out.println("2. Display Warriors");
            System.out.println("3. Simulate Battle");
            System.out.println("4. Revive Warrior");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            // melakukan perintah sesuai pilihan menu
            switch (option) {
                case 1:
                    addWarrior();
                    break;
                case 2:
                    displayWarriors();
                    break;
                case 3:
                    simulateBattle();
                    break;
                case 4:
                    revive();
                    break;
                case 5:
                    System.out.println("--------Game Over--------");
                    System.out.println("░░░░░░░█▐▓▓░████▄▄▄█▀▄▓▓▓▌█");
                    System.out.println("░░░░░▄█▌▀▄▓▓▄▄▄▄▀▀▀▄▓▓▓▓▓▌█");
                    System.out.println("░░░▄█▀▀▄▓█▓▓▓▓▓▓▓▓▓▓▓▓▀░▓▌█");
                    System.out.println("░░█▀▄▓▓▓███▓▓▓███▓▓▓▄░░▄▓▐█");
                    System.out.println("░█▌▓▓▓▀▀▓▓▓▓███▓▓▓▓▓▓▓▄▀▓▓▐█");
                    System.out.println("▐█▐██▐░▄▓▓▓▓▓▀▄░▀▓▓▓▓▓▓▓▓▓▌█▌");
                    System.out.println("█▌███▓▓▓▓▓▓▓▓▐░░▄▓▓███▓▓▓▄▀▐█");
                    System.out.println("█▐█▓▀░░▀▓▓▓▓▓▓▓▓▓██████▓▓▓▓▐█");
                    System.out.println("▌▓▄▌▀░▀░▐▀█▄▓▓██████████▓▓▓▌█▌");
                    System.out.println("▌▓▓▓▄▄▀▀▓▓▓▀▓▓▓▓▓▓▓▓█▓█▓█▓▓▌█▌");
                    System.out.println("█▐▓▓▓▓▓▓▄▄▄▓▓▓▓▓▓█▓█▓█▓█▓▓▓▐█");
                    return;
                default:
                    System.out.println("Invalid option. Please enter 1, 2, 3, 4, or 5.");
            }
        }
    }

    // Method untuk tambah warrior ke Arraylist
    private void addWarrior() {
        // Minta tipe warrior
        System.out.println();
        System.out.println("Select type of warrior:");
        System.out.println("1. Tank");
        System.out.println("2. Archer");
        System.out.println("3. Mage");
        int type = getValidInt("Choose an option: ", 1, 3);
        // Meminta nama, health, attack dan defense
        System.out.print("Enter Warrior name: ");
        String name = scanner.nextLine().trim();

        int health = getValidInt("Enter Warrior health (500 to 5000): ", 500, 5000);
        int attack = getValidInt("Enter Warrior attack (30 to 1000): ", 30, 1000);
        int defense = getValidInt("Enter Warrior defense (0 to 250): ", 0, 250);

        Warrior warrior = null;

        // Memvalidasi sesuai tipe warrior
        if (type == 1) {
            // kebutuhan untuk tank yaitu shield
            int shield = getValidInt("Enter shield strength (0 to 500): ", 0, 500);
            warrior = new Tank(name, attack, defense, health, shield);
        } else if (type == 2) {
            // kebutuhan untuk archeryaitu critical rate dan damage multiplier
            double criticalRate = getValidDouble("Enter critical rate (0.0 to 1.0): ", 0.0, 1.0);
            double criticalDamage = getValidDouble("Enter critical damage multiplier (1.0 to 5.0): ", 1.0, 5.0);
            warrior = new Archer(name, attack, defense, health, criticalRate, criticalDamage);
        } else if (type == 3) {
            warrior = new Mage(name, attack, defense, health);
        }
        // menambahkan warrior ke List
        warriors.addWarrior(warrior);
        System.out.println(name + " has been added to the battle.");
    }

    // Method untuk validasi int
    private int getValidInt(String prompt, int min, int max) {
        int input;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a valid number!");
                System.out.print(prompt);
                scanner.next();
            }
            input = scanner.nextInt();
            scanner.nextLine();
            if (input < min || input > max) {
                System.out.println("Please enter a value between " + min + " and " + max + ".");
            }
        } while (input < min || input > max);
        return input;
    }

    // Method untuk validasi double
    private double getValidDouble(String prompt, double min, double max) {
        double input;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextDouble()) {
                System.out.println("That's not a valid number!");
                System.out.print(prompt);
                scanner.next();
            }
            input = scanner.nextDouble();
            scanner.nextLine();
            if (input < min || input > max) {
                System.out.println("Please enter a value between " + min + " and " + max + ".");
            }
        } while (input < min || input > max);
        return input;
    }

    // Method untuk display semua warrior
    public void displayWarriors() {
        // mensort menggunakan collections berdasarkan nama warrior
        Collections.sort(warriors.getWarriors());
        System.out.println("\nCurrent warriors in the battlefield:");
        System.out.println(
                "+------------+-----------------+---------+---------+---------+---------+------------+------------+");
        System.out.printf("| %-10s | %-15s | %-7s | %-7s | %-7s | %-7s | %-10s | %-10s |\n", "Type", "Name", "Attack",
                "Defense", "Health", "Shield", "Crit Rate", "Crit Dmg");
        System.out.println(
                "+------------+-----------------+---------+---------+---------+---------+------------+------------+");
        // Print semua warrior di dalam List
        for (Warrior warrior : warriors.getWarriors()) {
            warrior.displayStats();
            System.out.println(
                    "+------------+-----------------+---------+---------+---------+---------+------------+------------+");
        }
    }

    // Method untuk simulasi attack
    public void simulateBattle() {
        //jika warrior kurang dari 2
        if (warriors.getWarriors().size() < 2) {
            System.out.println("Not enough warriors for a battle. Please add more warriors.");
            return;
        }
        Collections.sort(warriors.getWarriors());

        System.out.println("Select the attacking warrior:");

        // Print setiap warrior di List dan lakukan validasi index attacker
        for (int i = 0; i < warriors.getWarriors().size(); i++) {
            System.out.println((i + 1) + ". " + warriors.getWarriors().get(i).getName());
        }
        int attackerIndex = getValidInt("Choose a warrior: ", 1, warriors.getWarriors().size()) - 1;

        System.out.println("Select the defending warrior:");
        // Print setiap defender di List dan lakukan validasi index defender
        // Pastikan index defender dan attacker berbeda
        for (int i = 0; i < warriors.getWarriors().size(); i++) {
            if (i != attackerIndex) {
                System.out.println((i + 1) + ". " + warriors.getWarriors().get(i).getName());
            }
        }
        int lowerLimit;
        if (attackerIndex == 0) {
            lowerLimit = 2;
        } else {
            lowerLimit = 1;
        }
        int defenderIndex = getValidInt("Choose a warrior: ", lowerLimit, warriors.getWarriors().size()) - 1;
        
        while (attackerIndex == defenderIndex) {
            System.out.println("Attacker and defender cannot be the same");
            defenderIndex = getValidInt("Choose a warrior: ", 1, warriors.getWarriors().size()) - 1;
        }
        // Mensimulasi attacking dan defending beserta outputnya
        Warrior attacker = warriors.getWarriors().get(attackerIndex);
        Warrior defender = warriors.getWarriors().get(defenderIndex);
        System.out.println(attacker.getName() + " is attacking " + defender.getName());
        attacker.attack(defender);
        //M
        if (defender.getHealth() > 0) {
            System.out.println(
                    defender.getName() + " survived the attack with " + defender.getHealth() + " health remaining.");
        } else {
            System.out.println(defender.getName() + " has fallen in battle");
            System.out.println(defender.getName() + " has been removed from the battle");
            warriors.removeWarrior(defender);
            warriors.addFallenWarrior(defender);
        }
    }

    // Method untuk membangkitkan warrior
    public void revive() {
        // Mengimplementasi cara membangkitkan warrior
        if (warriors.getFallenWarriors().isEmpty()) {
            System.out.println("There are currently no warriors to revive.");
        } else {
            //menggunakan for loop, tapi sistem queue first in first out jadi hanya yang pertama saja
            for (Warrior fallenWarrior : warriors.getFallenWarriors()) {
                if (fallenWarrior.getNumRevived() < 3) {
                    System.out.println("Reviving " + fallenWarrior.getName() + "...");
                    fallenWarrior.revive();
                    warriors.removeFallenWarrior(fallenWarrior);
                    System.out.println("Successfully revived " + fallenWarrior.getName() + "!");
                } else {
                    //jika warrior sudah tidak bisa dibangkitkan lagi
                    System.out.println(fallenWarrior.getName() + " cannot be revived anymore.");
                }
            }

        }
    }

    //main method
    public static void main(String[] args) {
        Battlefield battlefield = new Battlefield();
        battlefield.runMenu();

    }
}
