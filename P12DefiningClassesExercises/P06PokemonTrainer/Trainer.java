package JavaAdvanced.P12DefiningClassesExercises.P06PokemonTrainer;


import java.util.ArrayList;
import java.util.List;

public class Trainer {

    private String nameTrainer;
    private int numberBadges = 0;
    private List<Pokemon> pokemonList;

    public Trainer(String nameTrainer) {
        this.nameTrainer = nameTrainer;
        this.pokemonList = new ArrayList<>();

    }
    public void addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
    }

    public String getNameTrainer() {
        return nameTrainer;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void removePokemon(Pokemon pokemon) {
        pokemonList.remove(pokemon);
    }

    public void setNumberBadges(int numberBadges) {
        this.numberBadges = numberBadges;
    }

    public int getNumberBadges() {
        return numberBadges;
    }

    public int getNumberOfPokemon() {
        return this.pokemonList.size();
    }
}
