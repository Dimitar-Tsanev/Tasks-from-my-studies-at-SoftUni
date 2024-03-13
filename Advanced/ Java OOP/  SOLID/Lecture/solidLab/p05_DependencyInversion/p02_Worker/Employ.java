package solidLab.p05_DependencyInversion.p02_Worker;

class Employ implements Worker {
    private final String name;
    private final String job;

    public Employ ( String name, String job ) {
        this.name = name;
        this.job = job;
    }

    @Override
    public void work(){
        System.out.println ( this.name + " doing " + this.job  );
    }
}
