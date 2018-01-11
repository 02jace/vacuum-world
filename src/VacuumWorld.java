/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacuumworld;

import java.util.Scanner;

/**
 *
 * @author Jace
 */
public class VacuumWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Graph graph = new Graph();        
        Scanner scanner = new Scanner(System.in);
        //create nodes
        //params: label, roomA, roomB, vacuum location
        //true = room is clean; true = right room/ room b
        Node nodeQ = new Node('Q', !true, !true, !true);
        Node nodeW = new Node('W', true, !true, !true);
        Node nodeE = new Node('E', true, !true, true);
        Node nodeR = new Node('R', true, true, true);
        Node nodeA = new Node('A', !true, !true, true);
        Node nodeS = new Node('S', !true, true, true);
        Node nodeD = new Node('D', !true, true, !true);
        Node nodeF = new Node('F', true, true, !true);        
        //create graph        
        graph.addNode(nodeQ);
        graph.addNode(nodeW);
        graph.addNode(nodeE);
        graph.addNode(nodeR);
        graph.addNode(nodeA);
        graph.addNode(nodeS);
        graph.addNode(nodeD);
        graph.addNode(nodeF);
        //connect nodes
        graph.connectNode(nodeQ, nodeA);
        graph.connectNode(nodeQ, nodeW);                
        graph.connectNode(nodeW, nodeE);        
        graph.connectNode(nodeE, nodeR);        
        graph.connectNode(nodeA, nodeS);        
        graph.connectNode(nodeS, nodeD);
        graph.connectNode(nodeD, nodeF);
        graph.connectNode(nodeR, nodeF);     
        //user input to identify root node
        //by default is true, changed if user insists otherwise
        boolean roomA = true;
        boolean roomB = true;
        boolean right = true;
        Node rootNode;
        System.out.println("Is room A clean? [y]/[n]");
        if( scanner.nextLine().equals("n") )
            roomA = !roomA;
        System.out.println("Is room B clean? [y]/[n]");
        if( scanner.nextLine().equals("n") )
            roomB = !roomB;
        System.out.println("Vacuum is located at? [l]/[r]");
        if( scanner.nextLine().equals("l") )
            right = !right;
        //identifies starting node
        if( roomA )
            if( roomB )
                if( right )
                    rootNode = nodeR;
                else
                    rootNode = nodeF;
            else
                if( right )
                    rootNode = nodeE;
                else
                    rootNode = nodeW;
        else
            if( roomB )
                if( right )
                    rootNode = nodeS;
                else
                    rootNode = nodeD;
            else
                if( right )
                    rootNode = nodeA;
                else
                    rootNode = nodeQ;
        graph.setRootNode(rootNode);        
        //traverse graph
        graph.traveseGraph();
        
        System.out.println("All rooms are clean.");
        System.out.println("Goal node reached.");
    }

}
