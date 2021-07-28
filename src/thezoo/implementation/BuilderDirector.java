package thezoo.implementation;

import thezoo.model.Builder;
import thezoo.model.Species;

public class BuilderDirector {

        public void makeLeon(Builder builder, String name){
                builder.setName(name);
                builder.setSpecies(Species.LEON);
        }
        public void makeSquirrel(Builder builder, String name){
                builder.setName(name);
                builder.setSpecies(Species.SQUIRREL);
        }
        public void makePenguin(Builder builder, String name){
                builder.setName(name);
                builder.setSpecies(Species.PENGUIN);
        }
        public void makeGiraffe(Builder builder, String name){
                builder.setName(name);
                builder.setSpecies(Species.GIRAFFE);
        }
}
