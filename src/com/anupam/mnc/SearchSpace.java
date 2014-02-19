/**
 * 
 */
package com.anupam.mnc;
import java.util.ArrayList;
/**
 * @author Anupam Gangotia
 * Profile::http://en.gravatar.com/gangotia
 * github::https://github.com/agangotia
 */

/**This class generates the search tree
 * */
public class SearchSpace {
	
	TreeNode SearchTree;
	public SearchSpace(){
		SearchTree =new TreeNode(); 
	}
	/*Function : generateSearchSpace(States InitialStateValue)
	 *generates search tree
	 * */
	public void generateSearchSpace(States InitialStateValue){
		SearchTree.level=0;
		SearchTree.parent=null;//since it is a root node
		SearchTree.actionOccured=null; //since it is a root node
		SearchTree.stateOfNode=InitialStateValue;
		buildTree(SearchTree);//This builds the entire search tree
		//printTreeBFS(SearchTree);
	}
	
	/*Function : findSolution(States finalSt)
	 *Searches for final state solutions in search tree, 
	 *and then selects the optimal solution and prints the path
	 * */
	public void findSolution(States finalSt){
		ArrayList<TreeNode> solutions =SearchTree.SearchBFS(SearchTree ,finalSt);
		if(solutions.size()>0){
			TreeNode optimal=getOptimal(solutions);
			optimal.printPath(optimal);
			//checking all four solutions
			/*for(TreeNode temp:solutions){
				System.out.println("\n \n solution");
				temp.printPath(temp);
			}*/
			
			
		}else{
			System.out.println("\n No Solution Found");
		}
		
	}
	
	/*Function : getOptimal(ArrayList<TreeNode> solutions)
	 * chooses the optimal solutions from a list of solutions
	 * */
	public TreeNode getOptimal(ArrayList<TreeNode> solutions){
		TreeNode optimal=solutions.get(0);
		if(solutions.size()>1){
			for(int i=1;i<solutions.size();i++){
				TreeNode temp=solutions.get(i);
				if(optimal.level<temp.level)
					optimal=temp;
			}
		}
		return optimal;
	}
	
