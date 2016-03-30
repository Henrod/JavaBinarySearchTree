import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		BST<String> bst = new BST<>();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("add which value? ");

			String n = sc.next();
			bst.add(n);
			bst.printInOrder();
			bst.print();
		}
	}
}
