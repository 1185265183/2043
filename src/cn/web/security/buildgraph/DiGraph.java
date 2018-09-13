package cn.web.security.buildgraph;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * An <tt>Edge</tt> object describes an edge from a source vertex by defining
 * its destination and weight.
 * <p>
 */
class Edge implements Serializable{

	/**
	 * Index of the destination vertex in the <tt>ArrayList</tt> of vertex
	 * properties.
	 */
	public int dest;
	/**
	 * Weight of the edge.
	 */
	public int weight;

	/**
	 * Creates an edge with the specified destination index and weight.
	 * 
	 * @param dest
	 *            index of destination vertex in <tt>ArrayList</tt> of vertex
	 *            properties.
	 * @param weight
	 *            weight of the vertex. Set to 1 in a non-weighted graph.
	 */
	public Edge(int dest, int weight) {
		this.dest = dest;
		this.weight = weight;
	}



	/**
	 * Compares this <tt>Edge</tt> object with another Object. Return true if
	 * obj is an <tt>Edge</tt> with the same destination index.
	 * 
	 * @param obj
	 *            the object to compare with.
	 * @return true if the objects are the same and false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Edge)) {
			return false;
		}
		return ((Edge) obj).dest == this.dest;
	}
}

/**
 * A <tt>VertexInfo</tt> object maintains vertex properties, including its
 * set of Edges. The <tt>Graph</tt> class implementation includes an
 * ArrayList of <tt>VertexInfo</tt> object that have a one-to-one
 * correspondence with vertices in the <tt>TreeMap</tt>.
 * <p>
 */
class VertexInfo<T> implements Serializable{

	/**
	 * Vertex reference associated with a vertex entry in the map.
	 */
	public T vertex;

	/**
	 * List of <tt>Edge</tt> objects (adjacent vertices) for the current
	 * vertex.
	 */
	public LinkedList<Edge> edgeList;

	/**
	 * Maintains the in-degree of the vertex.
	 */
	public int inDegree;

	/**
	 * Indicates whether this object currently represents a vertex.
	 */
	public boolean occupied;

	/**
	 * Indicates vertex color for use in algorithms that traverse the
	 * vertices of a Graph.
	 */
	public VertexColor color;

	/**
	 * Available to algorithms for storing relevant data values.
	 */
	public int dataValue;

	/**
	 * Available to Graph algorithms; holds parent which is a vertex that
	 * has an edge terminating in the current vertex.
	 */
	public T parent;

	/**
	 * �?1�?7�?1�?7�?0�?0�?0�?2�?1�?7�?1�?7�?1�?7�?1�?7�?0�?3�?1�?7�?1�?7�?1�?7�?1�?7�?1�?7�?1�?7�?0�?4
	 */
	// public Point point;
	
	/**��¼�ýڵ�������ϼ��ڵ�?*/
     public Set<T> parents;
     
	/**
	 * �?1�?7�?1�?7�?0�?0�?1�?7�?1�?7�?0�?2
	 */
	// public Color paintColor;

	/**
	 * vertex granularity
	 */
	// public VertexGranularity granularity;

	/**
	 * Creates an object with specified vertex and initial values for the
	 * edgeList, inDegree, and occupied fields.
	 * 
	 * @param v
	 *            vertex associated with this object.
	 */
	public VertexInfo(T v) {
		vertex = v;
		edgeList = new LinkedList<Edge>();
		inDegree = 0;
		occupied = true;
		// point = new Point();
	    parents = new HashSet<T>();

		// ��ʼ��Ĭ��Ϊfeatrue��
		// granularity = VertexGranularity.FEATURE;

		// paintColor = Color.GREEN;
	}

	// public VertexInfo(T v,VertexGranularity gran)
	// {
	// vertex = v;
	// edgeList = new LinkedList<Edge>();
	// inDegree = 0;
	// occupied = true;
	// point = new Point();
	// parents = new HashSet<T>();
	//
	// //��ʼ��Ĭ��Ϊfeatrue��
	// granularity = gran;
	//
	// paintColor = Color.GREEN;
	// }

}


/**
 * An instance of the <tt>DiGraph</tt> class is a directed weight graph that
 * implements the <tt>Graph</tt> interface. The class defines methods which
 * provide graph handling operations for vertices and edges with their weights.
 * For applications, the class allows a user to input a graph using the method
 * <tt>readGraph</tt> and display the structure of a graph using the method
 * <tt>toString</tt>
 * <p>
 * Traversal algorithms are the basis for most graph applications. The class
 * provides the method <tt>getNeighbors</tt> that identifies adjacent vertices
 * which are used in a recursive scan of the graph. Other methods access and
 * update vertex colors, parent references, and data that is associated with
 * vertices as they are identified and visited during a scan.
 * <p>
 */
public class DiGraph<T> implements Graph<T> ,Serializable{
    // store vertex in a map with its name as the key and the index
    // of the corresponding VertexInfo object in the vInfo
    // ArrayList as the value
    private HashMap<T, Integer> vtxMap;
    private ArrayList<VertexInfo<T>> vInfo;
    
