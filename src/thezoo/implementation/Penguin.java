package thezoo.implementation;

import thezoo.model.Animal;
import thezoo.model.Species;

public class Penguin implements Animal {

    private String name;
    private Species species;


    public Penguin(String name, Species species){
        this.name = name;
        this.species = species;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Species getSpecies() {
        return species;
    }
}
