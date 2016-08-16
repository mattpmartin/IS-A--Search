package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        TreeNode[] emptyArray = {};
        TreeNode g18 = new TreeNode("G18", 15, emptyArray, 0);
        TreeNode c17 = new TreeNode("C17", 17, emptyArray, 10);
        TreeNode g16 = new TreeNode("G16", 19, emptyArray, 0);
        TreeNode g15 = new TreeNode("G15", 16, emptyArray, 0);
        TreeNode a14 = new TreeNode("A14", 12, emptyArray, 8);
        TreeNode[] d13Children = {g18};
        TreeNode d13 = new TreeNode("D13", 9, d13Children, 5);
        g18.addParent(d13);
        TreeNode g12 = new TreeNode("G12", 11, emptyArray, 0);
        TreeNode[] b11Children = {c17};
        TreeNode b11 = new TreeNode("B11", 12, b11Children, 5);
        c17.addParent(b11);
        TreeNode[] b10Children = {g16};
        TreeNode d10 = new TreeNode("D10", 13, b10Children, 5);
        g16.addParent(d10);
        TreeNode c9 = new TreeNode("C9", 9, emptyArray, 10);
        TreeNode[] d8Children = {a14, g15};
        TreeNode d8 = new TreeNode("D8", 10, d8Children, 5);
        a14.addParent(d8);
        g15.addParent(g15);
        TreeNode c7 = new TreeNode("C7", 8, emptyArray, 10);
        TreeNode[] a6Children = {d13};
        TreeNode a6 = new TreeNode("A6", 5, a6Children, 8);
        d13.addParent(a6);
        TreeNode[] d5Children = {b11, g12};
        TreeNode d5 = new TreeNode("D5", 6, d5Children, 5);
        b11.addParent(d5);
        g12.addParent(d5);
        TreeNode[] d4Children = {c9, d10};
        TreeNode b4 = new TreeNode("B4", 4, d4Children, 9);
        c9.addParent(b4);
        d10.addParent(b4);
        TreeNode[] b3Children = {a6, c7, d8};
        TreeNode b3 = new TreeNode("B3", 3, b3Children, 9);
        a6.addParent(b3);
        c7.addParent(b3);
        d8.addParent(b3);
        TreeNode[] a2Children = {b4, d5};
        TreeNode a2 = new TreeNode("A2", 2, a2Children, 8);
        b4.addParent(a2);
        d5.addParent(a2);
        TreeNode[] s1Children = {a2, b3};
        TreeNode s1 = new TreeNode("S1", 0, s1Children, 11);
        a2.addParent(s1);
        b3.addParent(s1);

        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();

        //breath first traversal

        nodes.add(s1);

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
