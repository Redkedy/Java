
package com.mycompany.binarytreegame;

/**
 *
 * @author Redkedy
 */
public class Node {    
        int value; 
        int numberChild;
        Node left, right; 
          
        Node(int value){ 
            this.value = value; 
            left = null; 
            right = null; 
            numberChild=0;
        } 
    } 
