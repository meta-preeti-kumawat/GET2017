package com.metacube.heap;

import java.util.Scanner;

import com.metacube.utility.Queue;

public class PrinterImplementation {
    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        try{
            Printer printer = new Printer();
    
            Job job1 = new Job();
            job1.setDocument("B");
            job1.setPriority(3);

            Job job2 = new Job();
            job2.setDocument("C");
            job2.setPriority(3);
            
            Job job3 = new Job();
            job3.setDocument("E");
            job3.setPriority(1);
            
            Job job4 = new Job();
            job4.setDocument("D");
            job4.setPriority(2);
            
            Job job5 = new Job();
            job5.setDocument("A");
            job5.setPriority(4);
            
            printer.addJob(job1);
            printer.addJob(job2);
            printer.addJob(job3);
            printer.addJob(job4);
            printer.addJob(job5);
            
            Queue<Job> queue = printer.printJobs();
            System.out.println("Jobs are printed as follows:"+queue.getQueueSize());
            while(queue.getQueueSize() > 0){
                System.out.println(queue.getFront().getDocument()+"\t"+queue.dequeue().getPriority());
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
