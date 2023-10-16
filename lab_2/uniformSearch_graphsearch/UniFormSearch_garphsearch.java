package uniformSearch_graphsearch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class UniFormSearch_garphsearch implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeComparator());
        Set<Node> visited = new HashSet<>();
        frontier.add(root);

        while (!frontier.isEmpty()) {
            Node current = frontier.poll();

            if (current.getLabel().equals(goal)) {
                List<String> out = NodeUtils.printPath(current);
                System.out.println("UniFormSearch: " + out);
                System.out.println("Chi phí đư�?ng đi: " + current.getPathCost());
                return current;
            } else {
                visited.add(current);

                List<Edge> children = current.getChildren();
                for (Edge child : children) {
                    Node n = child.getEnd();
                    double newPathCost = current.getPathCost() + child.getWeight();

                    if (!visited.contains(n) && !frontier.contains(n)) {
                        frontier.add(n);
                        n.setPathCost(newPathCost);
                        n.setParent(current);
                    } else if (frontier.contains(n) && newPathCost < n.getPathCost()) {
                        // Nếu đã tồn tại trong frontier và có chi phí mới thấp hơn, cập nhật chi phí
                        frontier.remove(n);  // Loại b�? phiên bản cũ
                        n.setPathCost(newPathCost);
                        n.setParent(current);
                        frontier.add(n);  // Thêm phiên bản mới với chi phí cập nhật
                    }
                }
            }
        }
        return null; // Không tìm thấy đư�?ng đi đến mục tiêu
    }


	@Override
	public Node execute(Node root, String start, String goal) {
		 // Tìm nút bắt đầu trong cây và thực hiện tìm kiếm từ nút đó đến mục tiêu
        Node startNode = findNode(root, start);
        if (startNode != null) {
            return execute(startNode, goal);
        } else {
            System.out.println("Không tìm thấy nút bắt đầu: " + start);
            return null;
        }
    }

    // Phương thức để tìm một nút với nhãn cụ thể trong cây
    private Node findNode(Node root, String label) {
        if (root == null || root.getLabel().equals(label)) {
            return root;
        }

        for (Node child : root.getChildrenNodes()) {
            Node found = findNode(child, label);
            if (found != null) {
                return found;
            }
        }
        return null;
    }
}
