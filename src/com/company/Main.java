package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //create the graph because why specify this on the sheet

        GraphNode S = new GraphNode("S", 11);
        GraphNode A = new GraphNode("A", 8);
        GraphNode B = new GraphNode("B", 9);
        GraphNode C = new GraphNode("C", 10);
        GraphNode D = new GraphNode("D", 5);
        GraphNode G = new GraphNode("G", 0);

        GraphLinkage[] SLinks = {new GraphLinkage(A, 2), new GraphLinkage(B, 3)};
        S.setLinkage(SLinks);

        GraphLinkage[] ALinks = {new GraphLinkage(S, 2), new GraphLinkage(B, 2), new GraphLinkage(D, 4)};
        A.setLinkage(ALinks);

        GraphLinkage[] BLinks = {new GraphLinkage(S, 3), new GraphLinkage(A, 2), new GraphLinkage(D, 7), new GraphLinkage(C, 5)};
        B.setLinkage(BLinks);

        GraphLinkage[] Clinks = {new GraphLinkage(B, 5)};
        C.setLinkage(Clinks);

        GraphLinkage[] DLinks = {new GraphLinkage(A, 4), new GraphLinkage(B, 7), new GraphLinkage(G, 6)};
        D.setLinkage(DLinks);

        GraphLinkage[] GLinks = {new GraphLinkage(D, 6)};
        G.setLinkage(GLinks);

        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();

        //breath first traversal

        nodes.add(S.getTree());

        while(nodes.size() > 0){
            // find node with lowest f(n)
            int nodeLocation = 0;

            for(int i = 0; i < nodes.size(); i++){
                TreeNode checkingNode = nodes.get(i);

                if(nodes.get(nodeLocation).getHeuristic() > checkingNode.getHeuristic()){
                    nodeLocation = i;
                }
            }

            TreeNode thisNode = nodes.get(nodeLocation);
            nodes.remove(nodeLocation);

            if(thisNode.getName().contains("G")){
                System.out.println("Final Node is:" + thisNode.getName());

                //print out the path

                System.out.print("Path to this node is");

                System.out.print(" - " + thisNode.getName());

                while(thisNode.getParent() != null){
                    thisNode = thisNode.getParent();
                    System.out.print(" - " + thisNode.getName());
                }

                break;
            }

            System.out.println("Checking node: " + thisNode.getName());

            nodes.addAll(Arrays.asList(thisNode.getChildren()));
        }
    }
}
