package ejercicio12;

import java.util.Comparator;
import java.util.List;

public class StrategyHighestPriority implements JobSelectionStrategy {
    @Override
    public JobDescription selectNextJob(List<JobDescription> jobs) {
    	// convierte lista en un flujo de elementos y busca el máximo segun el comparador que se pasa como parametro
        return jobs.stream()
        	// crea automaticamente un comparador que toma 2 JobDescription y llama al metodo indicado en cada uno
            .max(Comparator.comparingInt(JobDescription::getPriority))
            // si la lista está vacia devuelve null.
            .orElse(null);
    }
}
