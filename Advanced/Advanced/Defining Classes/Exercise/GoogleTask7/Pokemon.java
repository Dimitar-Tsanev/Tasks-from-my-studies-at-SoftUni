package GoogleTask7;

class Pokemon {
    private String pokemonName;
    private String pokemonElement;

    public Pokemon ( String pokemonName, String pokemonElement) {
        this.pokemonName = pokemonName;
        this.pokemonElement = pokemonElement;

    }
    @Override
    public String toString () {
        return String.format ( "%s %s%n", this.pokemonName,this.pokemonElement);
    }

}
