package aquarium;

 // task 3. , name:	Water Adventure
public class Main {
    public static void main(String[] args) {
        // Initialize Aquarium
        Aquarium aquarium = new Aquarium("Ocean", 5, 15);
        // Initialize Fish
        Fish fish = new Fish("Goldy", "gold", 4);
        // Print Fish
        System.out.println(fish.toString());

        //Fish: Goldy
        //Color: gold
        //Number of fins: 4

        // Add Fish
        aquarium.add(fish);

        // Find Fish
        aquarium.findFish("Goldy");

        // Get Fish in Pool
        aquarium.getFishInPool();

        // Remove Fish
        System.out.println(aquarium.remove("trendafil")); // true

        Fish secondFish = new Fish("Dory", "blue", 2);
        Fish rtFish = new Fish("Dory", "blue", 2);
        Fish thirdFish = new Fish("Nemo", "orange", 5);

        // Add fish
        aquarium.add(secondFish);
        aquarium.add(thirdFish);
        aquarium.add(rtFish);

        System.out.println (  aquarium.findFish ( "trendafil" )  );
        System.out.println ( aquarium.getCapacity () );
        System.out.println ( aquarium.getName () );
        System.out.println (aquarium.getSize () );
        System.out.println (aquarium.getFishInPool () );

        // Print Aquarium report
        System.out.println(aquarium.report());

        //Aquarium Info:
        //Aquarium: Ocean ^ Size: 15
        //Fish: Dory
        //Color: blue
        //Number of fins: 2
        //Fish: Nemo
        //Color: orange
        //Number of fins: 5
    }
}
