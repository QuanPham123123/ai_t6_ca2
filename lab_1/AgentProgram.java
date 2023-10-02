package lab_1;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		// TODO
		if(p.getLocationState().equals(Environment.LocationState.CLEAN)) {
			switch (p.getAgentLocation()) {
			case Environment.LOCATION_A:
				return Environment.MOVE_RIGHT;
			case Environment.LOCATION_B:
				return Environment.MOVE_LEFT;
			}
		} else 
			return Environment.SUCK_DIRT;
		return NoOpAction.NO_OP;
		
	}
}