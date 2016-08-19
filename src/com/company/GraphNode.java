package com.company;

import java.util.ArrayList;

/**
 * Created by mattmartin on 19/08/2016.
 */
public class GraphNode {
    String name;
    GraphLinkage[] links = new GraphLinkage[0];
    int SLD;

    public GraphNode(String name, int SLD){
        this.name = name;
        this.SLD = SLD;
    }

    public void setLinkage(GraphLinkage[] links){
        this.links = links;
    }

    public TreeNode getTree(){
        ArrayList<GraphNode> graphNodes = new ArrayList<GraphNode>();

        graphNodes.add(this);

        ArrayList<TreeNode> nodes = createTree(this, graphNodes, 0);

        TreeNode newNode = new TreeNode(name, 0, nodes.toArray(new TreeNode[0]), SLD);

        for(int x = 0; x < newNode.getChildren().length; x++){
            newNode.getChildren()[x].addParent(newNode);
        }

        return newNode;
    }

    private ArrayList<TreeNode> createTree(GraphNode node, ArrayList<GraphNode> graphNodes, int depth){
        //create copy of list so it doesn't effect other things
        ArrayList<GraphNode> subList = new ArrayList<GraphNode>(graphNodes);
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();

        subList.add(node);

        if(node.getName().contains("G")) {

            TreeNode[] emptyArray = {};
            result.add(new TreeNode(node.getName(), depth, emptyArray, 0));

        }else if(node.getLinks().length == 0){

            TreeNode[] emptyArray = {};
            result.add(new TreeNode(node.getName(), depth, emptyArray, node.getSLD()));

        }
        else{
            for(int i = 0; i < node.getLinks().length; i++){
                GraphLinkage link = node.getLinks()[i];
                GraphNode linked = link.getNode();
                int thisDepth = depth + link.getCost();
                if(!subList.contains(linked)) {
                    TreeNode newNode = new TreeNode(linked.getName() + thisDepth, thisDepth, createTree(linked, subList, thisDepth).toArray(new TreeNode[0]), linked.getSLD());

                    for(int x = 0; x < newNode.getChildren().length; x++){
                        newNode.getChildren()[x].addParent(newNode);
                    }

                    result.add(newNode);
                }
            }
        }

        return result;
    }

    public String getName(){
        return this.name;
    }

    public GraphLinkage[] getLinks(){
        return links;
    }

    public int getSLD(){ return SLD; }

    // define a comparator

    public boolean equals(GraphNode other){
        return this.name == other.getName();
    }
}