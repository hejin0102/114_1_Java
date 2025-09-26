import java.security.SecureRandom;

public class RollDice  {
    public static void main(String[] args) {
        SecureRandom randomNumbers = new SecureRandom();
        int[] frequency = new int[7]; // Array of frequency counters of dice rolls (1-6)

        for (int roll = 0; roll <= 6000000; roll++) {
            int face = 1 + randomNumbers.nextInt(6); // Randomly generate a number from 1 to 6
            frequency[face]++; // Increment the appropriate counter
        }

        System.out.printf("%s%10s%n", "點數", "出現次數");
        for (int face = 1; face < frequency.length; face++) {
            System.out.printf("%4d%10d%n", face, frequency[face]);
        }
    }
}