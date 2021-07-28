package thezoo.implementation;

import thezoo.model.Animal;
import thezoo.model.Builder;
import thezoo.model.Species;

public class AnimalBuilder implements Builder {

    private String name;
    private Species species;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSpecies(Species species) {
        this.species = species;
    }

    public Animal getResult() {
        Animal returnAnimal = null;
        switch (species) {
            case GIRAFFE:
                returnAnimal = new Giraffe(this.name, this.species);
                break;
            case LEON:
                returnAnimal = new Leon(this.name, this.species);
                break;
            case SQUIRREL:
                returnAnimal = new Squirrel(this.name, this.species);
                break;
            case PENGUIN:
                returnAnimal = new Penguin(this.name, this.species);
                break;
            default:
        }
        return returnAnimal;
    }


}

