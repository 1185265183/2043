package cn.web.security.buildgraph;

import java.awt.geom.IllegalPathStateException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class DiGraphAlgorithm {
    
	
	/**
	 * 判断有向图是否有环
	 */
	public static boolean containSCC(DiGraph<String> graph){
		ArrayList<LinkedList<String>> componentList = stronglyConnectedComponents(graph);
		
		for(LinkedList<String> component : componentList){
			if(component.size() > 1){
				return true;
			}
		}
		return false;
	}
	
	
    public static ArrayList<LinkedList<String>> stronglyConnectedComponents(DiGraph<String> graph){
    	ArrayList<LinkedList<String>> components = new ArrayList<LinkedList<String>>();
    	
        String currVertex = null;
        
        // list of vertices visited by dfs() for graph g
        LinkedList<String> dfsList = new LinkedList<String>();
        
        // list of vertices visited by dfsVisit() for g transpose
        LinkedList<String> dfsGTList = null;
        
        // used to scan dfsList
        Iterator<String> gIter;
        
        // transpose of the graph
        DiGraph<String> gt = null;
        
        // execute depth-first tranversal of g
        dfs(dfsList,graph);

        // compute gt
        gt = transpose(graph);

        // initialize all vertices in gt to WHITE
        // (unvisited)
        gt.colorWhite();

        // call dfsVisit() for gt from vertices in dfsList
        gIter = dfsList.iterator();
        while (gIter.hasNext()) {
            currVertex = gIter.next();
            // call dfsVisit() only if vertex has not been visited
            if (gt.getColor(currVertex) == VertexColor.WHITE) {
                // create a new LinkedList to hold next strong
                // component
                dfsGTList = new LinkedList<String>();
                // do dfsVisit() in gt for starting vertex currVertex
                dfsVisit(gt, currVertex, dfsGTList, false);
                // add strong component to the ArrayList
                components.add(dfsGTList);
            }
        }
		return components;
    }
    
    
    
    
    
    public static void dfs(LinkedList<String> dfsList,DiGraph<String> graph){
        Iterator<String> graphIter;
        String vertex = null;

        // clear dfsList
        dfsList.clear();

        // initialize all vertices to WHITE
        graph.colorWhite();

        // call dfsVisit() for each WHITE vertex
        graphIter = graph.vertexSet().iterator();
        while (graphIter.hasNext()) {
            vertex = graphIter.next();
            if (graph.getColor(vertex) == VertexColor.WHITE) {
                dfsVisit(graph, vertex, dfsList, false);
            }
        }
    }
    
    /**
     * Depth-first visit takes a starting vertex and creates a list
     * that contains the visited vertices in reverse order of finishing
     * time. When the boolean value checkForCycle is true, the method
     * throws an IllegalPathStateException if it detects a
     * cycle.
     * @param g  directed graph
     * @param sVertex  starting vertex.
     * @param dfsList  List of visited nodes created by the algorithm.
     * @param checkForCycle  test whether the presence of a cycle results
     *                 in an exception.
     * @throws IllegalPathStateException if it detects a cycle when checkForCycle
     *                  is true.
     */
    public static void dfsVisit(DiGraph<String> graph, String sVertex, LinkedList<String> dfsList, boolean checkForCycle) {
        String neighborVertex;
        Set<String> edgeSet;
        // iterator to scan the adjacency set of a vertex
        Iterator<String> edgeIter;
        VertexColor color;

        if (!graph.containsVertex(sVertex)) {
            throw new IllegalArgumentException(
                    "dfsVisit(): vertex not in the graph");
        }

        // color vertex GRAY to note its discovery
        graph.setColor(sVertex, VertexColor.GRAY);

        edgeSet = graph.getNeighbors(sVertex);

        // sequence through the adjacency set and look for vertices
        // that are not yet discovered (colored WHITE).
        // recursively call dfsVisit() for each such vertex. if a
        // vertex in the adjacency list is GRAY, the
        // vertex was discovered during a previous call and there
        // is a cycle that begins and ends at the vertex; if
        // checkForCycle is true, throw an exception
        edgeIter = edgeSet.iterator();
        while (edgeIter.hasNext()) {
            neighborVertex = edgeIter.next();
            color = graph.getColor(neighborVertex);
            if (color == VertexColor.WHITE) {
                dfsVisit(graph, neighborVertex, dfsList, checkForCycle);
            } else if (color == VertexColor.GRAY && checkForCycle) {
                //System.out.println(sVertex);
                throw new IllegalPathStateException(
                        "dfsVisit(): cycle involving vertices "
                        + sVertex + " and " + neighborVertex);
            }
        }

        // finished with vertex sVertex. make it BLACK
        // and add it to the front of dfsList
        graph.setColor(sVertex, VertexColor.BLACK);
        dfsList.addFirst(sVertex);
    }
    
    /**
     *
     * @param g
     * @return
     */
    public static DiGraph<String> transpose(DiGraph<String> g) {
        String currVertex = null, neighborVertex = null;
        Set<String> edgeSet, vertexSet;
        Iterator<String> edgeIter, graphIter;
        DiGraph<String> gt = new DiGraph<String>();

        // insert each vertex of g into gt
        vertexSet = g.vertexSet();
        graphIter = vertexSet.iterator();
        while (graphIter.hasNext()) {
            currVertex = graphIter.next();
            gt.addVertex(currVertex);
        }

        // insert reveresed edges of g into gt
        graphIter = vertexSet.iterator();
        while (graphIter.hasNext()) {
            currVertex = graphIter.next();
            edgeSet = g.getNeighbors(currVertex);
            edgeIter = edgeSet.iterator();
            while (edgeIter.hasNext()) {
                neighborVertex = edgeIter.next();
                gt.addEdge(neighborVertex, currVertex,
                        g.getWeight(currVertex, neighborVertex));
            }
        }
        return gt;
    }
}
