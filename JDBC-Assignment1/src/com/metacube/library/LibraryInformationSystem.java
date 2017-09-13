package com.metacube.library;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.metacube.library.model.Title;

/**
 * 
 * @author Preeti Kumawat
 * Class Name: LibraryInformationSystem
 * 
 * This class contains main method for execution 
 *
 */
public class LibraryInformationSystem {
    public static void main(String[] args) {
        try {
            RecordManagement recordManagement = RecordManagement.getInstance();
            
            //Query 1
            List<Title> listOfTitles = recordManagement.getBooksPublishedByAuthor("preeti");
            System.out.println("OUTPUT FOR QUERY 1: \n");
            if(listOfTitles.size() > 0){
                System.out.println("Title ID\tTitle Name");
                System.out.println("--------------------------------------------");
                for (Iterator<Title> iterator = listOfTitles.iterator(); iterator
                        .hasNext();) {
                    Title title = (Title) iterator.next();
                    System.out.println(title.getId() + "\t\t" + title.getName());
                }
            }
            else {
                System.out.println("--- NO INFORMATION AVAILABLE ---");
            }
            
            //Query 2
            String bookTitle = "Introduction to Database";
            boolean bookAvailabilityCheck = recordManagement.isBookAvailable(bookTitle);
            System.out.println("\nOUTPUT FOR QUERY 2: ");
            if(bookAvailabilityCheck){
                System.out.println("Book '" + bookTitle + "' is Available");
            }
            else{
                System.out.println("No book with title '" + bookTitle + "' is available at present");
            }
            
            //Query 3
            int unusedBooks = recordManagement.deleteBooksNotUsedForOneYear();
            System.out.println("\nOUTPUT FOR QUERY 3: ");
            if(unusedBooks > 0){
                System.out.println(unusedBooks + " Unused Books were there. Deleted Successfully ");
            }
            else {
                System.out.println("There is no book to delete");
            }
            
            recordManagement.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