    /** availability stack*/
    private ALStack<Integer> availStack;
    
    /** number of edges in the Graph*/
    private int numEdges;
    
    /**
     * Creates an empty graph no vertices or edges.
     */
    public DiGraph() {
        vtxMap = new HashMap<T, Integer>();
        availStack = new ALStack<Integer>();
        vInfo = new ArrayList<VertexInfo<T>>();
        numEdges = 0;
    }
    
    /**
     * takes vertex v in the map and returns the index of the
     * corresponding vInfo element or -1 if v is not a vertex
     * 
     * @param v
     * @return
     */
    private int getVInfoIndex(Object v) {
        // get the Integer value field of the vtxMap entry
        Integer indexObj = vtxMap.get(v);

        // if value is null, there is not entry in the map; return
        // -1; otherwise, convert object to an int
        if (indexObj == null) {
            return -1;
        } else {
            return indexObj;
        }
    }
    
    /**
     *  search a LinkedList of Edge objects for an edge
     *  having index dest in vInfo
     *  
     * @param edgeList
     * @param dest
     * @return
     */ 
    private Edge findEdge(LinkedList<Edge> edgeList, int dest) {
        Iterator<Edge> iter = edgeList.iterator();

        while (iter.hasNext()) {
            Edge e = iter.next();
            if (e.dest == dest) {
                return e;
            }
        }
        return null;
    }
    
    // call when deleting a vertex v. remove all
    // edges that terminate at v, and update the
    // in-degree of each neighbor of v
    private void removeFixup(int index,Object v) {
        // iterator used to scan Edge objects in adjacency lists
        Iterator<Edge> iter = null;
        Edge e = null;
        
        VertexInfo<T> vtxInfo = vInfo.get(index), edgeVtxInfo;

        vtxInfo.occupied = false;
        availStack.push(index);

        // remove all the edges that terminate at the vertex being
        // removed. use a loop to check all of the VertexInfo
        // elements in vInfo for which occupied is true; these
        // correspond to actual vertices in the map
        for (int i = 0; i < vInfo.size(); i++) {
            // get the VertexInfo object for index i
            edgeVtxInfo = vInfo.get(i);

            // check if vertex is valid
            if (edgeVtxInfo.occupied) {
                // obtain an iterator to scan the adjacency list
                iter = edgeVtxInfo.edgeList.iterator();

                while (iter.hasNext()) {
                    // get the Edge object and check if the dest field
                    // has value index which identifies vertex v; if so
                    // remove it and decrement numEdges
                    e = iter.next();
                    if (e.dest == index) {
                        iter.remove();
                        numEdges--;
                        break;
                    }
                }
            }
            
            edgeVtxInfo.parents.remove(v);//����vΪ���ڵ���ɾ��֮
        }

        // reduce numEdges by number of elements in adjacency list
        numEdges -= vtxInfo.edgeList.size();

        // scan the adjacency list for vertex v and decrement the in-degree
        // for each adjacent vertex
        iter = vtxInfo.edgeList.iterator();
        while (iter.hasNext()) {
            e = iter.next();
            edgeVtxInfo = vInfo.get(e.dest);
            iter.remove();
            edgeVtxInfo.inDegree--;
        }
    }
    
