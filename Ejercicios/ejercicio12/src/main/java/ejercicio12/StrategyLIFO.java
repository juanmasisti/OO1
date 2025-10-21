package ejercicio12;

import java.util.List;

public class StrategyLIFO implements JobSelectionStrategy{
	 @Override
	    public JobDescription selectNextJob(List<JobDescription> jobs) {
	        if (jobs.isEmpty())
	        	return null;
	        return jobs.get(jobs.size() - 1);
	    }

}
