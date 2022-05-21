package ar.edu.unlp.info.oo1.ejercicio10;

import java.util.ArrayList;

public class MostEffort extends JobScheduler {

	public MostEffort() {
		super.jobs = new ArrayList<>(); 
	}
	
	public JobDescription next() {
		JobDescription nextJob = null;
	     nextJob = jobs.stream()
	     			.max((j1,j2) -> Double.compare(j1.getEffort(), j2.getEffort()))
	     			.orElse(null);
			    super.unschedule(nextJob);
			    return nextJob;
	}
	
	
}
