package thezoo.commandparser;

import java.util.Scanner;

public class Parser {

    public String[] getCommand(){
        String[] parse;
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        line.trim().replaceAll("\\s{2,}"," ");
        //System.out.println(line);
        parse = line.split(" ");

        return parse;
    }
}
