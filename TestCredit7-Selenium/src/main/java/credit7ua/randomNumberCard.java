package credit7ua;

import java.util.Random;

public class randomNumberCard {
    public static void main(String[] args) {
        Random random = new Random();

        // Генерация 16-значного числа
        long part1 = (long) (random.nextDouble() * 1_000_000_000_000_000L);
        long part2 = (long) (random.nextDouble() * 1_000_000_000_000_000L);
        String randomNumber = String.format("%016d", (part1 % 1_000_000_000_000_000L) + (part2 % 1_000_000_000_000_000L));

        System.out.println(randomNumber);
    }
}
