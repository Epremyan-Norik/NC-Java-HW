package thezoo.implementation;

import thezoo.model.Animal;
import thezoo.model.Species;

public class AnimalImpl  implements Animal{

    private final String name;
    private final Species species;

    public AnimalImpl(String name, Species species){
        this.name = name;
        this.species = species;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Species getSpecies() {
        return this.species;
    }
}
