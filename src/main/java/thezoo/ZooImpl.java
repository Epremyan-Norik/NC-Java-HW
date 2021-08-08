
package thezoo;

import thezoo.Exceptions.ZooExceptions;
import thezoo.implementation.CageImpl;
import thezoo.implementation.PKeyGeneratorImpl;
import thezoo.model.*;

import java.io.IOException;
import java.util.*;

    public class ZooImpl implements Zoo{

        private Map<Integer, Animal> animals;
        private LogWriter history;
        private Map<Integer, Cage> cages;
        private PKeyGenerator keyGenerator;


        public ZooImpl(){
            history = new LogWriter();
            animals = new TreeMap<>();
            cages = new TreeMap<>();
            keyGenerator =  new PKeyGeneratorImpl(1, 1);
        }

        @Override
        public void checkInAnimal(Animal animal) throws ZooExceptions.IncorrectName, ZooExceptions.CageNotFound {
            String name = animal.getName().toLowerCase(Locale.ROOT);
            for(Animal zooAnimal : animals.values()){
                String zooAnimalName = zooAnimal.getName().toLowerCase(Locale.ROOT);
                if (zooAnimalName.equals(animal.getName())){
                    throw new ZooExceptions.IncorrectName("Animal Name Already Exist");
                }
            }
            boolean cageWasFound = false;
            Species species = animal.getSpecies();
            for(Cage cage : cages.values()){
                if((cage.isVacantCage())&&(cage.getCondition().isAvailableFor().get(0).equals(species))){
                    cage.reserveCage(animal.getName());
                    animals.put(cage.getNumber(), animal);
                    history.addRecord(new Date(), null, animal.getSpecies(), animal.getName());
                    cageWasFound = true;
                }
            }
            if(!cageWasFound) throw new ZooExceptions.CageNotFound("Cage Not Found");
        }

        @Override
        public void checkOutAnimal(String name) throws ZooExceptions.IncorrectName {
            name = name.toLowerCase(Locale.ROOT);
            boolean animalWasFound = false;
            for(Cage cage : cages.values()){
                String zooAnimal = cage.getName();
                if(zooAnimal!= null) {
                    zooAnimal = zooAnimal.toLowerCase(Locale.ROOT);
                    if (zooAnimal.equals(name)) {
                        Animal removeAnimal = animals.get(cage.getNumber());
                        cage.releaseCage();
                        animals.remove(cage.getNumber());
                        history.addRecord(null, new Date(), removeAnimal.getSpecies(), removeAnimal.getName());
                        animalWasFound = true;
                    }
                }
            }
            if(!animalWasFound) throw new ZooExceptions.IncorrectName("Not found animal with name");
        }

        @Override
        public List<InhibitionLog> getHistory() {

            return history.getLogs();
        }

        @Override
        public void putCage(double area, Condition condition) {
            Cage cage = new CageImpl(keyGenerator, area, condition);
            cages.put(cage.getNumber(), cage);
        }

        @Override
        public void removeCage(int number) {
            cages.remove(number);
        }

}
