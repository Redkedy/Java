# Game With Binary Tree 
This java console application game uses binary tree.
when application runs, it will read player1.txt and player2.txt files. the random numbers are separated by '#'
Each node has number of all children attribute

for example:
# player1.txt:
85#12#7#99#83#105#90#87#101#97 
# player2.txt:
12#5#8#63#45#38#34#60#47#51 </br>

 Player1 Total Children: 9+ 2 + 5 + 0+ 0+ 2 +0+ 0 + 1 +0 = 19 </br>
 Player2 Total Children: 9+ 1 + 6 + 0+ 5+ 1 +2+ 0 + 1 +0 = 25 </br>
 # First Round
![alt text](https://imglink.io/ib/jyvg2BypjM.JPG) </br>
# Rules
According to this calculation result, the one with the lowest total childs wins the round </br>
If the total child numbers are equal, the root nodes are exchanged and deleted from themselves .When the nodes are changed, the BST tree rule is executed according to the new root node.The winner of the game 5 consecutive rounds or the one with the highest score at the end of 20 rounds wins the game. </br>
The winning player adds the node with the highest value from the opposing side's (player's) tree to its tree and deletes it from the opposing side's tree. After this process, the winning player
Gives (adds) the root node of the opposing player's tree to the tree and deletes it from itself.</br>As a deletion rule in a binary search tree, if the deleted node has two children, it is replaced with the maximum value of the left subtree of the node. </br>
# According to these rules, second round:


![alt text](https://imglink.io/ib/amfotNTrxo.JPG) </br>

# Screenshot :

![alt text](https://imglink.io/ib/rHBGcNVXoZ.JPG) </br>

