package thezoo.implementation;

import thezoo.model.Condition;
import thezoo.model.Species;

import java.util.ArrayList;
import java.util.List;


public class –°onditionImpl implements Condition {

    private List<Species> availableFor;

    public –°onditionImpl(Species species) {
        availableFor = new ArrayList<Species>();
       addSpecies(species);
    }

    private void addSpecies(Species species){
        if(!availableFor.contains(species)) {
            availableFor.add(species);
        }
    }

    @Override
    public List<Species> isAvailableFor() {
        return availableFor;
    }
}
