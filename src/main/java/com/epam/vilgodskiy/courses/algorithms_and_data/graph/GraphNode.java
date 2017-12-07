package com.epam.vilgodskiy.courses.algorithms_and_data.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

    public GraphNode(String name) {
        this.name = name;
        edgesToNodes = new ArrayList<>();
    }

    private String name;

    private List<GraphNode> edgesToNodes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GraphNode> getEdgesToNodes() {
        return edgesToNodes;
    }

    public void setEdgesToNodes(List<GraphNode> edgesToNodes) {
        this.edgesToNodes = edgesToNodes;
    }
}