    /**
     * Sets the color of each vertex to VertexColor.WHITE. for use by graph algorithms.
     */
    public void colorWhite() {
        VertexInfo<T> vtxInfo;

        for (int i = 0; i < vInfo.size(); i++) {
            vtxInfo = vInfo.get(i);

            if (vtxInfo.occupied) {
                vtxInfo.color = VertexColor.WHITE;
            }
        }
    }
    
    
    /**
     * Returns the color of vertex v as a <tt>VertexColor</tt> enum value WHITE,
     * GRAY, or BLACK.
     * @param v vertex in the graph.
     * @return the color of the vertex
     * @throws IllegalArgumentException if v is not a vertex in this graph.
     */
    public VertexColor getColor(T v) {
        // find the vInfo index for v
        int pos = getVInfoIndex(v);

        if (pos != -1) {
            return vInfo.get(pos).color;
        } else // throw an exception
        {
            throw new IllegalArgumentException(
                    "DiGraph getColor(): vertex not in graph");
        }
    }
    
    /**
     * Returns the integer data value associated with vertex v.
     * @param v vertex in the graph.
     * @return integer data property of the vertex.
     * @throws IllegalArgumentException if v is not a vertex in this graph.
     */
    public int getData(T v) {
        // find the vInfo index for v
        int pos = getVInfoIndex(v);

        if (pos != -1) {
            return vInfo.get(pos).dataValue;
        } else // throw an exception
        {
            throw new IllegalArgumentException(
                    "DiGraph getData(): vertex not in graph");
        }
    }
    
    /**
     * Returns the parent of the vertex v.
     * @param v vertex in the graph.
     * @return parent of the vertex.
     * @throws IllegalArgumentException if v is not a vertex in this graph.
     */
    public T getParent(T v) {
        // find the vInfo index for v
        int pos = getVInfoIndex(v);

        if (pos != -1) {
            return vInfo.get(pos).parent;
        } else // throw an exception
        {
            throw new IllegalArgumentException(
                    "DiGraph getParent(): vertex not in graph");
        }
    }
    
    /**
     * ��ȡ�ڵ������ǰ��ڵ�
     * 
     * @param v
     * @return
     */
    public Set<T> getParents(T v) {
        int pos = getVInfoIndex(v);

        if (pos != -1) {
            return new HashSet<T>(vInfo.get(pos).parents);
        } else {
            throw new IllegalArgumentException(
                    "DiGraph getParents():vertex not in graph");
        }
    }
    
    /**
     * Returns the in-degree of vertex v; that is the number of edges
     * that terminate at v. .
     * @param v vertex in the graph.
     * @return in-degree of vertex v.
     * @throws IllegalArgumentException if v is not a vertex in this graph.
     */
    public int inDegree(T v) {
        // find the VertexInfo object for index v
        int vInfoIndex = getVInfoIndex(v);

        // check for an error and throw exception if vertices not in graph
        if (vInfoIndex == -1) {
            throw new IllegalArgumentException(
                    "DiGraph inDegree(): vertex not in graph");
        }

        // in-degree is stored in vInfo
        return vInfo.get(vInfoIndex).inDegree;
    }
    
    /**
     * Sets the data value of each vertex to INFINITY. for use by graph algorithms.
     */
    public void initData() {
        VertexInfo<T> vtxInfo;

        for (int i = 0; i < vInfo.size(); i++) {
            vtxInfo = vInfo.get(i);

            if (vtxInfo.occupied) {
                vtxInfo.dataValue = Integer.MAX_VALUE;
            }
        }
    }
    
    /**
     * Returns the out-degree of vertex v; that is the number of edges
     * that initiate at v. .
     * @param v vertex in the graph.
     * @return out-degree of vertex v.
     * @throws IllegalArgumentException if v is not a vertex in this graph.
     */
    public int outDegree(T v) {
        // find the VertexInfo object for index v
        int vInfoIndex = getVInfoIndex(v);

        // check for an error and throw exception if vertices not in graph
        if (vInfoIndex == -1) {
            throw new IllegalArgumentException(
                    "DiGraph outDegree(): vertex not in graph");
        }

        // out-degree is the number of edges
        return vInfo.get(vInfoIndex).edgeList.size();
    }
    