	/*Function : buildTree(TreeNode node)
	 * builds search tree recursively
	 * */
	public void  buildTree(TreeNode node){
		//lets find first set of actions that can perform on this node
		//if the boat is on left
		if(node==null)
			return;
		if(node.stateOfNode.getBoatSide()==0){//Boat on Left
			//check can i move two Missionaries
			if(node.stateOfNode.getNumOfMissionariesOnLeft()>1){
				Action actionTrial=new Action(node.stateOfNode);
				States transitionState=actionTrial.moveRight(2, 0);
				if(transitionState.checkValidState() && !checkCycle(node,transitionState)){
					//actionTrial.printAction();
					//transitionState.printStates();
					
					TreeNode childNode=new TreeNode();
					childNode.level=node.level+1;
					childNode.parent=node;
					childNode.actionOccured=actionTrial;
					childNode.stateOfNode=transitionState;
					actionTrial.currentState=transitionState;
					node.childNodes.add(childNode);
					buildTree(childNode);
				}
			}
			//check can i move two Cannibals
			if(node.stateOfNode.getNumOfCannibalsOnLeft()>1){
				Action actionTrial=new Action(node.stateOfNode);
				States transitionState=actionTrial.moveRight(0, 2);
				if(transitionState.checkValidState() && !checkCycle(node,transitionState)){
					//actionTrial.printAction();
					//transitionState.printStates();
					
					TreeNode childNode=new TreeNode();
					childNode.level=node.level+1;
					childNode.parent=node;
					childNode.actionOccured=actionTrial;
					childNode.stateOfNode=transitionState;
					actionTrial.currentState=transitionState;
					node.childNodes.add(childNode);
					buildTree(childNode);
				}
			}
			//check can i move one missionary and one cannibal
			if(node.stateOfNode.getNumOfCannibalsOnLeft()>0 && node.stateOfNode.getNumOfMissionariesOnLeft()>0){
				Action actionTrial=new Action(node.stateOfNode);
				States transitionState=actionTrial.moveRight(1, 1);
				if(transitionState.checkValidState() && !checkCycle(node,transitionState)){
					//actionTrial.printAction();
					//transitionState.printStates();
					
					TreeNode childNode=new TreeNode();
					childNode.level=node.level+1;
					childNode.parent=node;
					childNode.actionOccured=actionTrial;
					childNode.stateOfNode=transitionState;
					actionTrial.currentState=transitionState;
					node.childNodes.add(childNode);
					buildTree(childNode);
				}
			}
			
			//check if i can move one missionary only
			if(node.stateOfNode.getNumOfMissionariesOnLeft()>0){
				Action actionTrial=new Action(node.stateOfNode);
				States transitionState=actionTrial.moveRight(1, 0);
				if(transitionState.checkValidState() && !checkCycle(node,transitionState)){
					//actionTrial.printAction();
					//transitionState.printStates();
					
					TreeNode childNode=new TreeNode();
					childNode.level=node.level+1;
					childNode.parent=node;
					childNode.actionOccured=actionTrial;
					childNode.stateOfNode=transitionState;
					actionTrial.currentState=transitionState;
					node.childNodes.add(childNode);
					buildTree(childNode);
				}
			}
			//check for cannibals
			if(node.stateOfNode.getNumOfCannibalsOnLeft()>0){
				Action actionTrial=new Action(node.stateOfNode);
				States transitionState=actionTrial.moveRight(0, 1);
				if(transitionState.checkValidState() && !checkCycle(node,transitionState)){
					//actionTrial.printAction();
					//transitionState.printStates();
					
					
					TreeNode childNode=new TreeNode();
					childNode.level=node.level+1;
					childNode.parent=node;
					childNode.actionOccured=actionTrial;
					childNode.stateOfNode=transitionState;
					actionTrial.currentState=transitionState;
					node.childNodes.add(childNode);
					buildTree(childNode);
				}
			}
			//System.out.println("TERMINATING");
			return;
			
		}
		
		else if(node.stateOfNode.getBoatSide()==1){//if the boat is on right
			//check can i move two Missionaries
			if(node.stateOfNode.getNumOfMissionariesOnRight()>1){
				Action actionTrial=new Action(node.stateOfNode);
				States transitionState=actionTrial.moveLeft(2, 0);
				if(transitionState.checkValidState() && !checkCycle(node,transitionState)){
					//actionTrial.printAction();
					//transitionState.printStates();
					
					TreeNode childNode=new TreeNode();
					childNode.level=node.level+1;
					childNode.parent=node;
					childNode.actionOccured=actionTrial;
					childNode.stateOfNode=transitionState;
					actionTrial.currentState=transitionState;
					node.childNodes.add(childNode);
					buildTree(childNode);
				}
			}
			//check can i move two Cannibals
			if(node.stateOfNode.getNumOfCannibalsOnRight()>1){
				Action actionTrial=new Action(node.stateOfNode);
				States transitionState=actionTrial.moveLeft(0, 2);
				if(transitionState.checkValidState() && !checkCycle(node,transitionState)){
					//actionTrial.printAction();
					//transitionState.printStates();
					
					
					TreeNode childNode=new TreeNode();
					childNode.level=node.level+1;
					childNode.parent=node;
					childNode.actionOccured=actionTrial;
					childNode.stateOfNode=transitionState;
					actionTrial.currentState=transitionState;
					node.childNodes.add(childNode);
					buildTree(childNode);
				}
			}
			//check can i move one missionary and one cannibal
			if(node.stateOfNode.getNumOfCannibalsOnRight()>0 && node.stateOfNode.getNumOfMissionariesOnRight()>0){
				Action actionTrial=new Action(node.stateOfNode);
				States transitionState=actionTrial.moveLeft(1, 1);
				if(transitionState.checkValidState() && !checkCycle(node,transitionState)){
					//actionTrial.printAction();
					//transitionState.printStates();
					
					
					TreeNode childNode=new TreeNode();
					childNode.level=node.level+1;
					childNode.parent=node;
					childNode.actionOccured=actionTrial;
					childNode.stateOfNode=transitionState;
					actionTrial.currentState=transitionState;
					node.childNodes.add(childNode);
					buildTree(childNode);
				}
			}
			
			//Also check if i can move 1 missionary only
			if(node.stateOfNode.getNumOfMissionariesOnRight()>0 ){
				Action actionTrial=new Action(node.stateOfNode);
				States transitionState=actionTrial.moveLeft(1, 0);
				if(transitionState.checkValidState() && !checkCycle(node,transitionState)){
					//actionTrial.printAction();
					//transitionState.printStates();
					
					
					TreeNode childNode=new TreeNode();
					childNode.level=node.level+1;
					childNode.parent=node;
					childNode.actionOccured=actionTrial;
					childNode.stateOfNode=transitionState;
					actionTrial.currentState=transitionState;
					node.childNodes.add(childNode);
					buildTree(childNode);
				}
			}
			
			//Also check if i can move 1 cannibal only
			if(node.stateOfNode.getNumOfCannibalsOnRight()>0 ){
				Action actionTrial=new Action(node.stateOfNode);
				States transitionState=actionTrial.moveLeft(0, 1);
				if(transitionState.checkValidState() && !checkCycle(node,transitionState)){
					//actionTrial.printAction();
					//transitionState.printStates();
					
					
					TreeNode childNode=new TreeNode();
					childNode.level=node.level+1;
					childNode.parent=node;
					childNode.actionOccured=actionTrial;
					childNode.stateOfNode=transitionState;
					actionTrial.currentState=transitionState;
					node.childNodes.add(childNode);
					buildTree(childNode);
				}
			}
			//System.out.println("TERMINATING");
			return;
			
		}
		else{
			//System.out.println("TERMINATING");
		}
		
		return;
	}
	
	/*Function : checkCycle(TreeNode Parent,States state2Check)
	 * returns true if cycle is found
	 * */
	public boolean checkCycle(TreeNode Parent,States state2Check){
		if(Parent.parent!=null){
			TreeNode traverse=Parent.parent;
			while(traverse!=null){
				if(traverse.stateOfNode.equals(state2Check))
					return true;
				traverse=traverse.parent;
			}
			
		}else{
			return false;
		}
		return false;
	}
}
