package algo2.semana07.lista;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ListaEnlazadaTest {

    private ListaEnlazada<Integer> lista;

    @Before
    public void setUp() {
        lista = new ListaEnlazada<>();
    }

    @Test
    public void testListaVacia() {
        assertTrue(lista.isEmpty());
        assertEquals(0, lista.size());
    }

    @Test
    public void testAddYSize() {
        lista.add(10);
        lista.add(20);
        lista.add(30);
        lista.add(40);
        lista.add(50);
        lista.add(60);
        assertEquals(6, lista.size());
        assertFalse(lista.isEmpty());
    }

    @Test
    public void testAddPorIndice() {
        lista.add(10);
        lista.add(30);
        lista.add(1, 20);
        assertEquals(Integer.valueOf(20), lista.get(1));
    }

    @Test
    public void testGetYSet() {
        lista.add(5);
        lista.add(10);
        lista.add(15);
        assertEquals(Integer.valueOf(10), lista.get(1));
        lista.set(1, 20);
        assertEquals(Integer.valueOf(20), lista.get(1));
    }

    @Test
    public void testRemovePorIndice() {
        lista.add(1);
        lista.add(2);
        lista.add(3);
        Integer eliminado = lista.remove(1);
        assertEquals(Integer.valueOf(2), eliminado);
        assertEquals(2, lista.size());
    }

    @Test
    public void testRemovePorObjeto() {
        lista.add(10);
        lista.add(20);
        lista.add(30);
        assertTrue(lista.remove(Integer.valueOf(20)));
        assertFalse(lista.contains(20));
        assertEquals(2, lista.size());
    }

    @Test
    public void testClear() {
        lista.add(1);
        lista.add(2);
        lista.clear();
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testIndexOf() {
        lista.add(10);
        lista.add(20);
        lista.add(30);
        assertEquals(1, lista.indexOf(20));
    }
    
    @Test
    public void testContains() {
    	lista.add(10);
    	lista.add(20);
    	lista.add(30);
    	assertTrue(lista.contains(30));
    }

    @Test
    public void testAddFirstYAddLast() {
        lista.addFirst(5);
        lista.addLast(10);
        lista.addLast(15);
        assertEquals(Integer.valueOf(5), lista.get(0));
        assertEquals(Integer.valueOf(15), lista.get(lista.size() - 1));
    }

    @Test
    public void testEquals() {
        ListaEnlazada<Integer> otra = new ListaEnlazada<>();
        lista.add(1);
        lista.add(2);
        otra.add(1);
        otra.add(2);
        assertTrue(lista.equals(otra));
    }
    
    @Test
    public void testAdd() {
    	lista.add(20);
    	lista.add(15);
    	lista.add(18);
    	assertEquals("Lista(20, 15, 18)", lista.toString());
    }
}
