public class Tree {

	private static node root = null;
	
	node goLeft(node myNode)
	{
		node child = myNode.right;
		node childLeft = child.left;
		child.left = myNode;
		myNode.right = childLeft;
		return child;
	}

	node goRight(node myNode)
	{
		node child = myNode.left;
		node childRight = child.right;
		child.right = myNode;
		myNode.left = childRight;
		return child;
	}

	boolean isRed(node myNode)
	{
		if (myNode == null)
			return false;
		return (myNode.color == true);
	}


	void swapColors(node node1, node node2)
	{
		boolean temp = node1.color;
		node1.color = node2.color;
		node2.color = temp;
	}

	node insert(node myNode, int value)
	{
		if (myNode == null)
			return new node(value);
		if (value < myNode.value)
			myNode.left = insert(myNode.left, value);
		else if (value > myNode.value)
			myNode.right = insert(myNode.right, value);
		else
			return myNode;

		// Если правый детеныш красный а левый черный или нет его
		if (isRed(myNode.right) && !isRed(myNode.left))
		{
			myNode = goLeft(myNode);
			swapColors(myNode, myNode.left);
		}

		// если левый ребенок и его левый ребенок красные
		if (isRed(myNode.left) && isRed(myNode.left.left))
		{
			myNode = goRight(myNode);
			swapColors(myNode, myNode.right);
		}

		// если оба ребенка и парвый и левый красные
		if (isRed(myNode.left) && isRed(myNode.right))
		{
			myNode.color = !myNode.color;
			myNode.left.color = false;
			myNode.right.color = false;
		}

		return myNode;
	}

	void turn(node node)
	{
		if (node != null)
		{
			turn(node.left);
			System.out.print(node.value + " ");
			turn(node.right);
		}
	}
} 
