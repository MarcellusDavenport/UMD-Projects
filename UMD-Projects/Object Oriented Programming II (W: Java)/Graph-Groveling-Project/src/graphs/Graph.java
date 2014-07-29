package graphs;

import java.util.*;

/**
 * Implements a graph. We use two maps: one map for adjacency properties 
 * (adjancencyMap) and one map (dataMap) to keep track of the data associated 
 * with a vertex. 
 * 
 * @author cmsc132
 * 
 * @param <E>
 */
public class Graph<E> {
	
	//to test
	public static void main(String[] args) {
		Graph<Double> testGraph = new Graph<Double>();
		testGraph.addVertex("B", 1002.5);
		testGraph.addVertex("A", 1001.5);
		testGraph.addVertex("D", 1004.5);
		testGraph.addVertex("C", 1003.5);
		testGraph.addVertex("ST", 1000.5);
		testGraph.addVertex("M", 2.0);
		testGraph.addDirectedEdge("A", "C", 2);
		testGraph.addDirectedEdge("B", "A", 4);
		testGraph.addDirectedEdge("B", "D", 3);
		testGraph.addDirectedEdge("C", "D", 5);
		testGraph.addDirectedEdge("D", "C", 7);
		testGraph.addDirectedEdge("ST", "A", 11);
		testGraph.addDirectedEdge("ST", "B", 6);
		
		ArrayList<String> path = new ArrayList<String>();
		//PrintCallBack<Double> test = new PrintCallBack<Double>();
		//testGraph.doBreadthFirstSearch("ST", (CallBack<Double>) test);
		//System.out.print(test.getResult());
		testGraph.doDijkstras("ST", "C", path);
		System.out.print(path.toString());
		
		
		
		//System.out.print(bob.toString());
	}
	
	/* You must use the following maps in your implementation */
	private HashMap<String, HashMap<String, Integer>> adjacencyMap;
	private HashMap<String, E> dataMap;
	Set<String> visited;
	
	public Graph() {
		adjacencyMap = new HashMap<String, HashMap<String, Integer>>();
		dataMap = new HashMap<String, E>();
		visited = new HashSet<String>();
	}
	
	public void addDirectedEdge(java.lang.String startVertexName, java.lang.String endVertexName, int cost) {
		if (!adjacencyMap.containsKey(startVertexName) && !adjacencyMap.containsKey(endVertexName)) {
			// None of the vertices are found in the graph
			throw new java.lang.IllegalArgumentException();
		} else {
			adjacencyMap.get(startVertexName).put(endVertexName, cost);
		}
	}
	
	public void addVertex(java.lang.String vertexName, E data) {
		if (adjacencyMap.containsKey(vertexName)) {
			//vertex already exists in the graph
			throw new java.lang.IllegalArgumentException();
		}
		adjacencyMap.put(vertexName, new HashMap<String, Integer>());
		dataMap.put(vertexName, data);
	}
	
	public java.lang.String toString() {
		TreeSet<String> sortedVertices = new TreeSet<String>(adjacencyMap.keySet()); 
		String ls = System.getProperty("line.separator");
		String output = "";
		output += "Vertices: " + sortedVertices.toString() + ls + "Edges:" + ls;
		for (String vertice: sortedVertices) {
			output += "Vertex (" + vertice + ")--->{";
			TreeSet<String> adjacent = new TreeSet<String>(adjacencyMap.get(vertice).keySet()); 
			Iterator<String> iter = adjacent.iterator();
			while (iter.hasNext()) {
				String next = iter.next();
				output += next + "=" + adjacencyMap.get(vertice).get(next);
				if (iter.hasNext()) {
					output += ", ";
				}
			}
			output += "}" + ls;
		}
		return output;
		
	}
	
	public java.util.Map<java.lang.String,java.lang.Integer> getAdjacentVertices(java.lang.String vertexName) {
		return adjacencyMap.get(vertexName);
	}
	
	public int getCost(java.lang.String startVertexName,
	          java.lang.String endVertexName) {
		if (!adjacencyMap.containsKey(startVertexName) && !adjacencyMap.containsKey(endVertexName)) {
			throw new java.lang.IllegalArgumentException();
		} else {
			return adjacencyMap.get(startVertexName).get(endVertexName);
		}
	}
	
