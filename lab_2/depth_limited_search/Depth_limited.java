package depth_limited_search;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Depth_limited implements ISearchAlgo{

		    public Node executeDLS(Node root, String goal, int limitedDepth) {
		        Set<Node> visited = new HashSet<>();
		        return dlsRecursive(root, goal, limitedDepth, visited);
		    }
		    public Node execute(Node root, String goal) {
		        // Default depth limit set to a large value
		        int defaultDepthLimit = Integer.MAX_VALUE;
		        return executeDLS(root, goal, defaultDepthLimit);
		    }
		    private Node dlsRecursive(Node node, String goal, int depthLimit, Set<Node> visited) {
		        if (node.getLabel().equals(goal)) {
		            List<String> out = NodeUtils.printPath(node);
		            System.out.println("Depth-Limited Search: " + out);
		            return node;
		        }

		        if (depthLimit == 0) {
		            return null;
		        }

		        visited.add(node);

		        for (Node child : node.getChildrenNodes()) {
		            if (!visited.contains(child)) {
		                Node result = dlsRecursive(child, goal, depthLimit - 1, visited);
		                if (result != null) {
		                    return result;  
		                }
		            }
		        }

		        return null;  
		    }
}
