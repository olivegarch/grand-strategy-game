package map;

import java.util.HashSet;
import java.util.Set;

/**
 * @author OliveGarch
 *
 * Stores all Provinces that are connected in one object
 */
public class Graph {

    private Set<Province> nodes;

    public Graph() {
        nodes = new HashSet<Province>();
    }

    public void addNode(Province node) {
        nodes.add(node);
    }
}