	public java.util.Set<java.lang.String> getVertices() {
		return adjacencyMap.keySet();
	}
	
	public E getData(java.lang.String vertex) {
		return dataMap.get(vertex);
	}

	public void doDepthFirstSearch(java.lang.String startVertexName,
            CallBack<E> callback) {
		if (!adjacencyMap.containsKey(startVertexName)) {
			throw new java.lang.IllegalArgumentException();
		} else {
			Stack<String> stack = new Stack<String>();
			stack.push(startVertexName);
			visited.add(startVertexName);
			callback.processVertex(startVertexName, dataMap.get(startVertexName));
			while (!stack.isEmpty()) {
				String test = stack.peek();
				String child = getUnvisitedChildNode(test);
				if (child != null) {
					visited.add(child);
					callback.processVertex(child, dataMap.get(child));
					stack.push(child);
				} else {
					stack.pop();
				}
			}
			visited.clear();
		}
	}
	
	//helper method for DFS and BFS
	private String getUnvisitedChildNode(String vertex) {
		Set<String> set = new HashSet<String>(getAdjacentVertices(vertex).keySet());
		final String test = vertex;
		TreeSet<String> tree = new TreeSet<String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return adjacencyMap.get(test).get(o1).compareTo(adjacencyMap.get(test).get(o2));
			}
			
		});
	
		//sort by Cost by adding to tree
		for (String obj: set) {
			tree.add(obj);
		}
		
		Iterator<String> iter = tree.iterator();
		while (iter.hasNext()) {
			String item = iter.next();
			if (!visited.contains(item)) {
				return item;
			}
		}
		return null;
	}
	
	private String getUnvisitedChildNode2(String vertex) {
		Set<String> set = new HashSet<String>(getAdjacentVertices(vertex).keySet());
		
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			String item = iter.next();
			if (!visited.contains(item)) {
				return item;
			}
		}
		return null;
	}
	
	public void doBreadthFirstSearch(java.lang.String startVertexName,
            CallBack<E> callback) {
		Queue<String> queue = new LinkedList<String>(); 
		queue.add(startVertexName);
		callback.processVertex(startVertexName, dataMap.get(startVertexName));
		visited.add(startVertexName);
		while (!queue.isEmpty()) {
			String test = queue.remove();
			String child = null;
			while ((child = getUnvisitedChildNode2(test)) != null) {
				visited.add(child);
				callback.processVertex(child, dataMap.get(child));
				queue.add(child);
			}
		}
		visited.clear();
	}

	public int doDijkstras(java.lang.String startVertexName,
            java.lang.String endVertexName,
            java.util.ArrayList<java.lang.String> shortestPath) {
		//map representing vertices with initial values set to a large number
		
		if (startVertexName.compareTo(endVertexName) == 0) {
			shortestPath.add("None"); return 0;
		}
		
		final HashMap<String, Integer> set = new HashMap<String, Integer>();
		for (String obj: adjacencyMap.keySet()) {
			if (obj.compareTo(startVertexName) == 0) {
				set.put(obj, 0);
			} else {
				set.put(obj, 1000);
			}
		}
		
		PriorityQueue<String> queue = new PriorityQueue<String>(20, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return set.get(o1).compareTo(set.get(o2));
			}
		});
		
		queue.add(startVertexName);
		while (!queue.isEmpty()) {
			String u = queue.poll();
			for (String e: adjacencyMap.get(u).keySet()) {
				int weight = adjacencyMap.get(u).get(e);
				int distanceThroughU = set.get(u) + weight;
				if (distanceThroughU < set.get(e)) {
					queue.remove(e);
					set.put(e, distanceThroughU);
					shortestPath.add(u);
					queue.add(e);
				}
			}
		}
		return 0;
		/*int min = 0;
		
		if (shortestPath.size() == 0) {
			return -1;
		} else {
			for (int i = 0; i < shortestPath.size() - 1; i++) {
				min += getCost(shortestPath.get(i), shortestPath.get(i));
			}
			return min;
		*/
	}
	
	
	
	
	
	
	
}