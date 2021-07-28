package thezoo.commandparser;

import thezoo.InhibitionLog;
import thezoo.Zoo;

import java.util.List;

public class PrintLog implements CommandFactory{
    @Override
    public void runCommand(String[] commands, Zoo zoo) {
        List<InhibitionLog> logs = zoo.getHistory();
        if(logs.size()==0){
            System.out.println("History is Empty\n");
        } else {
            for (InhibitionLog oneLog : logs) {
                System.out.println(oneLog);
            }
        }

    }
}
