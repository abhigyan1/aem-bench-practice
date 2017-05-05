package revisitingBasics;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class Job1 implements Job {
	public void execute(JobExecutionContext jex)
	{
		System.out.println();
		
	}
}
