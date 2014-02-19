/**
 * 
 */
package com.anupam.mnc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Anupam Gangotia
 * Profile::http://en.gravatar.com/gangotia
 * github::https://github.com/agangotia
 */

/**This is the datastructure that holds the tree
 * */
public class TreeNode {
	int level;//level of node
	Action actionOccured;//action Occurred 
	States stateOfNode;//state of node
	ArrayList<TreeNode> childNodes;//List of Child nodes
	TreeNode parent;//parent node of this node
	public TreeNode(){
		childNodes=new ArrayList<TreeNode>();
		level=0;
	}
	
	/*Function :printTreeBFS(TreeNode T)
	 *Prints the tree
	 * */
	public void printTreeBFS(TreeNode T){
		Queue<TreeNode> objQueue=new LinkedList<TreeNode>();
		if(T!=null){
			
			objQueue.add(T);
		}

		while(!objQueue.isEmpty()){
			TreeNode objTraversal=objQueue.remove();
			objTraversal.stateOfNode.printStates();
			if(objTraversal.childNodes!=null){
				for(TreeNode temp:objTraversal.childNodes){
					objQueue.add(temp);
				}
			}
		}
	}
	
	/*Function :SearchBFS(TreeNode T,States finalSt)
	 *Search for a node in tree using BFS
	 * */
	public ArrayList<TreeNode> SearchBFS(TreeNode T,States finalSt){
		ArrayList<TreeNode> solutions =new ArrayList<TreeNode>();
		Queue<TreeNode> objQueue=new LinkedList<TreeNode>();
		if(T!=null){
			
			objQueue.add(T);
		}
		while(!objQueue.isEmpty()){
			
			TreeNode objTraversal=objQueue.remove();
			if(finalSt.equals(objTraversal.stateOfNode))
			{
				solutions.add(objTraversal);
				//System.out.println("Solution found at level"+objTraversal.level);
				
			}
	
			//objTraversal.stateOfNode.printStates();
			if(objTraversal.childNodes!=null){
				for(TreeNode temp:objTraversal.childNodes){
					objQueue.add(temp);
		
				}
			}
		}
		return solutions;
	}
	/*Function :printPath(TreeNode t)
	 *prints the path  for a Node
	 * */
	public void printPath(TreeNode t){
		ArrayList<Action> actions =new ArrayList<Action>();
		TreeNode itrtr=t;
		while (itrtr.parent!=null){
			actions.add(itrtr.actionOccured);
			itrtr=itrtr.parent;
			
		}
		
		int NodesPrinted=actions.size()-1;
		itrtr.stateOfNode.printStates();
		//Now itrtr is the root
		while(NodesPrinted>=0){
			
			ArrayList<TreeNode> childNodesTemp=itrtr.childNodes;
			Action checkAction=actions.get(NodesPrinted--);
			for(TreeNode childRead:childNodesTemp){
				if(checkAction==childRead.actionOccured){
					checkAction.printAction();
					childRead.stateOfNode.printStates();
					itrtr=childRead;
				}
			}
		}
	}

}
