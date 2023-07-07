package org.graphstream.graph.test;

import static org.junit.Assert.*;

import org.graphstream.graph.Edge;
import org.graphstream.graph.EdgeRejectedException;
import org.graphstream.graph.ElementNotFoundException;
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
	
	@Test 
	public void removenode_test_V1() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		Node _A = grafo.removeNode(A.getIndex());
		
		assertEquals(A,_A);
		assertEquals(0,grafo.getNodeCount());
		
		
	}
	
	@Test(expected =  IndexOutOfBoundsException.class)
	public void removenode_test_I1() {
		Graph grafo = new SingleGraph("Teste");
		grafo.addNode("A");
		grafo.removeNode(2);
		}
	
	
	@Test
	public void removenode_test_V2() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		Node _A = grafo.removeNode("A");
		assertEquals(A,_A);
		assertEquals(0,grafo.getNodeCount());
		
		
	}
	
	@Test(expected =  ElementNotFoundException.class)
	public void removenode_test_I2() {
		Graph grafo = new SingleGraph("Teste");
		
		grafo.removeNode("A");
		
		}
	
	@Test
	public void removenode_test_V3() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		Node _A = grafo.removeNode(A);
		assertEquals(A,_A);
		assertEquals(0,grafo.getNodeCount());
	
		
		
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void removenode_test_I3() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		grafo.removeNode(A);
		grafo.removeNode(A);
		
	}
	
	@Test
	public void removeedge_test_V1() {
		Graph grafo = new SingleGraph("Teste");
		grafo.addNode("A");
		grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		Edge _AB = grafo.removeEdge(AB);
		
		assertEquals(AB,_AB);
		assertEquals(0,grafo.getEdgeCount());
		
		
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void removeedge_test_I1() {
		Graph grafo = new SingleGraph("Teste");
		grafo.setStrict(true);
		grafo.addNode("A");
		grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		grafo.removeEdge(AB);
		grafo.removeEdge(AB);
		}
	
	
	@Test
	public void removeedge_test_V2() {
		Graph grafo = new SingleGraph("Teste");
		grafo.addNode("A");
		grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		Edge _AB = grafo.removeEdge(AB.getIndex());
		
		assertEquals(AB,_AB);
		assertEquals(0,grafo.getEdgeCount());
		
		
	}
	
	@Test(expected =  IndexOutOfBoundsException.class)	
	public void removeedge_test_I2() {
		Graph grafo = new SingleGraph("Teste");
		grafo.addNode("A");
		grafo.addNode("B");
		
		grafo.addEdge("AB", "A", "B");
		grafo.removeEdge(2);
		}
	
	@Test
	public void removeedge_test_V3() {
		Graph grafo = new SingleGraph("Teste");
		grafo.addNode("A");
		grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		Edge _AB = grafo.removeEdge("AB");
		
		assertEquals(AB,_AB);
		assertEquals(0,grafo.getEdgeCount());
		
		
	}
	
	@Test	
	public void removeedge_test_I3() {
		Graph grafo = new SingleGraph("Teste");
		grafo.setStrict(false);
		grafo.addNode("A");
		grafo.addNode("B");
		
		
		assertNull(grafo.removeEdge("AB"));
		}
	
	@Test(expected=ElementNotFoundException.class)
	public void removeedge_test_I3_1() {
		Graph grafo = new SingleGraph("Teste");
		grafo.addNode("A");
		grafo.addNode("B");
		
		
		grafo.removeEdge("AB");
		}
	
	@Test
	public void removeedge_test_V4() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		Edge _AB = grafo.removeEdge(A,B);
		
		assertEquals(AB,_AB);
		assertEquals(0,grafo.getEdgeCount());
	}
	
	@Test(expected=ElementNotFoundException.class)
	public void removeedge_test_I4() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		Node C = grafo.addNode("C");
		Edge AB = grafo.addEdge("AB", "A", "B");
		Edge _AB = grafo.removeEdge(A,C);
		
		
	}
	
	@Test(expected=ElementNotFoundException.class)
	public void removeedge_test_I5() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		Node C = grafo.addNode("C");
		Edge AB = grafo.addEdge("AB", "A", "B");
		Edge _AB = grafo.removeEdge(C,B);
		
		
	}
	
	@Test
	public void removeedge_test_V5() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		Edge _AB = grafo.removeEdge(A.getIndex(),B.getIndex());
		
		assertEquals(AB,_AB);
		assertEquals(0,grafo.getEdgeCount());
	}
	
	@Test(expected =  IndexOutOfBoundsException.class)	
	public void removeedge_test_I6() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		grafo.addEdge("AB", "A", "B");
		grafo.removeEdge(25,B.getIndex());
		}
	
	@Test(expected =  IndexOutOfBoundsException.class)	
	public void removeedge_test_I7() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		grafo.addEdge("AB", "A", "B");
		grafo.removeEdge(A.getIndex(),4);
		}
	
	@Test
	public void removeedge_test_V6() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		Edge _AB = grafo.removeEdge("A","B");
		
		assertEquals(AB,_AB);
		assertEquals(0,grafo.getEdgeCount());
	}
	
	@Test(expected=ElementNotFoundException.class)
	public void removeedge_test_I8() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		
		Edge _AB = grafo.removeEdge("C","B");
		
		
	}
	
	@Test(expected=ElementNotFoundException.class)
	public void removeedge_test_I9() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		
		Edge _AB = grafo.removeEdge("A","C");
		
		
	}
	
	@Test 
	public void getnode_test_V1() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		
		Node _A = grafo.getNode(A.getIndex());
		
		assertEquals(A,_A);
	}
	
	@Test(expected =  IndexOutOfBoundsException.class)	
	public void getnode_test_I1() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		
		Node _A = grafo.getNode(A.getIndex()+25);
		
		
	}
	
	@Test 
	public void getnode_test_V2() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		
		Node _A = grafo.getNode(A.getId());
		
		assertEquals(A,_A);
	}
	
		
	public void getnode_test_I2() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		
		assertNull(grafo.getNode("B"));
		
		
	}
	
	@Test
	public void getedge_test_V1() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		Edge _AB = grafo.getEdge(AB.getIndex());
		
		assertEquals(AB,_AB);
		
	}
	
	@Test(expected =  IndexOutOfBoundsException.class)	
	public void getedge_test_I1() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		grafo.getEdge(AB.getIndex()+25);
		
		
	}
	
	@Test
	public void getedge_test_V2() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		Edge _AB = grafo.getEdge(AB.getId());
		
		assertEquals(AB,_AB);
		
	}
	
	@Test
	public void getedge_test_I2() {
		Graph grafo = new SingleGraph("Teste");
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		assertNull(grafo.getEdge("AC"));
		
		
	}
	
	@Test
	public void setattribure_test_v1() {
		Graph grafo = new SingleGraph("Teste");
		
		grafo.setAttribute("teste", "teste"	);
		assertEquals(grafo.getAttributeCount(),1);
		
		
		
	}
	
	@Test
	public void getattribute_test_V1() {
		
		Graph grafo = new SingleGraph("Teste");
		
		grafo.setAttribute("teste", "teste"	);
		
		assertEquals("teste",grafo.getAttribute("teste"));
		
	}
	
	@Test
	public void getattribute_test_I1() {
		
		Graph grafo = new SingleGraph("Teste");
		
		grafo.setAttribute("teste", "teste"	);
		
		assertEquals(null,grafo.getAttribute("teste1"));
		
	}
	
	@Test
	public void removeattribure_test_v1() {
		Graph grafo = new SingleGraph("Teste");
		
		grafo.setAttribute("teste", "teste"	);
		grafo.removeAttribute("teste");
		
		assertEquals(0,grafo.getAttributeCount());
		
		
	}
	
	@Test
	public void removeattribure_test_I1() {
		Graph grafo = new SingleGraph("Teste");
		
		grafo.setAttribute("teste", "teste"	);
		grafo.removeAttribute("teste1");
		
		assertEquals(1,grafo.getAttributeCount());
		
		
	}
	
	
	
	
	
	
	
	
	
		
	
	
	
}
