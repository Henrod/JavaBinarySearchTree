import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("a: add value | i: ith number | p: print tree | r: rank => ");

			String cmd = sc.next();

			switch(cmd) {
				case "a":
					int data = sc.nextInt();
					bst.add(data);
					break;
				case "p":
					bst.print();
					break;
				case "i":
					int ith = sc.nextInt();
					BST<Integer>.Node node = bst.select(ith);
					System.out.println(node == null ? "null" : node.getData());
					break;
				case "r":
					data = sc.nextInt();
					System.out.println(bst.rankWithParentLink(data));
					break;
			}
		}
	}
}
