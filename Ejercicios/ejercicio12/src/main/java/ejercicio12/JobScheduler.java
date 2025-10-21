package ejercicio12;

import java.util.ArrayList;
import java.util.List;

public class JobScheduler {
    private List<JobDescription> jobs;
    private JobSelectionStrategy strategy;

    public JobScheduler () {
        this.jobs = new ArrayList<>();
    }
    
    public JobScheduler (JobSelectionStrategy aStrategy) {
        this.jobs = new ArrayList<>();
        this.strategy = aStrategy;
    }

    public void schedule(JobDescription job) {
        this.jobs.add(job);
    }

    public void unschedule(JobDescription job) {
        if (job != null) {
            this.jobs.remove(job);
        }
    }

    public JobSelectionStrategy getStrategy() {
        return this.strategy; 
    }

    public List<JobDescription> getJobs(){
        return jobs;
    }

    public void setStrategy(JobSelectionStrategy aStrategy) {
        this.strategy = aStrategy;
    }

    public JobDescription next() {
    	JobDescription nextJob = strategy.selectNextJob(jobs);
    	this.unschedule(nextJob);  
        return nextJob;
    }

}
