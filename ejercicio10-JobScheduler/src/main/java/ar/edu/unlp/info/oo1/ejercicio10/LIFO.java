package ar.edu.unlp.info.oo1.ejercicio10;

import java.util.ArrayList;

public class LIFO extends JobScheduler {

	public LIFO() {
		super.jobs = new ArrayList<>();
	}
	
	public JobDescription next() {
		JobDescription nextJob = null;
		nextJob = jobs.get(jobs.size()-1);
    	super.unschedule(nextJob);
    	return nextJob;
	}

	
}
