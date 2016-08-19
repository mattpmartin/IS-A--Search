package com.company;

/**
 * Created by mattmartin on 19/08/2016.
 */
public class GraphLinkage {
    GraphNode linked;
    int cost;

    public GraphLinkage(GraphNode linked, int cost){
        this.linked = linked;
        this.cost = cost;
    }

    public int getCost(){
        return cost;
    }

    public GraphNode getNode(){
        return linked;
    }
}
