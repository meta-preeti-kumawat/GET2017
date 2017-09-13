package com.metacube.library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.library.model.Title;

public class RecordManagement {
    private static Connection connection;
    private static RecordManagement recordManagement = null;
    
    private RecordManagement() throws SQLException {
        connection = DBConnection.getConnection("library_information_system");
    }
    
    public static RecordManagement getInstance() throws SQLException {
        if(recordManagement == null) {
            synchronized (RecordManagement.class) {
                if(recordManagement == null) {
                    recordManagement = new RecordManagement();
                }
            }
        }
        return recordManagement;
    }
    
    public Object clone() throws CloneNotSupportedException {
       throw new CloneNotSupportedException(); 
    }
    
    public List<Title> getBooksPublishedByAuthor(String name) throws SQLException {
        List<Title> listOfTitles = new ArrayList<Title>();
        
        String query = "SELECT title_id, titles.name, subject_id, publisher_id "
                + " FROM titles"
                + " INNER JOIN title_author USING(title_id)"
                + " INNER JOIN authors USING(author_id)"
                + " WHERE authors.name = '" + name + "'";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            Title title = new Title(resultSet.getInt(1), 
                    resultSet.getString(2), 
                    resultSet.getInt(3), 
                    resultSet.getInt(4));
            listOfTitles.add(title);
        }
        return listOfTitles;
    }

    public boolean isBookAvailable(String titleName) throws SQLException {
        String query = "SELECT status "
                + " FROM titles"
                + " INNER JOIN books USING(title_id)"
                + " WHERE name = '" + titleName + "'";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet resultSet = stmt.executeQuery();
    
        while (resultSet.next()) {
            if(resultSet.getString(1).equals("available")){
                return true;
            }
        }
        return false;
    }

    public int deleteBooksNotUsedForOneYear() throws SQLException {
        int numberOfRows = 0;
        
        String query = "DELETE FROM books"
                + " WHERE accession_no NOT IN ("
                + " SELECT accession_no"
                + " FROM book_issue"
                + " WHERE TIMESTAMPDIFF(YEAR, `issue_date`,CURRENT_TIMESTAMP()) < 1"
                + " ) AND status != 'issued'";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        numberOfRows = stmt.executeUpdate();
        return numberOfRows;
    }
    
    public void closeConnection() throws SQLException{
        connection.close();
    }
}
