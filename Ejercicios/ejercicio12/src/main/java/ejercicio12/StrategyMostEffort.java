package ejercicio12;

import java.util.Comparator;
import java.util.List;

public class StrategyMostEffort implements JobSelectionStrategy {
	    @Override
	    public JobDescription selectNextJob(List<JobDescription> jobs) {
	        return jobs.stream()
	            .max(Comparator.comparingDouble(JobDescription::getEffort))
	            .orElse(null);
	    }
}
