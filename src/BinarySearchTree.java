class BinarySearchTree {


    Node root;

    static int nodeNumber = 0;

    // Constructor
    BinarySearchTree() { root = null; }

    BinarySearchTree(int value) { root = new Node(value); }

    // This method mainly calls insertRec()
    void insert(int key) { root = insertRec(root, key); }

    /* A recursive function to
       insert a new key in BST */
    Node insertRec(Node root, int key)
    {

        if (root == null) {
            root = new Node(key);
            nodeNumber++;
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.key){
            root.left = insertRec(root.left, key);
            root.childrenNumber++;}
        else if (key > root.key) {
            root.right = insertRec(root.right, key);
            root.childrenNumber++;

        }
        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder() { inorderRec(root); }

    int totalChildrenNumberofAllNodes(){
    	return totalChildrenNumberofAllNodesRec(root);
    }

    int totalChildrenNumberofAllNodesRec(Node root){
    	if(root == null)
    		return 0;
    	else
    		return root.childrenNumber + totalChildrenNumberofAllNodesRec(root.left) + totalChildrenNumberofAllNodesRec(root.right);
    }

    Node findMax(Node root){
    	if(root == null)
    		return null;
    	else if(root.right == null)
    		return root;
    	else
    		return findMax(root.right);
    }



    void deleteMax(Node root){
        root = deleteMaxRec(root);
    }

    Node deleteMaxRec(Node root){
    	if(root == null)
    		return null;
    	else if(root.right == null){
    		root = root.left;
    		return root;
    	}
    	else {
            root.childrenNumber--;
            root.right = deleteMaxRec(root.right);

        }
    	return root;
    }

    void deleteRoot(Node root){
        root = deleteRootRec(root);
    }

    Node deleteRootRec(Node root){
    	if(root == null)
    		return null;
    	else if(root.left == null){
    		root = root.right;
    		return root;
    	}
    	else if(root.right == null){
    		root = root.left;
    		return root;
    	}
    	else{
    		Node temp = findMax(root.left);
    		root.key = temp.key;
            root.childrenNumber--;
    		deleteMax(root.left);
    	}
    	return root;
    }

    // A utility function to

    // do inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            System.out.println(root.childrenNumber);
            inorderRec(root.right);
        }
    }

    void postOrder() { postOrderRec(root); }
    void postOrderRec(Node root)
    {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.toString() +" - ");
        }
    }

    void preOrder() { preOrderRec(root); }
    void preOrderRec(Node root)
    {
        if (root != null) {
            System.out.println(root.key);
            preOrderRec(root.left);
            preOrderRec(root.right);

        }
    }

    void findLevelofTree() {

        int maxLevel = 0;
        int currentLevelNodes = 0;
        Node current = root;
        Node next = null;
        while (current != null) {
            next = current.left;
            while (next != null) {
                next = next.left;
                currentLevelNodes++;
            }
            if (currentLevelNodes > maxLevel) {
                maxLevel = currentLevelNodes;
            }
            currentLevelNodes = 0;
            next = current.right;
            while (next != null) {
                next = next.right;
                currentLevelNodes++;
            }
            if (currentLevelNodes > maxLevel) {
                maxLevel = currentLevelNodes;
            }
            current = current.right;
        }

        System.out.println("Yükseklik:  " + maxLevel);
    }


    void findNodeNumber() {
        System.out.println("Düğüm sayısı: " + nodeNumber);
    }

    public int findLeafNumber() {
        return findRecLeafNumber(root);
    }
    public int findRecLeafNumber(Node node) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return findRecLeafNumber(root.left) + findRecLeafNumber(root.right);
    }









}