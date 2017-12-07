package com.epam.vilgodskiy.courses.algorithms_and_data.graph;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class GraphUtilsTest {

    private GraphUtils graphUtils = new GraphUtils();

    private Graph graphWithLoops = new Graph();
    private Graph graphWithoutLoops = new Graph();
    private GraphNode nodeA;
    private GraphNode nodeB;
    private GraphNode nodeC;
    private GraphNode nodeD;
    private GraphNode nodeE;
    private GraphNode nodeF;
    private GraphNode nodeG;
    private GraphNode nodeH;

    /*
    A: B, C
    B: C, D, E
    C: A
    D:
    E: A, B, D
    F: G
    H: G
    G: F
     */
    @Before
    public void setUpGraphWithLoop() {
        nodeA = new GraphNode("A");
        nodeB = new GraphNode("B");
        nodeC = new GraphNode("C");
        nodeD = new GraphNode("D");
        nodeE = new GraphNode("E");
        nodeF = new GraphNode("F");
        nodeH = new GraphNode("H");
        nodeG = new GraphNode("G");
        graphWithLoops = new Graph();
        List<GraphNode> nodes = new ArrayList<>();
        nodes.add(nodeA);
        nodes.add(nodeB);
        nodes.add(nodeC);
        nodes.add(nodeD);
        nodes.add(nodeE);
        nodes.add(nodeF);
        nodes.add(nodeG);
        nodes.add(nodeH);
        graphWithLoops.setNodes(nodes);
        nodeA.getEdgesToNodes().addAll(Arrays.asList(nodeB, nodeC, nodeD));
        nodeB.getEdgesToNodes().addAll(Arrays.asList(nodeC, nodeD, nodeE));
        nodeC.getEdgesToNodes().add(nodeA);
        nodeE.getEdgesToNodes().addAll(Arrays.asList(nodeA, nodeB, nodeD));
        nodeF.getEdgesToNodes().add(nodeG);
        nodeH.getEdgesToNodes().add(nodeG);
        nodeG.getEdgesToNodes().add(nodeF);
    }

    /*
    A: F
    B: F
    C: D
    D: A, F, B
    E:
    F:
     */
    @Before
    public void setUpGraphWithoutLoop() {
        GraphNode nodeA = new GraphNode("A");
        GraphNode nodeB = new GraphNode("B");
        GraphNode nodeC = new GraphNode("C");
        GraphNode nodeD = new GraphNode("D");
        GraphNode nodeE = new GraphNode("E");
        GraphNode nodeF = new GraphNode("F");
        List<GraphNode> nodes = new ArrayList<>();
        nodes.add(nodeA);
        nodes.add(nodeB);
        nodes.add(nodeC);
        nodes.add(nodeD);
        nodes.add(nodeE);
        nodes.add(nodeF);
        graphWithoutLoops.setNodes(nodes);
        nodeA.getEdgesToNodes().add(nodeF);
        nodeB.getEdgesToNodes().add(nodeF);
        nodeC.getEdgesToNodes().add(nodeD);
        nodeD.getEdgesToNodes().addAll(Arrays.asList(nodeA, nodeF, nodeB));

    }

    //
    @Test
    public void existPathBetweenNodes() {
        assertTrue(graphUtils.existPathBetweenNodes(graphWithLoops, nodeA, nodeD));
        assertTrue(graphUtils.existPathBetweenNodes(graphWithLoops, nodeA, nodeB));
        assertTrue(graphUtils.existPathBetweenNodes(graphWithLoops, nodeC, nodeD));
        assertFalse(graphUtils.existPathBetweenNodes(graphWithLoops, nodeA, nodeH));
        assertFalse(graphUtils.existPathBetweenNodes(graphWithLoops, nodeD, nodeF));
        assertFalse(graphUtils.existPathBetweenNodes(graphWithLoops, nodeE, nodeG));
        assertTrue(graphUtils.existPathBetweenNodes(graphWithLoops, nodeF, nodeH));
    }

    @Test
    public void getWayToPackage() {
        List<GraphNode> wayToPackage = graphUtils.getWayToPackage(graphWithoutLoops);
        assertEquals(graphWithoutLoops.getNodes().size(), wayToPackage.size());
        for (int i = 0; i < wayToPackage.size(); i++) {
            assertTrue(wayToPackage.subList(0, i).containsAll(wayToPackage.get(i).getEdgesToNodes()));
        }
    }

    @Test(expected = RuntimeException.class)
    public void getWayToPackageException() {
        graphUtils.getWayToPackage(graphWithLoops);
    }
}