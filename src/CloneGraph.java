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
		if (node == null) return node;
		
		Set<Integer> visited = new HashSet<Integer>();
		Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
		Map<UndirectedGraphNode, UndirectedGraphNode> old2new = 
								new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		q.add(node);
		while (!q.isEmpty()) {
			UndirectedGraphNode n = q.remove();
			if (visited.contains(n.label))
				continue;
			
			visited.add(n.label);
			UndirectedGraphNode new_n;   // get the new node
			if (old2new.containsKey(n))
				new_n = old2new.get(n);
			else {
				new_n = new UndirectedGraphNode(n.label);  
				old2new.put(n, new_n);
			}
			
			for (int i = 0; i < n.neighbors.size(); i++) { 
				UndirectedGraphNode nb = n.neighbors.get(i);
				q.add(nb); // add this neighbor to queue
				UndirectedGraphNode new_nb;  // get the new neighbors
				if (old2new.containsKey(nb))
					new_nb = old2new.get(nb);
				else {
					new_nb = new UndirectedGraphNode(nb.label);
					old2new.put(nb, new_nb);
				}
				new_n.neighbors.add(new_nb);
			}
		}
		return old2new.get(node);
	}
}

class UndirectedGraphNode {
	      int label;
	      ArrayList<UndirectedGraphNode> neighbors;
	      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	  };