package com.example.graphwalker;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * GraphWalker
 */
public class GraphWalker {

    public List<GNode> walkGraph(GNode node) {
        List<GNode> result = new ArrayList<>();
        Set<GNode> visited = new HashSet<>();
        dfs(node, visited, result);
        return result;
    }

    private void dfs(GNode node, Set<GNode> visited, List<GNode> result) {
        if (visited.contains(node)) {
            return;
        }

        visited.add(node);
        result.add(node);

        for (GNode child : node.getChildren()) {
            dfs(child, visited, result);
        }
    }

    public static void main(String[] args) {
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

        for (GNode node : result) {
            System.out.print(node.getName() + " ");
        }
    }
}