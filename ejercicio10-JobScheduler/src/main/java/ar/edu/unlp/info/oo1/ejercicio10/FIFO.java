package ar.edu.unlp.info.oo1.ejercicio10;

import java.util.ArrayList;

public class FIFO extends JobScheduler {
	
	public FIFO() {
		super.jobs = new ArrayList<>();
	}
	
	public JobDescription next() {
		JobDescription nextJob = null;
		nextJob = jobs.get(0);
    	super.unschedule(nextJob);
    	return nextJob;
	}


}
