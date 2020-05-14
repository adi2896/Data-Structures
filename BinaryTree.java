package CTCI;
import java.util.*;

class Node
{
	int data;
	Node left;
	Node right;
}

class BinaryTreeNode
{
	public Node createNewNode(int val)
	{
		Node a = new Node();
		a.data = val;
		a.left = null;
		a.right = null;
		return a;
	}


//InOrder Traversal : left-node-right
	public void inOrder(Node node)
	{
		List<Integer> nodes = new ArrayList<>();
		if(node == null)
		{
			return;
		}

		nodes.add(inOrder(node.left));
		nodes.add(inOrder(node.data));
		nodes.add(inOrder(node.right));

		for(int i = 0; i < nodes.size(); i++)
		{
			System.out.println("In Order Traversal: " + nodes.get(i) + " ");
		}
	}

//PreOrderTraversal : node-left-right
	public void preOrder(Node node)
	{
		List<Integer> nodes = new ArrayList<>();
		if(node == null)
		{
			return;
		}

		nodes.add(inOrder(node.data));
		nodes.add(inOrder(node.left));
		nodes.add(inOrder(node.right));

		for(int i = 0; i < nodes.size(); i++)
		{
			System.out.println("Pre Order Traversal: " + nodes.get(i) + " ");
		}
	}

//PostOrder Traversal : left-right-node
	public void postOrder(Node node)
	{
		List<Integer> nodes = new ArrayList<>();
		if(node == null)
		{
			return;
		}

		nodes.add(inOrder(node.left));
		nodes.add(inOrder(node.right));
		nodes.add(inOrder(node.data));

		for(int i = 0; i < nodes.size(); i++)
		{
			System.out.println("Post Order Traversal: " + nodes.get(i) + " ");
		}
	}


//Level Order Traversal
	public void levelOrder(Node node)
	{
		List<Integer> nodes = new ArrayList<>();
		if(node == null)
			return;

		int height = getHeight(node);
		for(int i = 0; i <= heigth; i++)
		{
			printNodesAtLevel(node, i + 1);
			System.out.println();
		}
	}

//Level Order Iterative
	public void levelOrderIterative(Node node)
	{
		if(node == null)
			return;

		Queue<Node> q = new LinkedLint<>();
		q.add(node);

		while(q.size() > 0)
		{
			Node top = q.remove();
			System.out.println(top.data + " ");

			if(top.left != null)
			{
				q.add(top.left);
			}

			if(top.right != null)
			{
				q.add(top.right);
			}
		}
	}

//Print  elements in reverse level order
	public void reverseLevelOrder(Node node)
	{
		if(node == null)
			return;

		int height = getHeight(node);
		for(int i = height; i >= 0; i--)
		{
			printNodesAtLevel(node, i + 1);
			System.out.println();
		}
	}

//sum of all the nodes in a binary tree
	public int getSum(Node node)
	{
		if(node == null)
			return 0;

		return node.data + getSum(node.left) + getSum(node.right);
	}

//Difference of values at even and odd levels of a binary tree
	public int getDifferenceAtEvenOddLevels(Node node)
	{
		if(node == null)
			return 0;

		return node.data - getSum(node.left) - getSum(node.right);
	}

//Number of nodes in a binary tree
	public int numberOfNodes(Node node)
	{
		if(node == null)
			return 0;

		return 1 + numberOfNodes(node.left) + numberOfNodes(node.right);
	}

//Number of leaf nodes in a binary tree (leaf nodes are the nodes with no children, i.e node.left = null and node.right = null)
	public int numberOfLeafNodes(Node node)
	{
		if(node == null)
			return 0;
		
		if(node.left == null && node.right == null)
			return 1;

		return numberOfLeafNodes(node.left) + numberOfLeafNodes(node.right);
	}

//Height of a binary tree
	public int getHeight(Node node)
	{
		if(node == null)
			return -1;

		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	}

//Print nodes at a given level in a binary tree
	public void printNodesAtLevel(Node node, int level)
	{
		if(node == null)
			return;

		if(level == 1)
		{
			System.out.println(node.data + " ");
			return ;
		}

		printNodesAtLevel(node.left, level-1);
		printNodesAtLevel(node.right, level-1);
	}

//convert binary tree to its mirror tree
	public Node mirrorTree(Node node)
	{
		if(node == null)
			return;

		Node temp = node.left;
		node.left = node.right;
		node.right = temp;

		mirrorTree(node.left);
		mirrorTree(node.right);

		return node;
	}

//Delete Binary tree
	public Node deleteTree(Node node)
	{
		if(node == null)
			return;

		node.left = deleteTree(node.left);
		node.right = deleteTree(node.right);
		System.out.println("Deleting Node: " + node.data);
		node = null;
		return node;
	}

//Get level of node
	public int getLevelOfNode(Node node, int val, int level)
	{
		if(node == null)
			return;

		int l;
		if(node.data == val)
			return level;

		l = getLevelOfNode(node.left, val, level + 1);

		if(l != 0)
		{
			return l;
		}

		l = getLevelOfNode(node.right, val, level + 1);

		return l;
	}
}

public class BinaryTree
{
	public static void main(String[] args) 
	{
		BinaryTreeNode a = new BinaryTreeNode();
		Node root = createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(5);
		root.left.left = a.createNewNode(2);
		root.left.right = a.createNewNode(6);
		root.left.right.left = a.createNewNode(5);
		root.left.right.right = a.createNewNode(11);
		root.right.right.left = a.createNewNode(4);
		root.right.right = a.createNewNode(9);

		a.inOrder(root);
		System.out.println();
		a.preOrder(root);
		System.out.println();
		a.postOrder(root);
		System.out.println();
		System.out.println("Sum is : " + a.getSum(root));
		System.out.println("Difference of even and odd levels is : " + a.getDifferenceAtEvenOddLevels(root));
		System.out.println("Number of nodes in the binary tree are : " + a.numberOfNodes(root));
		System.out.println("Number of Leaf nodes in the binary tree are : " + a.numberOfLeafNodes(root));
		System.out.println("Height of the binary tree is :" + a.getHeight(root));
		a.printNodesAtLevel(root, 2);
		System.out.println();
		a.levelOrder(root);
		Sytem.out.println();
		a.levelOrderIterative(root);
		Sytem.out.println();
		a.reverseLevelOrder(root);
		Sytem.out.println();
		Node mirror = a.mirrorTree(root);
		a.inorder(mirror);
		System.out.println();
		System.out.println(a.getLevelOfNode(root, 11, 1));	
		root = a.deleteTree(root);
	}
}