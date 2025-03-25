import java.util.*;
class Job
{
	int id;
	int deadline; 
	int profit;
	public Job(int id,int deadline,int profit) 
	{ 
		this.id=id;
		this.deadline=deadline; 
		this.profit=profit;
	}
}
public class JobSequence 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of jobs:"); 
		int n=sc.nextInt();
		Job[] jobs=new Job[n]; 
		for(int i=0;i<n;i++) 
		{
			System.out.println("Enter id, deadline and profit for job "+(i+1)+" :"); 
			int id=sc.nextInt();
			int deadline=sc.nextInt(); 
			int profit=sc.nextInt();
			jobs[i]=new Job(id,deadline,profit);
		}
		System.out.println("Max profit sequence of jobs: "); 
		int maxprofit=jobSequencing(jobs,n);
		System.out.println("Maximum profit: "+maxprofit);
		sc.close();
	}

	public static int jobSequencing(Job[] jobs,int n) 
	{ 
		Arrays.sort(jobs,(a,b)->b.profit-a.profit); 
		boolean[] result=new boolean[n];
		int jobSequence[]=new int[n]; 
		Arrays.fill(result, false);
		Arrays.fill(jobSequence, -1); 
		int maxProfit = 0;
		for (int i = 0; i < n; i++) 
		{
			for (int j = Math.min(n, jobs[i].deadline) - 1; j >= 0; j--) 
			{ 
				if (result[j] == false) 
				{
					result[j] = true; 
					jobSequence[j] = i;
					maxProfit += jobs[i].profit; 
					break;
				}
			}
		}
		for (int i = 0; i < n; i++) 
		{
			if (jobSequence[i] != -1) 
			{
				System.out.print(jobs[jobSequence[i]].id + " ");
			}
		}
		System.out.println(); 
		return maxProfit;
	}
}
