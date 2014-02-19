package com.anupam.mnc;


/**Missionary and Cannibals Problem Solution
 * Three missionaries and three cannibals are on one side of the river, along with a boat
that can hold at most two people. Find a way to get everyone from one side of the
river to the other side of the river, without leaving any group of missionaries (on
either side of the river or in the boat) outnumbered by the cannibals in that place.
 * */
public class MnCmain {

	
	//Main function that starts this program
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Missionary and Cannibals Problem");
		//States is out datastructure that stores information about states
		
		//Our Initial State is (3,3,1,0,0,0) i.e. 3 Missionary,3 Cannibals and one boat on Left Hand Side
		//and  0 Missionary,0 Cannibals and 0 boat on Right Hand Side
		States initialState=new States(3,3,1,0,0,0);
		
		//Our Final State is (0,0,0,3,3,1) i.e. 0 Missionary,0 Cannibals and 0 boat on Left Hand Side
		//and  3 Missionary,3 Cannibals and 1 boat on Right Hand Side
		States finalSt=new States(0,0,0,3,3,1);
		
		SearchSpace objSearchSpace=new SearchSpace();
		objSearchSpace.generateSearchSpace(initialState);//This Method generates the search Tree
		
		objSearchSpace.findSolution(finalSt);//This finds the finalstate in the search tree using BFS,
		//AND prints the solution
		
		System.out.println("Program Ends");
	}

}
