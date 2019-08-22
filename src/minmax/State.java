package minmax;

import java.util.LinkedList;
import java.util.List;

public class State{
	 
	 int state;
	 boolean firstPlayer;
	 boolean secondPlayer;
	
	 
	 public State(int state, boolean firstPlayer) {
		super();
		this.state = state;
		this.firstPlayer = firstPlayer;
		this.secondPlayer = !firstPlayer;
	}
	 
	 List<State> getActions(){
		 List<State> actions=new LinkedList<>();
		 if(state>4) {
			 actions.add(new State(state-5, secondPlayer));
		 }
		 if(state>3) {
			 actions.add(new State(state-4, secondPlayer));
		 }
		 if(state>2) {
			 actions.add(new State(state-3, secondPlayer));
		 }
		 return actions;
	 }
	 	boolean isTerminal() {
	 		return state<3;
	 	}
	 	double getUtility() {
	 		if(firstPlayer) return -1;
	 		else 		    return 1;
	 		}
	 	}
