package com.metacube.string;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class UniqueCharactersInString {
    private Set<Character> characterSet = new HashSet<Character>();
    private Map<String, Integer> recentStrings = new LinkedHashMap<String, Integer>();
    
    
    public Output getNumberOfUniqueCharacters(String inputString){
        char[] characters = inputString.toCharArray();
        int size = 0;
        Output output = new Output();
        
        if(recentStrings.containsKey(inputString)){
            size = recentStrings.get(inputString);
            output.setData(size);
            output.setMessage("Retrieved from previous stored results");
        }
        else{
            characterSet.clear();
            for (int index = 0; index < characters.length; index++) {
                if(characters[index] != ' '){
                    characterSet.add(characters[index]);
                }
            }
            size = characterSet.size();
            recentStrings.put(inputString, size);
            output.setData(size);
            output.setMessage("Counted for the first time");
        }
        return output;
    }
}
