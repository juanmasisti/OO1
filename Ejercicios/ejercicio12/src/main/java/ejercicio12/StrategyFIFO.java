package ejercicio12;

import java.util.List;

public class StrategyFIFO implements JobSelectionStrategy {
	@Override
	//Java crea constructor vacio por defecto.
	public JobDescription selectNextJob(List<JobDescription> jobs) {
		if (jobs.isEmpty())
			return null;
		return jobs.get(0);
	}

}
