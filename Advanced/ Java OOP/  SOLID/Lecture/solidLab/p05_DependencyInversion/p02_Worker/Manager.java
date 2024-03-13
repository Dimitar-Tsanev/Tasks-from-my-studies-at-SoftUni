package solidLab.p05_DependencyInversion.p02_Worker;

class Manager implements Worker {
    private static final String MANAGING = " managing ";
    private final String name;
    private final Worker worker;


    public Manager ( String name, Worker worker ) {
        this.name = name;
        this.worker = worker;
    }

    @Override
    public void work () {
        System.out.print ( this.name + MANAGING + " -> " );
        worker.work ();
    }
}
