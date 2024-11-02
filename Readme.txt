To compile and run: 

javac BinarySearchTreeDriver.java
javac BinarySearchTree.java

java BinarySearchTreeDriver <inputfile>

------------------------------------------------------------------------------------------------

Pesudeo code: 

getSingleParent(node){
    
    Initialize a list 

    call the helper function with the root and the list 
}

getSingleParentHelper(node, list){

    if the node is null, return the list 

    if the current node has a left child with no right child, add to the list 
    if the current node has a right child with no left child, add to the list 

    call the helper function on the left child  // O(n/2)
    call the helper function on the right child  // O(n/2)

    return the list 
}

Recurance relation: T(n) = 2T(n/2) + O(1)

Master theorem: O(n)

------------------------------------------------------------------------------------------------

getNumLeafNodes(node){

    return the helper function with the root     
}

getNumLeafNodesHelper(node){

    if the current node is null, return 0 

    if right and left node of current are null, return 1 

    return the sum of the helper function of the left and right children of the current node.  // O(n/2)
}

Recurance relation: T(n) = 2T(n/2) + O(1)

Master theorem: O(n)

------------------------------------------------------------------------------------------------

getCousins(node){

    initialize a list 
    find the parent of the current node  // O(n)

    if the parent is null, return the list 

    find the level of the current node  // O(logn)

    call the levelOrder(root, level, parent, list)  // O(n)

    return the list
}

levelOrder(root, level, parent, list){

    if the current node is null, reutrn the list 

    if the level is 0, and the current node is not a child of the parent of the target, then add it to the list 

    else, 
    call the level order on the left child, with level -1  // O(n/2)
    call the level order on the right child, with level -1  // O(n/2)

    return the list 
}

Recurance relation: T(n) = 2T(n/2) + O(1)

Master theorem: O(n)

------------------------------------------------------------------------------------------------