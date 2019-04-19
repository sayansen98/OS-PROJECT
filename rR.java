import java.util.*;
class assrR
{
	static void findwttime(int process[],int n,int bt[],int wt[],int quantum)//waiting time
	{

		int r_bt[] =new int[n];
		for(int i=0;i<n;i++)
		r_bt[i]=bt[i];
		
		
		int t=0;
		while(true)
		{
			boolean done=true;
			for(int i=0;i<n;i++)
			{
				if(r_bt[i]>0)
				{
					done=false;
					if(r_bt[i]>quantum)
					{
						t+=quantum;
						
						r_bt[i]-=quantum;
					}
					else
					{
						t=t+r_bt[i];
						
						wt[i]=t-bt[i];
						r_bt[i]=0;
					}
				}
			}
			if(done==true)
		
			break;
	}
	}
	static void turnaroundtime(int process[],int n,int bt[],int wt[],int tat[])
	{
		for(int i=0;i<n;i++)
		{
			tat[i]=bt[i]+wt[i];
			
		}
	}
	static void findavgtime(int process[],int n,int bt[],int quantum)
	{
		int wt[]=new int[n];
		int tat[]=new int[n];
		int t_wt=0;
		int t_tat=0;
		    findwttime(process,n,bt,wt,quantum);
			 turnaroundtime( process, n, bt, wt, tat);
			 System.out.println("processes"+"  "+"bursttime"+"  "+"waitingtime"+"  "+"turnaroundtime");
			 for(int i=0;i<n;i++)
			 {
			 	t_wt=t_wt+wt[i];
			 	t_tat=t_tat+tat[i];
			 	System.out.println(" "+(i+1)+"\t\t"+bt[i]+"\t"+wt[i]+"\t"+tat[i]);
			 }
			 System.out.println("avarge waiting time="+(float)t_wt/(float)n);
              System.out.println("avarge turn around time="+(float)t_tat/(float)n);
			 
	}
	public static void main(String[]sk)
	{int p;
		int j;
		int process[]=new int[7];
		int brust_time[]=new int[7];
		Scanner sc=new Scanner(System.in);
         System.out.println("enter the number of process u want work with ===");
         p=sc.nextInt();
         for(int i=0;i<p;i++)
         {
         	process[i]=sc.nextInt();

     }
     System.out.println("enter the burst_time");
     for(int i=0;i<p;i++)
     {
     	brust_time[i]=sc.nextInt();
     }
     System.out.println(" enter the quantum  in milisecond");
     j=sc.nextInt();
	
		int n=p;
		findavgtime(process,n,brust_time,j);
	}
	
}
