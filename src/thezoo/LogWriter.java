package thezoo;


import thezoo.implementation.PKeyGeneratorImpl;
import thezoo.model.PKeyGenerator;
import thezoo.model.Species;

import java.util.*;

public class LogWriter {
    private Map<Integer, InhibitionLog> logs;
    private PKeyGenerator keyGenerator;

    public LogWriter(){
        this.logs = new TreeMap<>();
        this.keyGenerator = new PKeyGeneratorImpl(1,1);
    }
    public List<InhibitionLog> getLogs(){
        return new ArrayList<InhibitionLog>(logs.values());
    }

    public void addRecord(Date dateIn, Date dateOut, Species species, String name){
        logs.put(keyGenerator.getNumber(), new InhibitionLog(dateIn, dateOut, species, name));
    }

}
