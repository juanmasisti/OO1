package ejercicio12;

import java.util.List;

public interface JobSelectionStrategy {
	
	JobDescription selectNextJob(List<JobDescription> jobs);

}