    /**
     * Builds a graph whose vertices are strings by reading the
     * vertices and edges from the textfile <tt>filename</tt>. The format
     * of the file is <code>
     *     nVertices
     *     vertex_1 vertex_2 ...vertex_n
     *     nEdges
     *     vertex_i vertex_j weight
     *     . . .  </code>         ...
     * @param filename name of the text file with vertex and edge specifications.
     * @return <tt>DiGraph</tt> object with generic type String.
     */
    public static DiGraph<String> readGraph(String filename)
            throws FileNotFoundException {
        // nVertices is number of vertices to read
        int i, nVertices, nEdges;
        // use for input of vertices (v1) and edges ( {v1, v2} )
        String v1, v2;
        // edge weight
        int weight;
        DiGraph<String> g = new DiGraph<String>();

        Scanner graphIn =
                new Scanner(new FileReader(filename));

        // input the number of vertices
        nVertices = graphIn.nextInt();
//		System.out.println("the number of the nodes in the graph is :"+nVertices);

        // input the vertices and add each into the graph
        for (i = 0; i < nVertices; i++) {
            v1 = graphIn.next();
            g.addVertex(v1);
//			System.out.println(i+1+": the node "+v1+" is successfully added in the graph.");
        }

        // input the number of edges
        nEdges = graphIn.nextInt();

        // input the vertices and weight for each edge, and
        // add it into the graph
        for (i = 0; i < nEdges; i++) {
            v1 = graphIn.next();
            v2 = graphIn.next();
            weight = graphIn.nextInt();
//			System.out.println(v1+"  "+v2+" "+weight);
            g.addEdge(v1, v2, weight);
        }

        return g;
    }
    
    /**
     * Sets the color of vertex v to be the <tt>VertexColor</tt> enum value WHITE,
     * GRAY, or BLACK.
     * @param v vertex in the graph.
     * @param c  <tt>VertexColor</tt> enum color.
     * @return the previous color of the vertex
     * @throws IllegalArgumentException if v is not a vertex in this graph.
     */
    public VertexColor setColor(T v, VertexColor c) {
        // find the vInfo index for v
        int pos = getVInfoIndex(v);
        VertexColor oldColor = null;
        VertexInfo<T> vtxInfo;

        if (pos != -1) {
            vtxInfo = vInfo.get(pos);
            oldColor = vtxInfo.color;
            vtxInfo.color = c;
        } else // throw an exception
        {
            throw new IllegalArgumentException(
                    "DiGraph setColor(): vertex not in graph");
        }

        return oldColor;
    }
    
    
    /**
     * Assigns value as the data property associated with vertex v.
     * @param v vertex in the graph.
     * @return previous data for the vertex.
     * @throws IllegalArgumentException if v is not a vertex in this graph.
     */
    public int setData(T v, int value) {
        // find the vInfo index for v
        int pos = getVInfoIndex(v), oldData = -1;
        VertexInfo<T> vtxInfo;

        if (pos != -1) {
            vtxInfo = vInfo.get(pos);
            oldData = vtxInfo.dataValue;
            vtxInfo.dataValue = value;
        } else // throw an exception
        {
            throw new IllegalArgumentException(
                    "DiGraph setData(): vertex not in graph");
        }

        return oldData;
    }
    
    /**
     * Assign p to be the parent of vertex v. The "parent" reference
     * comes about during a scan of the graph.
     * @param v vertex in the graph.
     * @param p vertex in the graph.
     * @return previous parent of the vertex.
     * @throws IllegalArgumentException if v or p is not a vertex in this graph.
     */
    public T setParent(T v, T p) {
        // find the vInfo index for v
        int pos1 = getVInfoIndex(v), pos2 = getVInfoIndex(p);
        VertexInfo<T> vtxInfo;
        T oldParent = null;

        if (pos1 != -1 && pos2 != -1) {
            vtxInfo = vInfo.get(pos1);
            oldParent = vtxInfo.parent;
            vtxInfo.parent = p;
        } else // throw an exception
        {
            throw new IllegalArgumentException(
                    "DiGraph setParent(): vertex not in graph");
        }

        return oldParent;
    }
    
	@Override
	public boolean addEdge(T v1, T v2, int w) {
		// find the indices for the VertexInfo objects
		int pos1 = getVInfoIndex(v1),
		    pos2 = getVInfoIndex(v2);
		
        // check for an error and throw exception if vertices not in graph
        if (pos1 == -1 || pos2 == -1) {
            throw new IllegalArgumentException(
                    "DiGraph addEdge(): vertex not in graph: " + v1+" --> " + v2);
        }
        
        // throw exception if a self-edge
        if (pos1 == pos2) {
            throw new IllegalArgumentException(
                    "DiGraph addEdge(): self-edges not allowed");
        }
        
        // get VertexInfo objects for vertices v1 and v2
        VertexInfo<T> vtxInfo1 = vInfo.get(pos1),
                vtxInfo2 = vInfo.get(pos2);
		
        Edge e = new Edge(pos2, w);
        
        boolean returnValue = true;
        
        // try to add an Edge reference v1->v2.
        // if it already exists, just return
        if (!vtxInfo1.edgeList.contains(e)) {
            vtxInfo1.edgeList.add(e);
            
            // increment inDegree for vertex v2 and number of edges
            vtxInfo2.inDegree++;
            numEdges++;

            //wei_huihui
            vtxInfo2.parents.add(v1);
        } else {
            returnValue = false;
        }

        return returnValue;
	}

