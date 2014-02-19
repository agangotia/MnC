package com.anupam.mnc;


/**This is the datastructure to hold States in a search tree
 * */
public class States {

	private int stateLeft[]={0,0,0};//array showing missionaries , cannibals , and boat present on Left side
	private int stateRight[]={0,0,0};//array showing missionaries , cannibals , and boat present on Right side
	int missionaryIndex=0;// index of missionary in array
	int cannibalIndex=1;//index of cannibals in array
	int boatIndex=2;//index of boat in array
	
	public States(){
		
	}
	
	//constructor
	public States(int numMissionaryLeft,int numCannibalsLeft,int boatLeft,int numMissionaryRight,int numCannibalsRight,int boatRight){
		stateLeft[missionaryIndex]=numMissionaryLeft;
		stateLeft[cannibalIndex]=numCannibalsLeft;
		stateLeft[boatIndex]=boatLeft;
		
		stateRight[missionaryIndex]=numMissionaryRight;
		stateRight[cannibalIndex]=numCannibalsRight;
		stateRight[boatIndex]=boatRight;
	}
	//overloaded operator to compare two states
	boolean equals(States obj){
		boolean returntype=false;
		if(this.stateLeft[missionaryIndex]==obj.stateLeft[missionaryIndex] && this.stateLeft[cannibalIndex]==obj.stateLeft[cannibalIndex] && this.stateLeft[boatIndex]==obj.stateLeft[boatIndex]){
			if(this.stateRight[missionaryIndex]==obj.stateRight[missionaryIndex] && this.stateRight[cannibalIndex]==obj.stateRight[cannibalIndex] && this.stateRight[boatIndex]==obj.stateRight[boatIndex]){
				return true;
			}	
		}
		
		return returntype;
	}

	public int[] getStateLeft() {
		return stateLeft;
	}

	public void setStateLeft(int stateLeft[]) {
		this.stateLeft = stateLeft;
	}

	public int[] getStateRight() {
		return stateRight;
	}

	public void setStateRight(int stateRight[]) {
		this.stateRight = stateRight;
	}
	
	/*Function : getBoatSide()
	 * returns 0 if boat is on left
	 * returns 1 if boat is on right
	 * */
	public int getBoatSide(){//returns 0, if boat is on left
		//and returns 1, if boat is on right
		int returnside=-1;
		if(stateLeft[boatIndex]==1){//boat is on left side
			returnside=0;
		}
		if(stateRight[boatIndex]==1){//boat is on Right side
			returnside=1;
		}
		if(stateLeft[boatIndex]==1 && stateRight[boatIndex]==1){
			System.out.println("Oops this is not good");
			System.out.println("Boat is on the both sides of the river");
			System.out.println("Check your program");
			returnside=-1;
		}
		return returnside;
		
	}
	
	/*Function : getNumOfMissionariesOnLeft()
	 * returns Number of missionaries present on LEft side
	 * */
	public int getNumOfMissionariesOnLeft(){
		return stateLeft[missionaryIndex];
	}
	
	/*Function : getNumOfMissionariesOnRight()
	 * returns Number of missionaries present on Right side
	 * */
	public int getNumOfMissionariesOnRight(){
		return stateRight[missionaryIndex];
	}
	
	/*Function : getNumOfCannibalsOnLeft()
	 * returns Number of Cannibals present on Left side
	 * */
	public int getNumOfCannibalsOnLeft(){
		return stateLeft[cannibalIndex];
	}
	
	/*Function : getNumOfCannibalsOnRight()
	 * returns Number of Cannibals present on Right side
	 * */
	public int getNumOfCannibalsOnRight(){
		return stateRight[cannibalIndex];
	}
	
	/*Function : checkValidState()
	 * returns true if state is valid
	 * returns false if state is not valid
	 * */
	public boolean checkValidState(){
		boolean returnValue=true;
		//check condition one : on left side missionaries(count)>=cannibals(count)
		if(stateLeft[missionaryIndex]>0 && stateLeft[cannibalIndex]>0){
			if(stateLeft[missionaryIndex]<stateLeft[cannibalIndex])
				return false;
		}
		if(stateRight[missionaryIndex]>0 && stateRight[cannibalIndex]>0){
			//check condition two : on right side missionaries(count)>=cannibals(count)
			if(stateRight[missionaryIndex]<stateRight[cannibalIndex])
				return false;
		}
		
		//check condition three: Boat should either be on left or right
		if(stateLeft[boatIndex]==stateRight[boatIndex])
			return false;
		return returnValue;
		
	}
	/*Function : printStates()
	 * prints the state on system console
	 * 
	 * */
	public void printStates(){
		if(getBoatSide()==0){
			System.out.print("["+stateLeft[missionaryIndex]+","+stateLeft[cannibalIndex]+",1]");
			System.out.print("["+stateRight[missionaryIndex]+","+stateRight[cannibalIndex]+",0]\n");
		}
		else{
			System.out.print("["+stateLeft[missionaryIndex]+","+stateLeft[cannibalIndex]+",0]");
			System.out.print("["+stateRight[missionaryIndex]+","+stateRight[cannibalIndex]+",1]\n");
		}


	}
}
