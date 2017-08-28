package com.metacube.string;

import static org.junit.Assert.*;

import org.junit.Test;

public class testUniqueCharactersInString {
    UniqueCharactersInString uniqueCharacters = new UniqueCharactersInString();
    
    @Test 
    public void testNumberOfUniqueCharacters(){
        assertEquals("Error: Output not matched", 5, uniqueCharacters.getNumberOfUniqueCharacters("Preeti ").getData());
    }
    @Test 
    public void testNumberOfUniqueCharactersRepeatingStringWithSpace(){
        assertEquals("Error: Output not matched", 1, uniqueCharacters.getNumberOfUniqueCharacters("aaaa aaaa").getData());
    }
    @Test 
    public void testNumberOfUniqueCharactersNonRepeatingString(){
        assertEquals("Error: Output not matched", 3, uniqueCharacters.getNumberOfUniqueCharacters("a b c").getData());
    }
}
