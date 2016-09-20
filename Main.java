import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("a: add value | i: ith number | p: print tree => ");

			String cmd = sc.next();

			switch(cmd) {
				case "a":
					int value = sc.nextInt();
					bst.add(value);
					break;
				case "p":
					bst.print();
					break;
				case "i":
					int ith = sc.nextInt();
					System.out.println(bst.select(ith).getData());
					break;
			}
		}
	}
}
