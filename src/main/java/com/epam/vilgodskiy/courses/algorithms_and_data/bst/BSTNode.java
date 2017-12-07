package com.epam.vilgodskiy.courses.algorithms_and_data.bst;

public class BSTNode {
    BSTNode left, right;

    Integer value;

    int height = 0;
    int size = 1;

    public BSTNode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
