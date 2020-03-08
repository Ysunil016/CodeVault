package Tree;

public class HuffmanCoding {

	static class Node {
		char data;
		int freq = 0;
		Node left = null;
		Node right = null;

		Node(char data, int freq) {
			this.data = data;
			this.freq = freq;
		}

	}

	public static void main(String[] args) {

		Node root = new Node('\0', 5);
		root.left = new Node('\0', 2);
		root.right = new Node('A', 3);
		root.left.left = new Node('B', 1);
		root.left.right = new Node('C', 1);
		
		getHuffman(root, "1001011");
	}

	static void getHuffman(Node root, String str) {
		Node tRoot = root;
		char[] val = str.toCharArray();
		for (int i = 0; i < val.length; i++) {
			if (tRoot.data == '\0') {
				if (val[i] == '0') {
					tRoot = tRoot.left;
					if (tRoot.data != '\0') {
						System.out.print(tRoot.data);
						tRoot = root;
					}
				} else {
					tRoot = tRoot.right;
					if (tRoot.data != '\0') {
						System.out.print(tRoot.data);
						tRoot = root;
					}
				}
			}
		}
	}

}
