package com.metacube.string;

public class StringOperations {
    public static void main(String[] args) {
        UniqueCharactersInString uniqueCharacters = new UniqueCharactersInString();
        
        System.out.println(uniqueCharacters.getNumberOfUniqueCharacters("asdfg  afdhsj").toString());
        System.out.println(uniqueCharacters.getNumberOfUniqueCharacters("a").toString());
        System.out.println(uniqueCharacters.getNumberOfUniqueCharacters("aaaaaaa").toString());
        System.out.println(uniqueCharacters.getNumberOfUniqueCharacters("preeti").toString());
        System.out.println(uniqueCharacters.getNumberOfUniqueCharacters("preeti").toString());
    }
}
