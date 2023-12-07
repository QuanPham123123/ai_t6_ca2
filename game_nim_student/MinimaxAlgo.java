package game_nim_student;

import java.util.List;

public class MinimaxAlgo {
    public void execute(Node node) {
        int v = maxValue(node);
        List<Node> successors = node.getSuccessors();
        for (Node successor : successors) {
            if (minValue(successor) == v) {
                System.out.println("Best move for MIN player: " + successor);
                break;
            }
        }
    }
    
    
	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
    public int maxValue(Node node) {
        if (node.isTerminal()) {
            return evaluateUtility(node);
        }

        int v = Integer.MIN_VALUE;
        List<Node> successors = node.getSuccessors();
        for (Node successor : successors) {
            v = Math.max(v, minValue(successor));
        }
        return v;
    }
    
    // function MIN-VALUE(state) returns a utility value
 	// if TERMINAL-TEST(state) then return UTILITY(state)
 	// v <- Integer.MAX_VALUE
 	// for each s in SUCCESSORS(state) do
 	// v <- MIN(v, MAX-VALUE(s))
 	// return v
    public int minValue(Node node) {
        if (node.isTerminal()) {
            return evaluateUtility(node);
        }

        int v = Integer.MAX_VALUE;
        List<Node> successors = node.getSuccessors();
        for (Node successor : successors) {
            v = Math.min(v, maxValue(successor));
        }
        return v;
    }

    private int evaluateUtility(Node node) {
        if (node.isTerminal()) {
            return node.isTerminal() ? 1 : 0;
        } else {
            return 0;
        }
    }
}
