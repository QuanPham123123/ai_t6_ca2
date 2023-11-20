package lab_7;

public class Entry {
	public static void main(String[] args) {
		GA_NQueenAlgo ga = new GA_NQueenAlgo();
		Node re = ga.execute();
		re.displayBoard();
		System.out.println("Heuristic: " + re.getH());
	}
}
