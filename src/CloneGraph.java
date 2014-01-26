/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
import java.util.*;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) return null;
		
		Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
		HashMap<Integer, UndirectedGraphNode> label2node = new HashMap<Integer, UndirectedGraphNode>();
		q.add(node);
		while (!q.isEmpty()) {
			UndirectedGraphNode n = q.remove();
			UndirectedGraphNode new_n = null;
			if (label2node.containsKey(n.label))
				new_n = label2node.get(n.label);
			else {
				new_n = new UndirectedGraphNode(n.label);
				label2node.put(n.label, new_n);
			}
			for (UndirectedGraphNode nb : n.neighbors) {
				UndirectedGraphNode new_nb = null;
				if (label2node.containsKey(nb.label))
					new_nb = label2node.get(nb.label);
				else {
					new_nb = new UndirectedGraphNode(nb.label);
					label2node.put(nb.label, new_nb);
					q.add(nb);
				}
				new_n.neighbors.add(new_nb);
			}
		}
		return label2node.get(node.label);
	}
}