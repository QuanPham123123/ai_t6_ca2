package treeSearch;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;





public class BreadthFirstSearchAlgo implements ISearchAlgo{
	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node current = queue.poll();
			if(current.getLabel().equals(goal)) {
				List<String> list = NodeUtils.printPath(current);
				System.out.println("BFS: " + list);		
				return current;}
			for (Node node : current.getChildrenNodes()) {
				queue.add(node);
				node.setParent(current);
			}	
		}
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public Node execute(treeSearch.Node root, String start, String goal) {
		if(root.getLabel().equals(start)) this.execute(root, goal);
		for (Node r : root.getChildrenNodes()) {
			if(r.getLabel().equals(start)) {this.execute(r,goal);}
			else {this.execute(r, start,goal);}
			}
		
				return null; // không tìm thấy start trong root
			}}
		
	

