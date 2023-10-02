package lab_1_2;

import java.util.Random;

public class AgentProgram {
	private Random random = new Random();
	
	public Action execute(Percept p) {// location, status
		// TODO
		if(p.getLocationState().equals(Environment.LocationState.CLEAN)) {
			// 0= UP, 1= DOWN, 2= LEFT, 3= RIGHT
			// chạy ngẫu nhiên từ 0-> 4
			int randomAction = random.nextInt(4); 
			if (p.getAgentLocation() == Environment.LOCATION_A && randomAction == 0) {
				return Environment.MOVE_UP;
			} else if (p.getAgentLocation() == Environment.LOCATION_A && randomAction == 1) {
				return Environment.MOVE_DOWN;
			} else if (p.getAgentLocation() == Environment.LOCATION_A && randomAction == 2) {
				return Environment.MOVE_LEFT;
			} else if (p.getAgentLocation() == Environment.LOCATION_A && randomAction == 3) {
				return Environment.MOVE_RIGHT;
			}
			if (p.getAgentLocation() == Environment.LOCATION_B && randomAction == 0) {
				return Environment.MOVE_UP;
			} else if (p.getAgentLocation() == Environment.LOCATION_B && randomAction == 1) {
				return Environment.MOVE_DOWN;
			} else if (p.getAgentLocation() == Environment.LOCATION_B && randomAction == 2) {
				return Environment.MOVE_LEFT;
			} else if (p.getAgentLocation() == Environment.LOCATION_B && randomAction == 3) {
				return Environment.MOVE_RIGHT;
			}
			if (p.getAgentLocation() == Environment.LOCATION_C && randomAction == 0) {
				return Environment.MOVE_UP;
			} else if (p.getAgentLocation() == Environment.LOCATION_C && randomAction == 1) {
				return Environment.MOVE_DOWN;
			} else if (p.getAgentLocation() == Environment.LOCATION_C && randomAction == 2) {
				return Environment.MOVE_LEFT;
			} else if (p.getAgentLocation() == Environment.LOCATION_C && randomAction == 3) {
				return Environment.MOVE_RIGHT;
			}
			if (p.getAgentLocation() == Environment.LOCATION_D && randomAction == 0) {
				return Environment.MOVE_UP;
			} else if (p.getAgentLocation() == Environment.LOCATION_D && randomAction == 1) {
				return Environment.MOVE_DOWN;
			} else if (p.getAgentLocation() == Environment.LOCATION_D && randomAction == 2) {
				return Environment.MOVE_LEFT;
			} else if (p.getAgentLocation() == Environment.LOCATION_D && randomAction == 3) {
				return Environment.MOVE_RIGHT;
			}
		} else
			return Environment.SUCK_DIRT;
		return NoOpAction.NO_OP;
		
	}
}