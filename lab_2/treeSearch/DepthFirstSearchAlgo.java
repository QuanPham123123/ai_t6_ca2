package treeSearch;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;


public class DepthFirstSearchAlgo implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Stack<Node> stack = new Stack<>();
		stack.add(root);
		while(!stack.isEmpty()) {
			Node current = stack.pop();
			if(current.getLabel().equals(goal)) {
				List<String> list = NodeUtils.printPath(current);
				System.out.println("DFS: " + list);
				return current;
			}
			for  (Node n : current.getChildrenNodes()) {
				n.setParent(current);
				stack.add(n);
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		if(root.getLabel().equals(start)) this.execute(root, goal);
		for (Node r : root.getChildrenNodes()) {
			if(r.getLabel().equals(start)) {this.execute(r, goal);}
			else { this.execute(r, start,goal);}
		}

        // Goal not found
        return null;}
	

	}

