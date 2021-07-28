package thezoo.implementation;

import thezoo.model.Animal;
import thezoo.model.Species;

public class Leon implements Animal {

    private String name;
    private Species species;


    public Leon(String name, Species species){
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
