package GoogleTask7;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Person {

    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Children> children;

    public Person ( String name ) {
        this.name = name;
        this.pokemons = new ArrayList<> ();
        this.children = new ArrayList<> ();
        this.parents = new ArrayList<> ();

    }
    public void setCompany ( String name, String department, double salary ) {
        this.company = new Company ( name,department,salary );
    }

    public void setCar ( String model, int speed ) {
        this.car = new Car ( model, speed );
    }
    public void addPokemon ( String name,String element ) {
        this.pokemons.add ( new Pokemon ( name,element ) );

    }
    public void addChildren ( String name,String date ) {
        this.children.add ( new Children ( name,date ) );

    }
    public void addParent ( String name,String date ) {
        this.parents.add ( new Parent ( name, date ) );

    }
    public String toString () {
        String carS;

        if (car == null){
            carS = "";
        }else{
            carS = car.toString ();
        }

        String companyS;

        if (company == null){
            companyS = "";
        }else{
            companyS = company.toString ();
        }
        return String.format ( "%s%n" +
                        "Company:%n%s" +
                        "Car:%n%s" +
                        "Pokemon:%n%s" +
                        "Parents:%n%s" +
                        "Children:%n%s",
                name,
                companyS,
                carS,
                pokemons.toString ( ).replaceAll ( "[\\[,\\]]", "" ),
                parents.toString ( ).replaceAll ( "[\\[,\\]]", "" ),
                children.toString ( ).replaceAll ( "[\\[,\\]]", "" ) );
    }

    public String getName () {
        return this.name;
    }

    @Override
    public boolean equals ( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass ( ) != o.getClass ( ) ) return false;
        Person person = (Person) o;
        return Objects.equals ( name, person.name );
    }

    @Override
    public int hashCode () {
        return Objects.hash ( name );
    }
}
