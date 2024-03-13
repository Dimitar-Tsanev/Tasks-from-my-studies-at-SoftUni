package solidLab.p05_DependencyInversion.p02_Worker;

public class Main {
    public static void main(String[] args) {
        Worker worker = new Employ ("Stamat","codding");
        Worker manager = new Manager ( "Not Stamat",worker );
        Worker bigBoss = new Manager ( "The Big Bos", manager );

        worker.work ();
        manager.work ();
        bigBoss.work ();

    }
}