	@Override
	public boolean addVertex(T v) {
        int index;
        
        if (vtxMap.containsKey(v)) {
            return false;
        }
        
        // see if there is an entry in vInfo freed by an earlier
        // call to removeVertex()
        if (!availStack.isEmpty()) {
            // yes. get its index
            index = availStack.pop();
            // update the vInfo element in the ArrayList
            VertexInfo<T> vtxInfo = vInfo.get(index);
            vtxInfo.vertex = v;
            vtxInfo.edgeList.clear();
            vtxInfo.occupied = true;
            vtxInfo.inDegree = 0;
            
            //////////////wei_huihui
            vtxInfo.parents.clear();
            
        } else {
            // no. we'll have to increase the size of vInfo
            index = vInfo.size();
            vInfo.add(new VertexInfo<T>(v));
        }

        vtxMap.put(v, index);

        return true;
	}

	/**
	 * Removes all of the vertices and edges from the graph.
	 */
	@Override
	public void clear() {
		vtxMap.clear();
		availStack.clear();
		vInfo.clear();

		// set the number of vertices and edges to 0
		numEdges = 0;
	}

	

	@Override
	public boolean containsEdge(T v1, T v2) {
        // find the indices for the VertexInfo objects
        int vInfoIndex1 = getVInfoIndex(v1),
                vInfoIndex2 = getVInfoIndex(v2);
        
        // check for an error and throw exception
        if (vInfoIndex1 == -1||vInfoIndex2 == -1) {
            //这里如果其中�?个节点是不存在的，我们就已返回true，来使这种情况变成该边已经存在，已达到忽略该情况的效�?
        	return true;
        }
       
        
        VertexInfo<T> vtxInfo = vInfo.get(vInfoIndex1);

        Iterator<Edge> iter = vtxInfo.edgeList.iterator();
        Edge e;

        while (iter.hasNext()) {
            e = iter.next();
            if (e.dest == vInfoIndex2) {
                return true;
            }
        }
        return false;
	}

	@Override
	public boolean containsVertex(Object v) {
        return vtxMap.containsKey(v);
	}

	@Override
	public Set<T> getNeighbors(T v) {
        // find the VertexInfo object for index v
        int index = getVInfoIndex(v);

        // check for an error and throw exception if vertices not in graph
        if (index == -1) {
            throw new IllegalArgumentException(
                    "DiGraph getNeighbors(): vertex not in graph");
        }

        // create HashSet object to hold vertices, obtain the VertexInfo
        // object, and an initialize an iterator to scan the adjacency
        // list of the VertexInfo object
        HashSet<T> edgeSet = new HashSet<T>();
        VertexInfo<T> vtxInfo = vInfo.get(index);
        Iterator<Edge> iter = vtxInfo.edgeList.iterator();
        Edge e = null;

        while (iter.hasNext()) {
            e = iter.next();
            edgeSet.add(vInfo.get(e.dest).vertex);
        }

        return edgeSet;
	}

	@Override
	public int getWeight(T v1, T v2) {
        // find the indices for the VertexInfo objects
        int vInfoIndex1 = getVInfoIndex(v1),
                vInfoIndex2 = getVInfoIndex(v2);

        // check for an error and throw exception
        if (vInfoIndex1 == -1 || vInfoIndex2 == -1) {
            throw new IllegalArgumentException(
                    "DiGraph getWeight(): vertex not in graph");
        }

        // find the edge corresponding to the destination index
        Edge e = findEdge(vInfo.get(vInfoIndex1).edgeList,vInfoIndex2);
        if (e == null) {
            return -1;
        } else {
            return e.weight;
        }
	}

	@Override
	public boolean isEmpty() {
        return vtxMap.size() == 0;
	}

	@Override
	public int numberOfEdges() {
        return numEdges;
	}

	@Override
	public int numberOfVertices() {
        return vtxMap.size();
	}

