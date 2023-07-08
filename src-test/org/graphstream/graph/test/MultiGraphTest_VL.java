package org.graphstream.graph.test;

import static org.junit.Assert.*;

import org.graphstream.graph.Edge;
import org.graphstream.graph.ElementNotFoundException;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.junit.After;
import org.junit.Test;

public class MultiGraphTest_VL {

public  Graph grafo = new MultiGraph("Teste");
	
	
	
	@After
	public void limpa_grafo() {
		grafo.clear();
	}
	
	@Test
	public void addnode_test_V1() {
		
		
		Node A = grafo.addNode("A");
		
		assertEquals(grafo.getNode("A"),A);
	}
	
	@Test(expected =  AssertionError	.class)
	public void addnode_test_I1() {
		
		
		grafo.addNode(null);
		
}
	
	
	@Test
	public void addedge_test_V1() {
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		Edge AB = grafo.addEdge("AB", A.getIndex(), B.getIndex());
		
		assertEquals(AB,grafo.getEdge("AB"));
	}
	
	@Test
	public void addedge_test_V2() {
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		Edge AB = grafo.addEdge("AB", A.getIndex(), B.getIndex());
		
		assertEquals(AB,grafo.getEdge("AB"));
	}
	
	@Test(expected =  IndexOutOfBoundsException.class)
	public void addedge_test_I1() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		
		grafo.addEdge("AB", -1, B.getIndex());
		
	}
	
	@Test(expected =  IndexOutOfBoundsException.class)
	public void addedge_test_I2() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		assertEquals(2,grafo.getNodeCount());
		int max = grafo.getNodeCount()+1;
		grafo.addEdge("AB", max, B.getIndex());
		
	}
	
	@Test(expected =  IndexOutOfBoundsException.class)
	public void addedge_test_I3() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		
		grafo.addEdge("AB", A.getIndex(), -1);
		
	}
	
	@Test(expected =  IndexOutOfBoundsException.class)
	public void addedge_test_I4() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		assertEquals(2,grafo.getNodeCount());
		int max = grafo.getNodeCount()+1;
		grafo.addEdge("AB", A.getIndex(), max);
		
	}
	
	@Test
	public void addege_test_V3() {
		
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		assertEquals(AB,grafo.getEdge("AB"));
	}
	
	@Test
	public void addege_test_V4() {
		
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		assertEquals(AB,grafo.getEdge("AB"));
	}
	
	@Test
	public void addege_test_V5() {
		
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		assertEquals(AB,grafo.getEdge("AB"));
	}
	
	@Test(expected=AssertionError.class)
	public void addege_test_I5() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		grafo.addEdge(null, "A", "B");
		
	}
	
	@Test(expected=ElementNotFoundException.class)
	public void addege_test_I6() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		grafo.addEdge("AB", null, "B");
		
	}
	
	@Test(expected=ElementNotFoundException.class)
	public void addege_test_I7() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		grafo.addEdge("AB", "A", null);
		
	}
	
	@Test
	public void addege_test_V6() {
		
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", A, B);
		assertEquals(AB,grafo.getEdge("AB"));
	}
	
	@Test(expected=AssertionError.class)
	public void addege_test_I8() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		grafo.addEdge(null, A, B);
		
	}
	
	@Test(expected=NullPointerException.class)
	public void addege_test_I9() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		grafo.addEdge("AB", null, B);
		
	}
	
	@Test(expected=NullPointerException.class)
	public void addege_test_I10() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		grafo.addEdge("AB", A, null);
		
	}
	
	@Test 
	public void removenode_test_V1() {
		
		Node A = grafo.addNode("A");
		Node _A = grafo.removeNode(A.getIndex());
		
		assertEquals(A,_A);
		assertEquals(0,grafo.getNodeCount());
		
		
	}
	@Test(expected =  IndexOutOfBoundsException.class)
	public void removenode_test_I1() {
		
		grafo.addNode("A");
		grafo.removeNode(-1);
		}
	
	@Test(expected =  IndexOutOfBoundsException.class)
	public void removenode_test_I2() {
		
		grafo.addNode("A");
		grafo.removeNode(grafo.getNodeCount()+1);
		}
	
	@Test
	public void removenode_test_V2() {
		
		Node A = grafo.addNode("A");
		Node _A = grafo.removeNode("A");
		assertEquals(A,_A);
		assertEquals(0,grafo.getNodeCount());
		
		
	}
	
	@Test(expected =  ElementNotFoundException.class)
	public void removenode_test_I3() {
		String d = null;
		
		grafo.removeNode(d);
		
		}
	
	@Test
	public void removeedge_test_V1() {
		
		grafo.addNode("A");
		grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		Edge _AB = grafo.removeEdge(AB);
		
		assertEquals(AB,_AB);
		assertEquals(0,grafo.getEdgeCount());
		
		
	}
	
	@Test(expected = AssertionError.class)
	public void removeedge_test_I1() {
		
		grafo.setStrict(true);
		grafo.addNode("A");
		grafo.addNode("B");
		
		Edge AB = grafo.addEdge(null, "A", "B");
		
		}
	
	
	@Test
	public void removeedge_test_V2() {
		
		grafo.addNode("A");
		grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		Edge _AB = grafo.removeEdge(AB.getIndex());
		
		assertEquals(AB,_AB);
		assertEquals(0,grafo.getEdgeCount());
		
		
	}
	
	@Test(expected =  IndexOutOfBoundsException.class)	
	public void removeedge_test_I2() {
		
		grafo.addNode("A");
		grafo.addNode("B");
		
		grafo.addEdge("AB", "A", "B");
		grafo.removeEdge(-1);
		}
	
	@Test(expected =  IndexOutOfBoundsException.class)	
	public void removeedge_test_I3() {
		
		grafo.addNode("A");
		grafo.addNode("B");
		
		grafo.addEdge("AB", "A", "B");
		grafo.removeEdge(grafo.getEdgeCount()+1);
		}
	
	@Test
	public void removeedge_test_V3() {
		
		grafo.addNode("A");
		grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		Edge _AB = grafo.removeEdge("AB");
		
		assertEquals(AB,_AB);
		assertEquals(0,grafo.getEdgeCount());
		
		
	}
	
	@Test	
	public void removeedge_test_I4() {
		
		grafo.setStrict(false);
		grafo.addNode("A");
		grafo.addNode("B");
		
		String ab = null;
		assertNull(grafo.removeEdge(ab));
		}
	
	
	@Test
	public void removeedge_test_V4() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		Edge _AB = grafo.removeEdge(A,B);
		
		assertEquals(AB,_AB);
		assertEquals(0,grafo.getEdgeCount());
	}
	
	@Test(expected=NullPointerException.class)
	public void removeedge_test_I5() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		Node C = grafo.addNode("C");
		Edge AB = grafo.addEdge("AB", "A", "B");
		Node a = null;
		Edge _AB = grafo.removeEdge(a,B);
		
		
	}
	
	@Test(expected=NullPointerException.class)
	public void removeedge_test_I6() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		Node C = grafo.addNode("C");
		Edge AB = grafo.addEdge("AB", "A", "B");
		Node b = null;
		Edge _AB = grafo.removeEdge(A,b);
		
		
	}
	
	
	@Test
	public void removeedge_test_V5() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		Edge _AB = grafo.removeEdge(A.getIndex(),B.getIndex());
		
		assertEquals(AB,_AB);
		assertEquals(0,grafo.getEdgeCount());
	}
	
	@Test(expected =  IndexOutOfBoundsException.class)	
	public void removeedge_test_I7() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		grafo.addEdge("AB", "A", "B");
		grafo.removeEdge(-1,B.getIndex());
		}
	
	@Test(expected =  IndexOutOfBoundsException.class)	
	public void removeedge_test_I8() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		grafo.addEdge("AB", "A", "B");
		grafo.removeEdge(grafo.getNodeCount()+1,B.getIndex());
		}
	
	@Test(expected =  IndexOutOfBoundsException.class)	
	public void removeedge_test_I9() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		grafo.addEdge("AB", "A", "B");
		grafo.removeEdge(A.getIndex(),-1);
		}
	
	@Test(expected =  IndexOutOfBoundsException.class)	
	public void removeedge_test_I10() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		grafo.addEdge("AB", "A", "B");
		grafo.removeEdge(A.getIndex(),grafo.getNodeCount()+1);
		}
	
	@Test
	public void removeedge_test_V6() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		Edge _AB = grafo.removeEdge("A","B");
		
		assertEquals(AB,_AB);
		assertEquals(0,grafo.getEdgeCount());
	}
	
	@Test(expected=ElementNotFoundException.class)
	public void removeedge_test_I11() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		String a = null;
		Edge _AB = grafo.removeEdge(a,"B");
		
		
	}
	
	@Test(expected=ElementNotFoundException.class)
	public void removeedge_test_I12() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		String b = null;
		Edge _AB = grafo.removeEdge("A",b);
		
		
	}
	
	@Test 
	public void getnode_test_V1() {
		
		Node A = grafo.addNode("A");
		
		Node _A = grafo.getNode(A.getIndex());
		
		assertEquals(A,_A);
	}
	
	@Test(expected =  IndexOutOfBoundsException.class)	
	public void getnode_test_I1() {
		
		Node A = grafo.addNode("A");
		
		grafo.getNode(-1);
		
		
	}
	
	@Test(expected =  IndexOutOfBoundsException.class)	
	public void getnode_test_I2() {
		
		Node A = grafo.addNode("A");
		
		grafo.getNode(grafo.getNodeCount()+1);
		
		
	}
	
	@Test 
	public void getnode_test_V2() {
		
		Node A = grafo.addNode("A");
		
		Node _A = grafo.getNode(A.getId());
		
		assertEquals(A,_A);
	}
	
		
	public void getnode_test_I3() {
		
		Node A = grafo.addNode("A");
		String a = null;
		assertNull(grafo.getNode(a));
		
		
	}
	
	@Test
	public void getedge_test_V1() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		Edge _AB = grafo.getEdge(AB.getIndex());
		
		assertEquals(AB,_AB);
		
	}
	
	@Test(expected =  IndexOutOfBoundsException.class)	
	public void getedge_test_I1() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		grafo.getEdge(-1);
		
		
	}
	
	@Test(expected =  IndexOutOfBoundsException.class)	
	public void getedge_test_I2() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		grafo.getEdge(grafo.getEdgeCount()+1);
		
		
	}
	
	@Test
	public void getedge_test_V2() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		Edge _AB = grafo.getEdge(AB.getId());
		
		assertEquals(AB,_AB);
		
	}
	
	@Test
	public void getedge_test_I3() {
		
		Node A = grafo.addNode("A");
		Node B = grafo.addNode("B");
		
		Edge AB = grafo.addEdge("AB", "A", "B");
		String ab = null;
		assertNull(grafo.getEdge(ab));
		
		
	}
	
	@Test
	public void setattribure_test_v1() {
		
		
		grafo.setAttribute("teste", "teste"	);
		assertEquals(grafo.getAttributeCount(),1);
		
		
		
	}
	
	@Test(expected=NullPointerException.class)
	public void setattribure_test_I1() {
		
		
		grafo.setAttribute(null, "teste"	);
		assertEquals(grafo.getAttributeCount(),1);
		
		
		
	}
	
	@Test
	public void getattribute_test_V1() {
		
		
		
		grafo.setAttribute("teste", "teste"	);
		
		assertEquals("teste",grafo.getAttribute("teste"));
		
	}
	
	@Test
	public void getattribute_test_I1() {
		
		
		
		grafo.setAttribute("teste", "teste"	);
		
		assertEquals(null,grafo.getAttribute(null));
		
	}
	
	
	@Test
	public void removeattribure_test_v1() {
		
		
		grafo.setAttribute("teste", "teste"	);
		grafo.removeAttribute("teste");
		
		assertEquals(0,grafo.getAttributeCount());
		
		
	}
	
	@Test
	public void removeattribure_test_I1() {
		
		
		grafo.setAttribute("teste", "teste"	);
		grafo.removeAttribute(null);
		
		assertEquals(1,grafo.getAttributeCount());
		
		
	}

}
