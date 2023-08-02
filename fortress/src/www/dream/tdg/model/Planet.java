package www.dream.tdg.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Planet {
	private static final int FRAME_COUNT = 30, TIME_PERIOD = 1000 / FRAME_COUNT;
	
    private static final Planet INSTANCE = new Planet(-9.8f);

	/** m/sec. 포탄이 하늘로 솓구칠때의 방향을 +로 잡을 것임. */
	private float gravity;
	
	
	private List<PhysicalEntity> listPE = new ArrayList<>(); 
	
	private Timer timer = new Timer();
	
	private Planet(float d) {
		this.gravity = d;
	}

	public static Planet getInstance() {
        return INSTANCE;
    }

	public void load(PhysicalEntity pe) {
		listPE.add(pe);
	}

	public void startSimulation() {
		
		TimerTask task = new TimerTask() {
		    public void run() {
		    	for (PhysicalEntity pe : listPE) {
		    		pe.timeElapsed(gravity, TIME_PERIOD);
		    	}
		    }
		};
		
		timer.schedule(task, 0, TIME_PERIOD);
	}

	public void stopSimulation() {
		timer.cancel();
	}

	
}
