package graphSearch;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
public class DepthFirstSearchAlgo implements ISearchAlgo{
	Set<Node> visited = new HashSet<>();
	Stack<Node> stack = new Stack<>();
	@Override
	public Node execute(Node root, String goal) {
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            // Assuming getLabel() returns a unique identifier for the node
            if (current.getLabel().equals(goal)) {
                // Found the goal, track the path
                List<String> path = NodeUtils.printPath(current);
                System.out.println("DFS Path: " + path);
                return current;
            }

            for (Node node : current.getChildrenNodes()) {
                if (!visited.contains(node)) {
                    visited.add(node);
                    node.setParent(current); // Track the parent
                    stack.push(node);
                }
            }
        }

        // Goal not found
        return null;}
	
	@Override
	public Node execute(Node root, String start, String goal) {
		if(root.getLabel().equals(start)) this.execute(root, goal);
		for (Node r : root.getChildrenNodes()) {
			if(r.getLabel().equals(start)) {this.execute(r, goal);}
			else { this.execute(r, start,goal);}
		}

        // Goal not found
        return null;}
	}

