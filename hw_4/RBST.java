import java.util.Random;

public class RBST {
	
	private Node root;		// Head node of the tree.
	private Random rand;	// A random object - required to randomly insert nodes into the tree.
	
	// Constructors
	public RBST() {
		root = null;
		rand = new Random();
	}
	public RBST(Node _root) {
		root = _root;
		rand = new Random();
	}

	/**
		Wraper print method to print the contents of the tree. Calls the private print method.
	 */
	public void print() {
		print(root);
		System.out.println();
	}
	/**
		Print method to print the contents of the tree.
	*/
	private void print(Node T) {
		if(T != null){
		print(T.getLeft());
		System.out.print(T.getTeam() + " ");
		print(T.getRight());
        }
		
	}

	/**
		Wrapper for insertNormal method.
	*/
	public void insertNormal(int team, int rank) {
		root = insertNormal(root, team, rank);
	}
	/**
		Insert the data team at position rank into node T. This is the normal insert routine without any balancing.
	*/
	private Node insertNormal(Node T, int team, int rank) {
		if(T == null)
			return new Node(team);

		assert (rank >= 1 && rank <= T.getSize() + 1) : "rank should be between 1 and size of the tree <" + (T.getSize()+1) + ">";
		
		
		int rootRank;
		if(T.getLeft() != null)
			rootRank = T.getLeft().getSize() + 1;
		else 
			rootRank = 1;
		if (rank <= rootRank)
		{
            if(T.getLeft() == null)
            {
                T.setLeft(new Node(team));
            }
            else 
			    T.setLeft(insertNormal(T.getLeft(), team, rank));
		}
		else
		{
            if(T.getRight() == null)
            {
                T.setRight(new Node(team));
            }
            else
			    T.setRight(insertNormal(T.getRight(), team, rank - rootRank));
		}
        
        T.updateSize();
		return T; 
	}
	
	/**
		Split the tree at psition rank. It returns RET, a RBST array of length two. RET[0] is the left side of the split,
		and RET[1] is the right side of the split. This is a wrapper method that calls the private split method.
	*/
	public RBST[] split(int rank) {
		Node [] ret = split(root, rank);
		RBST [] RET = {null, null};
		RET[0] = new RBST(ret[0]);
		RET[1] = new RBST(ret[1]);
		return RET;
	}
	/**
		The private split method that splits tree T at position rank. 
		It returns an array ret, of two nodes - ret[0] is the root of the left tree, and
		ret[1] is the root of the right tree of the split.
	*/
	private Node[] split(Node T, int rank) {
		Node [] ret = {null, null};	// ret[0] is the root node to the left side of the split, ret[1] is the right side.	
		
		// TODO: Fill your code here for the split method. It is easy to implement this recursively.
		// Your base case will be an empty tree. Your recursive case will have three cases - think 
		// what happens if the rank of the root == rank, or if rank is smaller or larger than the rank
		// of the root.
        Node R1 = new Node (T.getTeam());
        Node L1 = new Node (T.getTeam());
        int rankT;
	    if (T == null)
        {
            return ret;
        }
        if (T.getLeft() == null)
        {
            rankT = 1;
        }
        else
            rankT = T.getLeft().getSize() + 1;

       
        if(rankT == rank)
        {
            ret[1] = T.getRight();
            T.setRight(null);
            ret[0] = T;
        }
        else if(rank < rankT)
        {
            ret = split(T.getLeft(), rank);
            Node schlimy = new Node(T.getTeam());
            schlimy.setLeft(ret[1]);
            schlimy.setRight(T.getRight());
            ret[1] = schlimy;
        }
        else
        {
            ret = split(T.getRight(), rank - rankT);
            Node schwifty = new Node(T.getTeam());
            schwifty.setRight(ret[0]);
            schwifty.setLeft(T.getLeft());
            ret[0] = schwifty;
            
        }
        return ret;
	}
	
	/**
		Insert the data team at position rank in the tree. This is a wrapper method that calls the private insert method.
	*/
	public void insert(int team, int rank) {
		root = insert(root, team, rank);
	}
	/**
		The private insert method, that inserts the data team at position rank in the tree rooted at node T. 
		team is inserted at the root with probability 1/(T.getSize()+1). This is done by splitting the tree T
		at position rank+1, creating a new node for team, and attaching the left and right sides of the split as
		the two subtrees of the new node. Otherwise, with probability 1 - 1/(T.getSize()+1), insert recursively
		at either the left tree (rank <= rank of root) or at the right tree (rank > rank of root).
	*/
	private Node insert(Node T, int team, int rank) {
        if(T == null)
        {
            return new Node(team);
        }
        int rootRank;
        if(T.getLeft() == null)
            rootRank = 1;
        else
            rootRank = T.getLeft().getSize() + 1;

		assert (rank >= 1 && rank <= T.getSize() + 1) : "rank should be between 1 and size of the tree <" + (T.getSize()+1) + ">";
	    int randy = new Random().nextInt(T.getSize() + 1);
        if (randy == 0)
         {
             Node [] sides = split(T, rank + 1);
             Node newRoot = new Node(team);
             newRoot.setLeft(sides[0]);
             newRoot.setRight(sides[1]);
             return newRoot;
         }
         if (rank <= rootRank)
         {
             if(T.getLeft() == null)
                 T.setLeft(new Node(team));
             else
                 T.setLeft(insert(T.getLeft(), team, rank));
         
         }
         else
         {
             if (T.getRight() == null)
                 T.setRight(new Node(team));
             else
                 T.setRight(insert(T.getRight(), team, rank - rootRank));
         }
         T.updateSize();
         return T;

		
	}

	/**
		Return the node at position rank in the tree. This is a wrapper method that calls the private select method.
	*/	
	public Node select(int rank) {
		return select(root, rank);
	}
	/**
		The select method that returns the node in the tree at position rank. 
	*/
	private Node select(Node T, int rank) {
		// TODO: Base case. Return null if the tree is empty.
        int root;
        if(T != null && T.getLeft() != null)
        {
            root = T.getLeft().getSize() + 1;
        }
        else
            root = 1;
      
		assert (rank >= 1 && rank <= T.getSize()) : "rank should be between 1 and size of the tree <" + T.getSize() + "> ";
		
		// TODO: Recursive case. Return T if rank is equal to the rank of the root. Else
		// revursively select in either the left tree (rank < rank of root) or the right
		// tree (rank > rank of the root).
        if (T == null)
        {
            return null;
        }
        if (rank == root)
        {
            return T;
        }
        if (rank < root)
        {
            if(T.getLeft() != null)
            {
                   return select(T.getLeft(), rank);
            }
            else
                return null;
        }
        else 
        {
            if (T.getRight() == null)
            {
                return null;
            }
            else
                 return select(T.getRight(), rank - root);
        }


	}

	/**
		Returns the size of the tree.
	*/
	public int getSize() {
		if (root == null) return 0;
		return root.getSize();
	}
}
