package org.graphstream.graph.test;

import static org.junit.Assert.*;

import org.graphstream.graph.Edge;
import org.graphstream.graph.EdgeRejectedException;
import org.graphstream.graph.Graph;
import org.graphstream.graph.IdAlreadyInUseException;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.Test;

public class SingleGraphTest_CE {

	@Test
	public void addnode_test_V1() {
		Graph grafo = new SingleGraph("Teste");
		
		Node A = grafo.addNode("A");
		
		assertEquals(grafo.getNode("A"),A);
	}
	
	@Test(expected =  IdAlreadyInUseException.class)
	public void addnode_test_I1() {
		Graph grafo = new SingleGraph("Teste");
		
		grafo.addNode("A");
		grafo.addNode("A");
		
		
	}
	
	@Test
	public void addedge_test_V1() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", A.getIndex(), B.getIndex());
		
		assertEquals(AB,grafo.getEdge("AB"));
	}
	
	@Test 
	public void addedge_test_V2() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", A.getIndex(), B.getIndex());
		
		assertEquals(AB,grafo.getEdge("AB"));
	}
	
	@Test
	public void addedge_test_V3() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", A.getIndex(), B.getIndex());
		
		assertEquals(AB,grafo.getEdge("AB"));
	}
	
	@Test(expected =  IdAlreadyInUseException.class)
	public void addedge_test_I1() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		grafo.addEdge("AB", A.getIndex(), B.getIndex());
		grafo.addEdge("AB", A.getIndex(), B.getIndex());
		
	}
	
	@Test(expected =  IndexOutOfBoundsException.class)
	public void addedge_test_I2() {
		Graph grafo = new SingleGraph("Teste");
		
		Node B = grafo.addNode("B");
		
		grafo.addEdge("AB", -10, B.getIndex());
		
	}
	
	@Test(expected =  IndexOutOfBoundsException.class)
	public void addedge_test_I3() {
		Graph grafo = new SingleGraph("Teste");
		
		Node A = grafo.addNode("A");
		
		grafo.addEdge("AB", A.getIndex(), -10);
		
	}
	
	@Test
	public void addedge_test_V4() {
		Graph grafo = new SingleGraph("Teste");
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		
		Edge AB = grafo.addEdge("AB", A, B);
		assertEquals(AB,grafo.getEdge("AB"));
		
		
		
	}
	
	@Test 
	public void addedge_test_V5() {
		Graph grafo = new SingleGraph("Teste");
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		
		Edge AB = grafo.addEdge("AB", A, B);
		assertEquals(AB,grafo.getEdge("AB"));
		
		
	}
	
	@Test 
	public void addedge_test_V6() {
		Graph grafo = new SingleGraph("Teste");
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		
		Edge AB = grafo.addEdge("AB", A, B);
		assertEquals(AB,grafo.getEdge("AB"));
		
		
	}
	
	@Test(expected =  IdAlreadyInUseException.class)
	public void addedge_test_I4() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		grafo.addEdge("AB", A, B);
		grafo.addEdge("AB", A, B);
		
		
	}
	
	@Test(expected=EdgeRejectedException.class)
	public void addege_test_I5() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		grafo.addEdge("AB", A, B);
		grafo.addEdge("_AB", A, B);
	}
	
	@Test(expected=EdgeRejectedException.class)
	public void addege_test_I6() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		grafo.addEdge("AB", A, B);
		grafo.addEdge("_AB", B, A);
		
	}
	
	@Test
	public void addege_test_V7() {
		Graph grafo = new SingleGraph("Teste");
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		assertEquals(AB,grafo.getEdge("AB"));
	}
	
	@Test
	public void addege_test_V8() {
		Graph grafo = new SingleGraph("Teste");
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		assertEquals(AB,grafo.getEdge("AB"));
	}
	
	@Test
	public void addege_test_V9() {
		Graph grafo = new SingleGraph("Teste");
		
		 grafo.addNode("A");
		 grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		assertEquals(AB,grafo.getEdge("AB"));
	}
	
	@Test(expected=IdAlreadyInUseException.class)
	public void addege_test_I7() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		grafo.addEdge("AB", "A", "B");
		grafo.addEdge("AB", "A", "B");
	}
	
	@Test(expected=EdgeRejectedException.class)
	public void addege_test_I8() {
		Graph grafo = new SingleGraph("Teste");
		grafo.addNode("A");
		grafo.addNode("B");
		grafo.addEdge("AB", "A", "B");
		grafo.addEdge("_AB", "A", "B");
		
	}
	
	@Test(expected=EdgeRejectedException.class)
	public void addege_test_I9() {
		Graph grafo = new SingleGraph("Teste");
		grafo.addNode("A");
		grafo.addNode("B");
		grafo.addEdge("AB", "A", "B");
		grafo.addEdge("_AB", "B", "A");
		
		
	}
	
}
