package com.company;

/**
 * Created by mattmartin on 11/08/2016.
 */
public class TreeNode {
    String name;
    int depth = 0;
    int SLD;
    TreeNode[] children;
    TreeNode parent;

    public TreeNode(String name, int depth, TreeNode[] children, int SLD) {
        this.name = name;
        this.depth = depth;
        this.children = children;
        this.SLD = SLD;
    }

    public void addParent(TreeNode parent){
        this.parent = parent;
    }

    public TreeNode getParent(){
        return this.parent;
    }

    public String getName(){
        return this.name;
    }

    public TreeNode[] getChildren(){
        return this.children;
    }

    public int getHeuristic(){
        return depth + SLD;
    }
}
