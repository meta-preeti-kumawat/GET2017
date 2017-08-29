package com.metacube.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * @author Preeti Kumawat
 * Class Name: Concordance
 *
 */
public class Concordance {
    public static void main(String[] args) {
        Map<Character, ArrayList<Integer>> occuranceOfCharacters = new HashMap<Character, ArrayList<Integer>>() ;
        String arguments = "";
        for (int index = 0; index < args.length; index++) {
            arguments += args[index];
        }
        occuranceOfCharacters = mapCharacters(arguments);
        System.out.println(arguments);
        printOutput(occuranceOfCharacters);
    }
    
    /**
     * This method maps character with an array of its indices
     * @param arguments
     * @return Map<Character, ArrayList<Integer>>
     */
    public static Map<Character, ArrayList<Integer>> mapCharacters(String arguments) {
        Map<Character, ArrayList<Integer>> occuranceOfCharacters = new HashMap<Character, ArrayList<Integer>>() ;
        for (int index = 0; index < arguments.length(); index++) {
            Character character = arguments.charAt(index);
            if(occuranceOfCharacters.containsKey(character)){
                occuranceOfCharacters.get(character).add(index);
            }
            else {
                ArrayList<Integer> indexValue = new ArrayList<Integer>();
                indexValue.add(index);
                occuranceOfCharacters.put(character, indexValue);
            }
        }
        return occuranceOfCharacters;
    }

    /**
     * Thid method prints output on console
     * @param occuranceOfCharacters
     */
    public static void printOutput(Map<Character, ArrayList<Integer>> occuranceOfCharacters){
        Iterator<Entry<Character, ArrayList<Integer>>> iterate = occuranceOfCharacters.entrySet().iterator();
        System.out.print("{");
        int count = 0;
        while(iterate.hasNext()){
            if(count != 0){
                System.out.print(", ");
            }
            Map.Entry<Character, ArrayList<Integer>> characterEntry = iterate.next();
            System.out.print(characterEntry.getKey()+"=[");
            for (int index = 0; index < characterEntry.getValue().size(); index++) {
                if(index != 0){
                    System.out.print(", ");
                }
                System.out.print(characterEntry.getValue().get(index));
            }
            System.out.print("]");
            count = 1;
        }
        System.out.print("}");
    }
}
