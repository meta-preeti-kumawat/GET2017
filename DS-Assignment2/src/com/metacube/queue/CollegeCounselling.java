package com.metacube.queue;

import java.io.IOException;
import java.util.Scanner;

import com.metacube.queue.facade.CollegeFacade;
import com.metacube.queue.facade.StudentFacade;
import com.metacube.queue.model.College;
import com.metacube.queue.model.Student;
import com.metacube.queue.utility.ArrayList;
import com.metacube.queue.utility.Queue;

public class CollegeCounselling {

    static Scanner scan = new Scanner(System.in);
    private static Queue<Student> students = new Queue<Student>();
    private static ArrayList<College> colleges = new ArrayList<College>();
    
    public static void main(String[] args) {
        try {
            students = StudentFacade.getInstance().getQueueOrderByRank();
            colleges = CollegeFacade.getInstance().getList();
            
            while(CollegeFacade.getInstance().getAvailableNumberOfSeats() != 0){
                System.out.println("--------------------------------------------");
                System.out.println("Student '"+students.getFront().getName()+"'(Rank->"+students.getFront().getRank()+") :" );
                System.out.println("--------------------------------------------");
                showCollegeList();
                System.out.println("Select college id: ");
                String id = getValidCollegeId();
                if(CollegeFacade.getInstance().haveSeats(id)){
                    CollegeFacade.getInstance().addStudentToCollege(students.dequeue(), id);
                }
                else{
                    System.out.println("Opps! No seat available");
                }
            }
            System.out.println("---------PROCESS ENDS--------------");
            if(students.getQueueSize() != 0){
                System.out.println("Rest of the Students cannot get Admission as seats are full");
            }
            else{
                System.out.println("All Students were admitted");
            }
            System.out.println("------------RESULTS----------");
            printResult();
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static String getValidCollegeId() {
        String id = scan.next();
        boolean check = false;
        for (int index = 0; index < colleges.length(); index++) {
            if(colleges.get(index).getId().equals(id)){
                check = true;
            }
        }
        if(!check){
            System.out.println("College Id is invalid. Re-Enter: ");
            return getValidCollegeId();
        }
        return id;
    }

    private static void printResult() {
        try {
            ArrayList<Student> students = StudentFacade.getInstance().showAllStudentsWithAllotedCollege();
            System.out.println("Student Id\tStudent Name\tCollege ");
            for (int index = 0; index < students.length(); index++) {
                System.out.println(students.get(index).getId()+"\t\t"+students.get(index).getName()+"\t\t"+students.get(index).getCollege().getName());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showCollegeList() {
        System.out.println("College Id\tCollege Name\tCollege Rank\tSeats");
        for (int index = 0; index < colleges.length(); index++) {
            System.out.println(colleges.get(index).getId()+"\t\t"+colleges.get(index).getName()+"\t\t"+colleges.get(index).getRank()+"\t\t"+colleges.get(index).getSeats());
        }
    }

}
