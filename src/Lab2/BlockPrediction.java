package Lab2;

public class BlockPrediction {
    static { System.out.println("Static Block 1"); }
    static { System.out.println("Static Block 2"); }

    { System.out.println("Instance Block 1"); }
    { System.out.println("Instance Block 2"); }

    public BlockPrediction() { System.out.println("Constructor"); }

    public static void main(String[] args) {
        System.out.println("--- Creating first object ---");
        new BlockPrediction();
        System.out.println("--- Creating second object ---");
        new BlockPrediction();
    }
}
