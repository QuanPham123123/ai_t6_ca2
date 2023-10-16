package uniformSearch_graphsearch;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node>{

	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		if(o1.getPathCost() < o2.getPathCost()) return -1;
		if(o1.getPathCost() > o2.getPathCost()) return 1;
		return 0;
	}

}
