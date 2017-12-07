package com.epam.vilgodskiy.courses.algorithms_and_data.graph;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class GraphUtils {

    //4.1 (50 мин)
    public boolean existPathBetweenNodes(Graph graph, GraphNode nodeA, GraphNode nodeB) {
        if (!graph.getNodes().contains(nodeA) || !graph.getNodes().contains(nodeB)) {
            return false;
        }
        Set<GraphNode> markedNodesA = new HashSet<>(graph.getNodes().size());
        markedNodesA.add(nodeA);
        Set<GraphNode> markedNodesB = new HashSet<>(graph.getNodes().size());
        markedNodesB.add(nodeB);
        Queue<GraphNode> queueA = new LinkedList<>();
        queueA.add(nodeA);
        Queue<GraphNode> queueB = new LinkedList<>();
        queueB.add(nodeB);
        while (!queueA.isEmpty() || !queueB.isEmpty()) {
            GraphNode nodeFromA = queueA.poll();
            if (nodeFromA != null) {
                for (GraphNode child : nodeFromA.getEdgesToNodes()) {
                    if (child.equals(nodeB)) {
                        return true;
                    }
                    if (markedNodesA.add(child)) {
                        queueA.add(child);
                    }
                }
            }
            GraphNode nodeFromB = queueB.poll();
            if (nodeFromB != null) {
                for (GraphNode child : nodeFromB.getEdgesToNodes()) {
                    if (child.equals(nodeA)) {
                        return true;
                    }
                    if (markedNodesB.add(child)) {
                        queueB.add(child);
                    }
                }
            }
        }
        return false;
    }

    //4.7 (1 час)
    public List<GraphNode> getWayToPackage(Graph graph) {
        Graph copyGraph = new Graph();
        copyGraph.getNodes().addAll(graph.getNodes());
        List<GraphNode> resultWay = new ArrayList<>(copyGraph.getNodes().size());
        while (resultWay.size() < graph.getNodes().size()) {
            int resultStartSize = resultWay.size();
            Iterator<GraphNode> nodeIterator = copyGraph.getNodes().iterator();
            while (nodeIterator.hasNext()) {
                GraphNode node = nodeIterator.next();
                if (resultWay.containsAll(node.getEdgesToNodes())) {
                    resultWay.add(node);
                    nodeIterator.remove();
                }
            }
            if(resultStartSize == resultWay.size()){
                throw new RuntimeException("В списке зависимостей существует цикл");
            }
        }
        return resultWay;
    }
}
