/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacuumworld;

/**
 *
 * @author Jace
 */
public class Node {
    
    private char label;
    private boolean roomA;
    private boolean roomB;
    private boolean right;    
    //constructors
    public Node(){
        
    }

    public Node(char c, boolean b1, boolean b2, boolean b3) {
        this.label = c;
        this.roomA = b1;
        this.roomB = b2;
        this.right = b3;
    }    
    //setters
    public void setLabel(char c){
        this.label = c;
    }
    //getters
    public char getLabel(){
        return this.label;
    }
    
    public boolean getRoomA(){
        return this.roomA;
    }
    
    public boolean getRoomB(){
        return this.roomB;
    }
    
    public boolean getRight(){
        return this.right;
    }
}
