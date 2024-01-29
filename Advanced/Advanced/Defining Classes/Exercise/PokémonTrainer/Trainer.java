package PokémonTrainer;

import java.util.ArrayList;
import java.util.List;

class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer ( String name ) {
        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<> ();

    }
    public String getName () {
        return name;

    }
    public int getBadges () {
        return badges;

    }
    public void increaseBadges () {
       this.badges = this.badges + 1;

    }
    public List<Pokemon> getPokemons () {
        return pokemons;

    }
    public void addPokemon ( Pokemon pokemon ) {
        this.pokemons.add ( pokemon );

    }

    @Override
    public String toString () {
        return String.format ( "%s %d %d", this.name, this.badges, this.pokemons.size ());
    }
}
