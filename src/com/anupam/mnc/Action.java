package com.anupam.mnc;
/**This is the datastructure to hold Actions in a search tree
 * */
public class Action {
	
	States currentState;
	States FinalState;
	int moveDirection;//0=Moved to left
					//1=Moved to Right
	int numMissionaryMoved;
	int numCannibalsMoved;
	public Action(States currentStateP){
		this.currentState=currentStateP;
	}
	/*Function : moveLeft(int a,int b)
	 * moves a missioanries and b cannibals to left 
	 * */
	public States moveLeft(int numMissionary,int numCannibals){//count on left will increase and on right will decerese
		States finalState=new States(currentState.getNumOfMissionariesOnLeft()+numMissionary,currentState.getNumOfCannibalsOnLeft()+numCannibals,1,currentState.getNumOfMissionariesOnRight()-numMissionary,currentState.getNumOfCannibalsOnRight()-numCannibals,0);
		this.numMissionaryMoved=numMissionary;
		this.numCannibalsMoved=numCannibals;
		this.moveDirection=0;
		this.FinalState=finalState;
		return finalState;
		
	}
	

	/*Function : moveRight(int a,int b)
	 * moves a missioanries and b cannibals to right 
	 * */
	public States moveRight(int numMissionary,int numCannibals){//count on left will decrease and on right will increase
		States finalState=new States(currentState.getNumOfMissionariesOnLeft()-numMissionary,currentState.getNumOfCannibalsOnLeft()-numCannibals,0,currentState.getNumOfMissionariesOnRight()+numMissionary,currentState.getNumOfCannibalsOnRight()+numCannibals,1);
		this.numMissionaryMoved=numMissionary;
		this.numCannibalsMoved=numCannibals;
		this.moveDirection=1;
		this.FinalState=finalState;
		return finalState;
		
	}
	/*Function : printAction()
	 * prints the Action on system console
	 * 
	 * */
	public void printAction(){
		if(moveDirection==0){
			System.out.println("<--["+numMissionaryMoved+"]["+numCannibalsMoved+"]");
			
		}
		else{
			System.out.println("["+numMissionaryMoved+"]["+numCannibalsMoved+"]-->");	
		}
	}

}
