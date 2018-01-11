/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacuumworld;

import java.util.ArrayList;

/**
 *
 * @author Jace
 */
public class Graph {
    private Node rootNode;
    private Node currentNode;
    private Node possibleNode;
    private final ArrayList nodes;
    private int[][] adjMatrix;
    private int size;
    //constructors
    public Graph(){
        this.nodes = new ArrayList();
    }
    //methods
    public void traveseGraph(){        
        //sets root node as current node
        this.currentNode = this.rootNode;
        printNode();
        //loops until both rooms are clean
        while( !(this.currentNode.getRoomA() && this.currentNode.getRoomB()) ){
            int index = this.nodes.indexOf(this.currentNode);
            int j = 0;
            
            while(  j < this.size ){
                //searches for adjacent node
                if( this.adjMatrix[index][j] == 1 ){
                    //evaluates node
                    this.possibleNode = (Node) this.nodes.get(j);
                    //checks if room a is clean
                    if( this.currentNode.getRoomA() ){
                        //if possible node is not clean
                        //proceeds to search other connected node
                        if( !this.possibleNode.getRoomA() ){
                            j++;
                        }
                    }
                    //else if room a is not clean
                    else{
                        //checks if room a in possible node is clean
                        if( this.possibleNode.getRoomA() ){
                            //sets the possible node to the current node
                            break;
                        }
                    }
                    //checks if room b is clean
                    if( this.currentNode.getRoomB() ){
                        //if possible node is not clean
                        //proceeds to search other connected node
                        if( !this.possibleNode.getRoomB() ){
                            j++;
                        }                        
                    }
                    //else if room b is not clean
                    else{
                        //checks if room b in possible node is clean
                        if( this.possibleNode.getRoomB() ){
                            break;
                        }
                    }
                }
                j++;       
            }
            printTraversal();            
            this.currentNode = this.possibleNode;
            printNode();
        }        
    }
    //add nodes
    public void addNode(Node n) {
        this.nodes.add(n);
    }    
    //connecting nodes
    public void connectNode(Node x, Node y){
        if( this.adjMatrix == null ){
            this.size = this.nodes.size();
            this.adjMatrix=new int[size][size];
        }
        
        int xIndex = this.nodes.indexOf(x);
        int yIndex = this.nodes.indexOf(y);
        
        this.adjMatrix[xIndex][yIndex]=1;
        this.adjMatrix[yIndex][xIndex]=1;
    }
    
    public void printNode(){
        System.out.println("Current node: " + this.currentNode.getLabel());
    }
    
    public void printTraversal(){
        System.out.println("From node " + this.currentNode.getLabel() + " to node " + this.possibleNode.getLabel());
    }
    //setters
    public void setRootNode(Node n){
        this.rootNode = n;
    }
    
    //getters
    public Node getRootNode(){
        return this.rootNode;
    }    
}
