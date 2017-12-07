package com.epam.vilgodskiy.courses.algorithms_and_data.bst;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void getMapDepthOnNodes() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(1);
        bst.insert(3);
        bst.insert(9);
        bst.insert(8);
        bst.insert(7);
        bst.insert(6);
        bst.simpleBalance();
        Map<Integer, List<BSTNode>> mapDepthOnNodes = bst.getMapDepthOnNodes();
        for (int i = 0; i < 3; i++) {
            List<Integer> expectedList = new ArrayList<>();
            switch (i) {
                case 0:
                    expectedList.add(6);
                    break;
                case 1:
                    expectedList.add(3);
                    expectedList.add(8);
                    break;
                case 2:
                    expectedList.add(1);
                    expectedList.add(5);
                    expectedList.add(7);
                    expectedList.add(9);
                    break;
            }
            assertTrue(expectedList.equals(mapDepthOnNodes.get(i).stream().map(BSTNode::getValue).collect(Collectors.toList())));
        }
    }

    @Test
    public void getMapDepthOnNodesEmptyTree() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.simpleBalance();
        Map<Integer, List<BSTNode>> mapDepthOnNodes = bst.getMapDepthOnNodes();
        assertTrue(mapDepthOnNodes.isEmpty());
    }
}