	@Override
	public boolean removeEdge(T v1, T v2) {
	       // find the indices for the VertexInfo objects
        int vInfoIndex1 = getVInfoIndex(v1),
                vInfoIndex2 = getVInfoIndex(v2);

        // check for an error and throw exception if vertices not in graph
        if (vInfoIndex1 == -1 || vInfoIndex2 == -1) {
            throw new IllegalArgumentException(
                    "DiGraph removeEdge(): vertex not in graph");
        }

        Iterator<Edge> iter =
                vInfo.get(vInfoIndex1).edgeList.iterator();
        Edge e;
        boolean removedTheEdge = false;
        while (iter.hasNext()) {
            e = iter.next();
            if (e.dest == vInfoIndex2) {
                iter.remove();        
                removedTheEdge = true;
                break;
            }
        }

        if (!removedTheEdge) {
            return false;
        } else {
            vInfo.get(vInfoIndex2).inDegree--;
            numEdges--;
        }

        return true;
	}

	@Override
	public boolean removeVertex(Object v) {
	       // find the index for the VertexInfo object in vInfo
        int index = getVInfoIndex(v);

        if (index == -1) {
            return false;
        }

        vtxMap.remove(v);

        // fixup vInfo corresponding to the removal of vertex v
        removeFixup(index,v);

        return true;
	}

	@Override
	public int setWeight(T v1, T v2, int w) {
        // find the indices for the VertexInfo objects
        int vInfoIndex1 = getVInfoIndex(v1),
                vInfoIndex2 = getVInfoIndex(v2);

        // check for an error and throw exception
        if (vInfoIndex1 == -1 || vInfoIndex2 == -1) {
            throw new IllegalArgumentException(
                    "DiGraph setWeight(): vertex not in graph");
        }

        // find the edge corresponding to the destination index
        Edge e = findEdge(vInfo.get(vInfoIndex1).edgeList, vInfoIndex2);

        int returnVal = -1;

        if (e != null) {
            returnVal = e.weight;
            e.weight = w;
        }

        return returnVal;
	}

	
    private transient Set<T> graphVertexSet = null;
    
    // implements graph iterators
    private class IteratorImpl implements Iterator<T> {

        Iterator<T> iter;
        T lastValue = null;

        public IteratorImpl() {
            // iter traverses the map vertices
            iter = vtxMap.keySet().iterator();
        }

        public boolean hasNext() {
            return iter.hasNext();
        }

        public T next() {
            lastValue = iter.next();
            return lastValue;
        }

        public void remove() {
            if (lastValue == null) {
                throw new IllegalStateException(
                        "Graph vertex set iterator call to next() "
                        + "required before calling remove()");
            }

            // find the index of lastValue in vInfo
            int index = getVInfoIndex(lastValue);

            // remove the current vertex from the map
            iter.remove();

            // remove all edges that terminate at lastValue, and
            // update the in-degree of each neighbor of lastValue
            removeFixup(index,lastValue);
        }
    }

    
	@Override
	public Set<T> vertexSet() {
		
		graphVertexSet = null;
		
        if (graphVertexSet == null) {
        	
            graphVertexSet = new Set<T>() {

                public int size() {
                    return vtxMap.size();
                }

                public boolean isEmpty() {
                    return vtxMap.isEmpty();
                }

                public boolean contains(Object item) {
                    return vtxMap.containsKey(item);
                }

                public Iterator<T> iterator() {
                    return new IteratorImpl();
                }

                public boolean add(T item) {
                    throw new UnsupportedOperationException();
                }

                public boolean remove(Object item) {
                    boolean retValue = false;

                    if (vtxMap.containsKey(item)) {
                        removeVertex(item);
                        retValue = true;
                    }

                    return retValue;
                }

                public void clear() {
                    DiGraph.this.clear();
                }

                public Object[] toArray() {
                    Object[] result = new Object[size()];
                    int i = 0;
                    Iterator<T> iter = iterator();

                    while (iter.hasNext()) {
                        result[i] = iter.next();
                        i++;
                    }

                    return result;
                }

				@Override
				public boolean addAll(Collection<? extends T> arg0) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean containsAll(Collection<?> arg0) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean removeAll(Collection<?> arg0) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean retainAll(Collection<?> arg0) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public <T> T[] toArray(T[] arg0) {
					// TODO Auto-generated method stub
					return null;
				}

            };
        }

        return graphVertexSet;
	}


