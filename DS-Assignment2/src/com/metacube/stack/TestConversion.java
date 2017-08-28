package com.metacube.stack;

import static org.junit.Assert.assertEquals;

import java.util.InputMismatchException;

import org.junit.Test;

public class TestConversion {
	Conversion convert = new Conversion();
	 
	@Test
    public void testPostfix(){
        assertEquals("Improper expression", "AB+C-", convert.infixToPostfix("A+B-C") );
    }

	@Test(expected = InputMismatchException.class)
    public void testPostfixWithExceptionImproperBrackets(){
        assertEquals("Exception: Improper use of brackets", "", convert.infixToPostfix("A+B-C)") );
    }   

	@Test
    public void testPostfixWithProperBrackets(){
        assertEquals("Expression is not valid", "ABC^+D/", convert.infixToPostfix("(A+B^C)/D") );
    }  

	@Test(expected = InputMismatchException.class)
    public void testPostfixWithExceptionImproperOperators(){
        assertEquals("Exception: Operators are inserted at improper location", "AB+C-", convert.infixToPostfix("{(A+B)-/C}") );
    }   

	@Test(expected = InputMismatchException.class)
    public void testPostfixWithExceptionImproperOperands(){
        assertEquals("Exception: Location of operand is invalid", "AB^C-", convert.infixToPostfix("{(A^B)D/C}") );
    }   

	@Test(expected = InputMismatchException.class)
    public void testInvalidPostfixWithUnwantedCharacters(){
        assertEquals("Exception: You have inserted Improper characters ", "", convert.infixToPostfix("A^B=C") );
    }



}
