package JavaAdvanced.P12DefiningClassesExercises.P06PokemonTrainer;

public class Pokemon {


    private String namePokemon;
    private String elementPokemon;
    private int healthPokemon;

    public Pokemon(String namePokemon, String elementPokemon, int healthPokemon) {
        this.namePokemon = namePokemon;
        this.elementPokemon = elementPokemon;
        this.healthPokemon = healthPokemon;
    }

    public String getNamePokemon() {
        return namePokemon;
    }

    public String getElementPokemon() {
        return elementPokemon;
    }

    public int getHealthPokemon() {
        return healthPokemon;
    }

    public void setHealthPokemon(int healthPokemon) {
        this.healthPokemon = healthPokemon;
    }
}

