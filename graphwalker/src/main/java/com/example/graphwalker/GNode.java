package com.example.graphwalker;

import java.util.List;

public interface GNode {
    String getName();
    List<GNode> getChildren();
}