package org.graphstream.graph.test;

import static org.junit.Assert.*;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.Path;
import org.graphstream.graph.implementations.DefaultGraph;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class PathTest_CE {
	
	public Graph grafo = new DefaultGraph("Teste"); 
	public Path path = new Path();
	
	@Before 
	public void Cria_Path_Grafo() {
		
		grafo.setStrict(false);
		grafo.setAutoCreate(true);

		grafo.addEdge("ab", "a", "b");
		grafo.addEdge("bc", "b", "c");
		grafo.addEdge("cd", "c", "d");
		
		
}
	@After
	public void Limpa_Path() {
		path.clear();
	}

	@Test
	public void SetRoot_cls_vld() {
		path.setRoot(grafo.getNode("a"));
		
		assertEquals(grafo.getNode("a"),path.getRoot());
		}
	
	@Test
	public void add_node_test_V1() {
		path.setRoot(grafo.getNode("a"));
		
		path.add(grafo.getNode("a"), grafo.getEdge("ab"));
		
		assertTrue(path.contains(grafo.getEdge("ab")));
		assertTrue(path.contains(grafo.getNode("a")));
	}
	
	@Test
	public void add_node_test_V2() {
		path.add(grafo.getNode("a"), grafo.getEdge("ab"));
		
		assertTrue(path.contains(grafo.getEdge("ab")));
		assertTrue(path.contains(grafo.getNode("a")));
	}
	
	@Test 
	public void add_node_test_V3() {
		path.setRoot(grafo.getNode("a"));
		
		path.add(grafo.getNode("a"), grafo.getEdge("ab"));
		path.add(grafo.getNode("b"), grafo.getEdge("bc"));
		
		
		assertTrue(path.contains(grafo.getEdge("bc")));
		assertTrue(path.contains(grafo.getNode("b")));
		assertTrue(path.contains(grafo.getNode("c")));
	}
	
	@Test
	public void add_node_test_v4() {
		path.setRoot(grafo.getNode("a"));
		
		path.add(grafo.getNode("a"), grafo.getEdge("ab"));
		path.add(grafo.getNode("b"), grafo.getEdge("bc"));
		
		
		assertTrue(path.contains(grafo.getEdge("bc")));
		assertTrue(path.contains(grafo.getNode("b")));
		assertTrue(path.contains(grafo.getNode("c")));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void add_node_test_I1() {
		path.add(null, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void add_node_test_I2() {
		path.setRoot(grafo.getNode("a"));
		path.add(null, grafo.getEdge("bc"));
		
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void add_node_test_I3() {
		path.setRoot(grafo.getNode("a"));
		path.add(null, grafo.getEdge("bc"));
		
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void add_node_test_I4() {
		path.setRoot(grafo.getNode("a"));
		path.add(path.getRoot(), grafo.getEdge("ac"));
		
		
	}
	
	
	
	
	

}
