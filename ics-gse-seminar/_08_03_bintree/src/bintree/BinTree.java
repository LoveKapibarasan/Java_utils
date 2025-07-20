package bintree;

public class BinTree {
	protected String value;
	protected BinTree left;
	protected BinTree right;
	
	public BinTree(String value) {
		this.value = value;
	}
	
	public String toString() {
		return "(" + (left == null ? "" : left.toString()) + 
				value + (right == null ? "" : right.toString()) + ")";
	}
	
	public void insert(BinTree subTree) {
		if (subTree == null) return;
		if (subTree.value != null) {
			int cmp = subTree.value.compareTo(value);
			if (cmp < 0) {
				if (left == null)
					left = subTree;
				else
					left.insert(subTree);
			} else if (cmp > 0) {
				if (right == null)
					right = subTree;
				else
					right.insert(subTree);
			}	
		}		
		insert(subTree.left);
		insert(subTree.right);
	}
	
	public void insert(String s) {
		insert(new BinTree(s));
	}

	public boolean contains(String string) {
		return value.equals(string) ||
				(left != null && left.contains(string)) ||
				(right != null && right.contains(string));
	}
}
