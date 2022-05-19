
package com.mycompany.binarytreegame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
* @file BinaryTreeGame
* @description Binary Search Tree Game
* @date 19/05/2022
* @author Ubeydullah AK - https://github.com/Redkedy
*/ 

public class Main {
        static String[] arrOfPlayer1 ={};
        static String[] arrOfPlayer2={};
        static int totalchild=0;
    public static void main(String args[]) throws Exception{
        int numberRound=1,Player1Score=0,Player2Score=0,childPlayer1=0,childPlayer2=0,count=0;
        Main test= new Main();
        test.readNumbers();  //read the number in txt files 
        Node tree1= new Node(Integer.parseInt(arrOfPlayer1[0]));      
        Node tree2= new Node(Integer.parseInt(arrOfPlayer2[0]));
        for(int i = 1 ; i< arrOfPlayer1.length;i++) //inserting each number to tree
        {  
        test.insert(tree1, Integer.parseInt(arrOfPlayer1[i]));
        }
         for(int i = 1 ; i< arrOfPlayer2.length;i++)
        {  
        test.insert(tree2, Integer.parseInt(arrOfPlayer2[i]));
        } 
         while(numberRound<21&&count<5) { // 5 times in a row or maximum 20 rounds
            System.out.println("Player1 Tree Post Order :");
            test.traversePostorder(tree1);
            childPlayer1=totalchild;
            System.out.println("\n Player1 Tree Total Children: "+childPlayer1);
            System.out.println("*****************************************");
            System.out.println("Player2 Tree Post Order :");
            totalchild=0;
            test.traversePostorder(tree2);
            childPlayer2=totalchild;
            System.out.println("\n Player2 Tree Total Children: "+childPlayer2);
            totalchild=0;
            String winner="";
            if(childPlayer1<childPlayer2){
                if("Player1".equals(winner))
                    count++;
                else
                    count=1;
            Player1Score++;
            winner="Player1"; 
            System.out.println("-------------Player1 won this round------------");
            }
            else if (childPlayer1>childPlayer2) { 
                if("Player2".equals(winner))
                    count++;
                else
                    count=1;
                Player2Score++;
                winner="Player2";
                System.out.println("-------------Player2 won this round------------");
            }
            else  //if scores are equal
            {
                System.out.println("-------------No Winner  (DRAW)------------");
                int  root1=tree1.value;
                int root2=tree2.value;
                test.insert(tree2,root1);
                test.delete(tree2, root2);
                test.insert(tree1, root2);
                test.delete(tree1,root1);
        }
        System.out.println("Round "+numberRound+" Total Score");
        System.out.println("Player1: "+Player1Score);
        System.out.println("Player2: "+Player2Score);
        numberRound++;
        System.out.println("Continue (C)");
        Scanner sc = new Scanner(System.in);
        String secim = sc.nextLine();
        if("C".equals(secim)||"c".equals(secim))
        {
            if("Player1".equals(winner)){
                Node max=test.nodeWithMaximumValue(tree2); // find the node has highest value on tree2
                test.insert(tree1, max.value); //insert the highest value to tree1 
                test.delete(tree2, max.value); // and delete from tree2
                test.insert(tree2, tree1.value); //insert tree1's root to tree2 and delete from tree1
                test.delete(tree1, tree1.value);
            }
            else if ("Player2".equals(winner)){
                Node max=test.nodeWithMaximumValue(tree1);
                test.insert(tree2, max.value);
                test.delete(tree1, max.value);
                test.insert(tree1, tree2.value);
                test.delete(tree2, tree2.value);
         }
        }   
      }
         System.out.println("Game over");  
    } 
   Node delete(Node root,int value){  //deletin node
       try {
           if (root == null)
                return root;
           if (value < root.value)
                root.left = delete(root.left, value);
           else if (value > root.value)
                root.right = delete(root.right, value);
           else {
                    if ((root.left == null) || (root.right == null)) {
                            Node temp = null;
                            if (temp == root.left)
                                temp = root.right;
                            else
                                temp = root.left;
                            if (temp == null) {
                                    root = null;
                             } 
                            else
                                root = temp;
                    }             
                    else {
                        Node temp = nodeWithMaximumValue(root.left);
                        root.value = temp.value;
                        root.left = delete(root.left, temp.value);
                    }
                }
            if (root == null)
                  return null;
   
       } catch (Exception e) {
       }
       finally{
        calculateChilds(root);
       }
    return root;
   }
   Node nodeWithMaximumValue(Node node) { //finding the node has maximum value
        Node current = node;
        while (current.right != null)
                current = current.right;
        return current;
  }
   public void insert(Node node,int value) //inserting a node to tree
   {
       try {
           if (value < node.value||value==node.value) {
                    if (node.left != null) { 
                        insert(node.left, value); 
                        } 
           else { 
                node.left = new Node(value);
             } 
          } 
          else if (value > node.value) {
                if (node.right != null) {
                        insert(node.right, value);
          }     else {
                        node.right = new Node(value); 
          }
        }
       } catch (Exception e) {
       }
       finally {
               calculateChilds(node);
       
       }
   }
   int countChildren(Node head) { 
    if(head==null) return 0;
    return ((head.left == null) ? 0 : countChildren(head.left) + 1) + ((head.right == null) ? 0 : countChildren(head.right) + 1);
   }
     public void calculateChilds(Node node){ //calculate childs with recursive function
         if(node!=null)
         {
             node.numberChild=countChildren(node);
             calculateChilds(node.left);
             calculateChilds(node.right);
         }
        
     }
     void traversePostorder(Node node) 
    {  
        if (node == null)
            return;
        traversePostorder(node.left);
        traversePostorder(node.right);
        System.out.print(("["+node.value+","+node.numberChild+"]-"));
        totalchild+=node.numberChild;
       
    }
     public void readNumbers() throws FileNotFoundException 
     {
         String Player1="",Player2 ="";
         File file1 = new File("C:\\Users\\Redkedy\\Documents\\NetBeansProjects\\BinaryTreeGame\\src\\main\\java\\com\\mycompany\\binarytreegame\\Player1.txt");
         File file2= new File("C:\\Users\\Redkedy\\Documents\\NetBeansProjects\\BinaryTreeGame\\src\\main\\java\\com\\mycompany\\binarytreegame\\Player2.txt");
         Scanner sc1 = new Scanner(file1);
         Scanner sc2= new Scanner(file2);
         while (sc1.hasNextLine())
            Player1=sc1.nextLine();
         while (sc2.hasNextLine())
            Player2=sc2.nextLine();
         sc1.close();
         sc2.close();
         Player1=Player1.trim();
         Player2=Player2.trim();
         arrOfPlayer1 = Player1.split("#");
         arrOfPlayer2 = Player2.split("#"); 
     }
}
