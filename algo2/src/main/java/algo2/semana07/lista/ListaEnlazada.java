package algo2.semana07.lista;

public class ListaEnlazada<E> implements Lista<E> {

    private class Nodo<T> {
        T dato;
        Nodo<T> sgte;

        public Nodo(T dato, Nodo<T> sgte) {
            this.dato = dato;
            this.sgte = sgte;
        }
    }

    private Nodo<E> inicio;
    private Nodo<E> ultimo;
    private int cantidadElemento;

    /** Constructor */
    public ListaEnlazada() {
        inicio = ultimo = null;
        cantidadElemento = 0;
    }

    @Override
    public boolean add(E e) {
        Nodo<E> nuevo = new Nodo<>(e, null);
        if (isEmpty()) {
            inicio = ultimo = nuevo;
        } else {
            ultimo.sgte = nuevo;
            ultimo = nuevo;
        }
        cantidadElemento++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > cantidadElemento)
            throw new IndexOutOfBoundsException();

        Nodo<E> nuevo = new Nodo<>(element, null);

        if (index == 0) { // insertar al inicio
            nuevo.sgte = inicio;
            inicio = nuevo;
            if (cantidadElemento == 0)
                ultimo = nuevo;
        } else if (index == cantidadElemento) { // al final
            ultimo.sgte = nuevo;
            ultimo = nuevo;
        } else {
            Nodo<E> anterior = obtenerNodo(index - 1);
            nuevo.sgte = anterior.sgte;
            anterior.sgte = nuevo;
        }
        cantidadElemento++;
    }

    @Override
    public void addFirst(E e) {
        add(0, e);
    }

    @Override
    public void addLast(E e) {
        add(cantidadElemento, e);
    }

    @Override
    public void clear() {
        inicio = ultimo = null;
        cantidadElemento = 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListaEnlazada<?>)) return false;

        ListaEnlazada<?> otra = (ListaEnlazada<?>) o;

        if (this.cantidadElemento != otra.cantidadElemento) return false;

        Nodo<E> actual1 = this.inicio;
        Object actual2 = otra.inicio;

        while (actual1 != null && actual2 instanceof ListaEnlazada<?>.Nodo<?>) {
            ListaEnlazada<?>.Nodo<?> nodo2 = (ListaEnlazada<?>.Nodo<?>) actual2;

            if (!java.util.Objects.equals(actual1.dato, nodo2.dato))
                return false;

            actual1 = actual1.sgte;
            actual2 = nodo2.sgte;
        }

        return true;
    }

    @Override
    public E get(int index) {
        verificarRango(index);
        return obtenerNodo(index).dato;
    }

    @Override
    public E set(int index, E element) {
        verificarRango(index);
        Nodo<E> nodo = obtenerNodo(index);
        E viejo = nodo.dato;
        nodo.dato = element;
        return viejo;
    }

    @Override
    public int indexOf(Object o) {
        Nodo<E> actual = inicio;
        int index = 0;
        while (actual != null) {
            if ((o == null && actual.dato == null) || (o != null && o.equals(actual.dato)))
                return index;
            actual = actual.sgte;
            index++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return cantidadElemento == 0;
    }

    @Override
    public E remove(int index) {
        verificarRango(index);
        E eliminado;

        if (index == 0) {
            eliminado = inicio.dato;
            inicio = inicio.sgte;
            if (inicio == null)
                ultimo = null;
        } else {
            Nodo<E> anterior = obtenerNodo(index - 1);
            Nodo<E> actual = anterior.sgte;
            eliminado = actual.dato;
            anterior.sgte = actual.sgte;
            if (actual == ultimo)
                ultimo = anterior;
        }
        cantidadElemento--;
        return eliminado;
    }

    @Override
    public boolean remove(Object o) {
        if (isEmpty()) return false;

        if ((o == null && inicio.dato == null) || (o != null && o.equals(inicio.dato))) {
            inicio = inicio.sgte;
            if (inicio == null) ultimo = null;
            cantidadElemento--;
            return true;
        }

        Nodo<E> actual = inicio;
        while (actual.sgte != null) {
            if ((o == null && actual.sgte.dato == null) || (o != null && o.equals(actual.sgte.dato))) {
                if (actual.sgte == ultimo)
                    ultimo = actual;
                actual.sgte = actual.sgte.sgte;
                cantidadElemento--;
                return true;
            }
            actual = actual.sgte;
        }
        return false;
    }

    @Override
    public int size() {
        return cantidadElemento;
    }

    private Nodo<E> obtenerNodo(int index) {
        Nodo<E> actual = inicio;
        for (int i = 0; i < index; i++)
            actual = actual.sgte;
        return actual;
    }

    private void verificarRango(int index) {
        if (index < 0 || index >= cantidadElemento)
            throw new IndexOutOfBoundsException("Índice: " + index + ", Tamaño: " + cantidadElemento);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Lista(");
        Nodo<E> actual = inicio;

        while (actual != null) {
            sb.append(actual.dato);
            if (actual.sgte != null) {
                sb.append(", ");
            }
            actual = actual.sgte;
        }

        sb.append(")");
        return sb.toString();
    }
    
    public static void main(String[] args) {
		ListaEnlazada<Integer> lista = new ListaEnlazada<>();
		lista.add(20);
    	lista.add(15);
    	lista.add(18);
    	System.out.println(lista.toString());
	}
}
