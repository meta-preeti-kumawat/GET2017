package com.metacube.heap;

import com.metacube.utility.ArrayList;
import com.metacube.utility.Queue;

public class Printer {
    private ArrayList<Job> jobs = new ArrayList<Job>();
    private Heap<Job> heap = new Heap<Job>(); 

    public void addJob(Job job){
        jobs.add(job);
    }
    
    public Queue<Job> printJobs(){
        if(jobs.length() > 0){
            return heap.heapSort(jobs);
        }
        throw new NullPointerException("No jobs are available to print");
    }
}
