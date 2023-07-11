package com.example;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import com.example.graphwalker.GNode;
import com.example.graphwalker.GNodeImpl;
import com.example.graphwalker.GraphWalker;

public class GraphWalkerTest
{
    GraphWalker graphwalker;

    @Test
    public void testWalkGraph() {

        GNodeImpl nodeA = new GNodeImpl("A");
        GNodeImpl nodeB = new GNodeImpl("B");
        GNodeImpl nodeC = new GNodeImpl("C");
        GNodeImpl nodeD = new GNodeImpl("D");
        GNodeImpl nodeE = new GNodeImpl("E");
        GNodeImpl nodeF = new GNodeImpl("F");
        GNodeImpl nodeG = new GNodeImpl("G");
        GNodeImpl nodeH = new GNodeImpl("H");
        GNodeImpl nodeI = new GNodeImpl("I");
        GNodeImpl nodeJ = new GNodeImpl("J");

        nodeA.getChildren().add(nodeB);
        nodeA.getChildren().add(nodeC);
        nodeA.getChildren().add(nodeD);
        nodeB.getChildren().add(nodeE);
        nodeB.getChildren().add(nodeF);
        nodeC.getChildren().add(nodeG);
        nodeC.getChildren().add(nodeH);
        nodeC.getChildren().add(nodeI);
        nodeD.getChildren().add(nodeJ);

        GraphWalker walker = new GraphWalker();
        List<GNode> result = walker.walkGraph(nodeA);

        List<GNode> expected = List.of(nodeA, nodeB, nodeE, nodeF, nodeC, nodeG, nodeH, nodeI, nodeD, nodeJ);

        assertEquals(expected, result);
    }

    @Test
    public void testWalkGraphSingleNode() {
        GNodeImpl nodeA = new GNodeImpl("A");

        GraphWalker walker = new GraphWalker();
        List<GNode> result = walker.walkGraph(nodeA);

        List<GNode> expected = List.of(nodeA);

        assertEquals(expected, result);
    }

    @Test
    public void testWalkGraphEmptyGraph() {
        GNodeImpl nodeA = new GNodeImpl("A");
        nodeA.getChildren(); // Returns an empty list

        GraphWalker walker = new GraphWalker();
        List<GNode> result = walker.walkGraph(nodeA);

        List<GNode> expected = List.of(nodeA);

        assertEquals(expected, result);
    }

    @Test
    public void testWalkGraphDisconnectedGraph() {
        GNodeImpl nodeA = new GNodeImpl("A");
        GNodeImpl nodeB = new GNodeImpl("B");
        GNodeImpl nodeC = new GNodeImpl("C");

        GraphWalker walker = new GraphWalker();
        List<GNode> result = walker.walkGraph(nodeA);

        List<GNode> expected = List.of(nodeA);

        assertEquals(expected, result);
    }
}