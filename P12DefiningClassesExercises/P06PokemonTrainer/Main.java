package JavaAdvanced.P12DefiningClassesExercises.P06PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, Trainer> data = new LinkedHashMap<>();


        while (!input.equals("Tournament")) {
            //"{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}"
            //    Peter       Charizard        Fire               100

            String[] command = input.split("\\s+");
            String nameTrainer = command[0];
            String namePokemon = command[1];
            String elementPokemon = command[2];
            int healthPokemon = Integer.parseInt(command[3]);

            if (data.containsKey(nameTrainer)) {
                Pokemon pokemon = new Pokemon(namePokemon, elementPokemon, healthPokemon);
                Trainer trainer = data.get(nameTrainer);
                trainer.addPokemon(pokemon);


            } else {
                Pokemon pokemon = new Pokemon(namePokemon, elementPokemon, healthPokemon);
                Trainer trainer = new Trainer(nameTrainer);
                trainer.addPokemon(pokemon);
                data.put(nameTrainer, trainer);

            }

            input = scanner.nextLine();

        }


        String input2 = scanner.nextLine();

        while (!input2.equals("End")) {
            //"Fire", "Water", "Electricity"
            //proverka dali imat pone edin pokemon s daden element ako nqmat gubqt vsichki po 10 kruv
            //ako e 0 ili po malko pokemona umira i trqbva da se iztriqt ot kolekciqta na treniora

            validation(data, input2);

            input2 = scanner.nextLine();
        }


        data.entrySet().stream()
                .sorted(Map.Entry.<String, Trainer>comparingByValue(Comparator.comparing(Trainer::getNumberBadges).reversed()))
                .forEachOrdered(entry ->
                        System.out.println(entry.getKey() + " " + entry.getValue().getNumberBadges() + " " + entry.getValue().getNumberOfPokemon())
                );


    }

    private static void validation(LinkedHashMap<String, Trainer> data, String input2) {
        for (String name : data.keySet()) {
            Trainer trainer = data.get(name);
            List<Pokemon> pokemon = trainer.getPokemonList();

            List<Pokemon> toRemove = new ArrayList<>();

            boolean isValid = false;

            for (Pokemon item : pokemon) {
                String pokemonName = item.getNamePokemon();
                String pokemonElement = item.getElementPokemon();
                int pokemonHealth = item.getHealthPokemon();

                if (input2.equals(pokemonElement)) {
                    isValid = true;
                    break;
                }

            }
            if (!isValid) {
                for (Pokemon item : pokemon) {
                    String pokemonName = item.getNamePokemon();
                    String pokemonElement = item.getElementPokemon();
                    int pokemonHealth = item.getHealthPokemon();

                    if (!input2.equals(pokemonElement)) {
                        pokemonHealth = pokemonHealth - 10;
                        item.setHealthPokemon(pokemonHealth);

                        if (pokemonHealth <= 0) {
                            toRemove.add(item);
                        }
                    }


                }


            } else {
                trainer.setNumberBadges(trainer.getNumberBadges() + 1);
            }

            pokemon.removeAll(toRemove);
            data.put(name, trainer);

        }
    }
}
