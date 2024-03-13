package solidLab.p05_DependencyInversion.p01_HelloWord;

class HelloWorld implements Greeter{

    private final String name;

    public HelloWorld ( String name ) {
        this.name = name;
    }

    @Override
    public String greeting () {
        return String.format ("Good %s, %s", PartOfDayProvider.partOfDay (), this.name);
    }
}
