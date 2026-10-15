package Lab9;

enum Coin {
    QUARTER(25), DIME(10), NICKEL(5), PENNY(1);

    private final int value;
    Coin(int value) { this.value = value; }

    public static void printFewestCoins(int amount) {
        System.out.print(amount + " cents = ");
        for (Coin c : Coin.values()) {
            int count = amount / c.value;
            if (count > 0) System.out.print(count + " " + c.name() + " ");
            amount %= c.value;
        }
        System.out.println();
    }
}

public class CoinChallenge {
    public static void main(String[] args) {
        Coin.printFewestCoins(93); // Output: 3 QUARTER 1 DIME 1 NICKEL 3 PENNY
    }
}