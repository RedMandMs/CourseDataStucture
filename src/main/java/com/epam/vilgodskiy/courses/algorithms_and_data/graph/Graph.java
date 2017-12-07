package com.epam.vilgodskiy.courses.algorithms_and_data.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    private List<GraphNode> nodes;

    public List<GraphNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<GraphNode> nodes) {
        this.nodes = nodes;
    }
}