    /**
     * Returns a string representation of this graph. The description of each
     * vertex includes the name of the vertex, its in-degree and out-degree,
     * and a list of edges and weights that correspond to the adjacent vertices.
     * @return string representation of the graph.
     */
	@Override
	public String toString() {
        Object[] mapEntry = vtxMap.entrySet().toArray();
        StringBuffer buffer = new StringBuffer();
        //String returnStr = "";
        Map.Entry<T, Integer> entry = null;
        
        VertexInfo<T> vtxInfo = null;
        Iterator<Edge> iter = null;
        Edge e = null;

        Arrays.sort(mapEntry, new SortEntry());

        for (int i = 0; i < mapEntry.length; i++) {
            entry = (Map.Entry<T, Integer>) mapEntry[i];
            vtxInfo = vInfo.get(entry.getValue());
            buffer.append(entry.getKey()).append(":  ");

            buffer.append("in-degree ").append(vtxInfo.inDegree)
                  .append("  out-degree ").append(vtxInfo.edgeList.size()).append("\n");

            buffer.append("    Edges: ");

            iter = vtxInfo.edgeList.iterator();

            while (iter.hasNext()) {
                e = iter.next();
                buffer.append(vInfo.get(e.dest).vertex).append("(").append(e.weight).append(")  ");

            }
            buffer.append("\r\n");

        }

        return buffer.toString();
	}
	
	public void toPajek(String fileName) {
		// TODO Auto-generated method stub
		Object[] mapEntry  = vtxMap.entrySet().toArray();
		Map.Entry<T, Integer> entry = null;
		
        VertexInfo<T> vtxInfo = null;
        Iterator<Edge> iter = null;
        Edge e = null;
        Arrays.sort(mapEntry, new SortEntry());
        
        ArrayList<T> vertexArray = new ArrayList<T>();
        for(int i = 0; i < mapEntry.length; i++){
        	entry = (Map.Entry<T, Integer>) mapEntry[i];
        	vertexArray.add(entry.getKey());
        }
        
        FileWriter fw = null;
        try {
			fw = new FileWriter("./output/Pajek_"+fileName+".net");
			
			BufferedWriter bfw = new BufferedWriter(fw);
			
            bfw.write("*Vertices  " + mapEntry.length);
            bfw.newLine();
            
            for(int i = 0 ; i < mapEntry.length; i++){
            	entry = (Map.Entry<T, Integer>) mapEntry[i];
                bfw.write((vertexArray.indexOf(entry.getKey())+1)+" " + entry.getKey());
                bfw.newLine();
            }
            
            bfw.write("*Arcs ");
            bfw.newLine();
            
            for(int i = 0 ; i < mapEntry.length; i++){
            	entry = (Map.Entry<T, Integer>) mapEntry[i];
                vtxInfo = vInfo.get(entry.getValue());
                iter = vtxInfo.edgeList.iterator();
                
                while(iter.hasNext()){
                    e = iter.next();
                    bfw.write(vertexArray.indexOf(entry.getKey())+1 + "  "+(vertexArray.indexOf(vInfo.get(e.dest).vertex)+1)+"  "+e.weight);
                    bfw.newLine();
                }
            }
            bfw.close();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public  Object deepClone() {

		DiGraph<T> copy = null;
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ObjectOutputStream oo = new ObjectOutputStream(out);
			oo.writeObject(this);
			oo.close();

			ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
			ObjectInputStream oi = new ObjectInputStream(in);
			copy = (DiGraph<T>) oi.readObject();
			oi.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return copy;
	}



		
}

/**
 * An instance of the class is used in the implementation of the <tt>DiGraph</tt> class
 * to compare keys (vertices) in the <tt>TreeMap</tt> of vertex-index pairs.
 */
class SortEntry implements Comparator {

    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer indicating whether the first argument is &quot;
     * less than&quot, &quot;equal to&quot, or &quot;greater than&quot the second
     * argument respectively.<p>
     *
     * @param x the first object to be compared.
     * @param y the second object to be compared.
     * @return a negative integer if the first argument is &quot;less than&quot
     *         the second argument.<br>
     *         zero if the two arguments are &quot;equal&quot.<br>
     *         a positive integer if the first argument is &quot;
     *         greater than&quot the second argument.
     */
    public int compare(Object x, Object y) {
        Map.Entry obj1 = (Map.Entry) x, obj2 = (Map.Entry) y;

        return ((Comparable) obj1.getKey()).compareTo(obj2.getKey());
    }
}