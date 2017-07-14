/*
 * Assignment4
 * 
 * Date: 14/07/2017
 * 
 * This class solves the 4th problem of Programming fundamentals session 1
 * Simulates First Come First Serve Scheduler
 */

public class Assignment4 {

	int [][]FCFS( int arrival_time [], int job_size[] ){
		int process = arrival_time.length;
		int[][] output = new int[process][5];
		
		for (int i = 0; i < process; i++) {
			output[i][0] = i+1;
			output[i][1] = arrival_time[i];
		}
		
		//Sort processes using arrival time
		for (int i = 0; i < process-1; i++) {
			for (int j = 0; j < process-i-1; j++) {
				
				if(arrival_time[j]>arrival_time[j+1]){
					int temp = arrival_time[j];
					arrival_time[j] = arrival_time[j+1];
					arrival_time[j+1] = temp;
					
					temp = job_size[j];
					job_size[j] = job_size[j+1];
					job_size[j+1] = temp;
					
					temp = output[j][0];
					output[j][0] = output[j+1][0];
					output[j+1][0] = temp;

					temp = output[j][1];
					output[j][1] = output[j+1][1];
					output[j+1][1] = temp;
				}
			}
		}
		
		//set values for initial process
		output[0][2]=0;
		output[0][3]=output[0][1];
		output[0][4]=job_size[0];

		//calculate wait time, start time and finish time
		for (int i = 1; i < process; i++) {
			if(arrival_time[i]<output[i-1][4]){
				output[i][3] = output[i-1][4]+1;
			}
			else{
				output[i][3] = output[i][1];
			}
			output[i][4] = output[i][3]+job_size[i]-1;
			
			output[i][2] = output[i][3] - output[i][1];
		}
			
		System.out.println("Job\tJob arrived time\tJob wait time\tJob start at\tJob finished at");
		for (int i = 0; i < process; i++) {
			System.out.println(output[i][0]+"\t"+output[i][1]+"\t\t\t"+output[i][2]+"\t\t\t"+output[i][3]+"\t\t"+output[i][4]);
		}
		return output;
	}
	
}
