package com.example.project;

public class SinglyLinkedList<T extends Comparable<T>> {
    private Node<T> first; // Primero nodo de la lista
    private int size; // Tamano de la lista

    // Constructor (crea lista vacia)
    SinglyLinkedList() {
        first = null;
        size = 0;
    }
    // Retorna el tamano de la lista
    public int size() {
        return size;
    }

    // Devuelve true si la lista esta vazia o false caso contrario
    public boolean isEmpty() {
        return (size == 0);
    }

    // Adiciona v al inicio de la lista
    public void addFirst(T v) {
        Node<T> newNode = new Node<T>(v, first);
        first = newNode;
        size++;
    }

    // Adiciona v al final de la lista
    public void addLast(T v) {
        Node<T> newNode = new Node<T>(v, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node<T> cur = first;
            while (cur.getNext() != null)
                cur = cur.getNext();
            cur.setNext(newNode);
        }
        size++;
    }

    // Retorna el primer valor de la lista (o null si la lista esta vacia)
    public T getFirst() {
        if (isEmpty())
            return null;
        return first.getValue();
    }

    // Retorna el ultimo valor de la lista (o null si la lista esta vazia)
    public T getLast() {
        if (isEmpty())
            return null;
        Node<T> cur = first;
        while (cur.getNext() != null)
            cur = cur.getNext();
        return cur.getValue();
    }

    // Elimina el primer elemento de la lista (si esta vacia no hara nada)
    public void removeFirst() {
        if (isEmpty())
            return;
        first = first.getNext();
        size--;
    }

    // Elimina el ultimo elemento de la lista (si esta vacia no hara nada)
    public void removeLast() {
        if (isEmpty())
            return;
        if (size == 1) {
            first = null;
        } else {
            // Ciclo con for y uso de size para mostrar alternativa al while
            Node<T> cur = first;
            for (int i = 0; i < size - 2; i++)
                cur = cur.getNext();
            cur.setNext(cur.getNext().getNext());
        }
        size--;
    }

    // Convierte la lista para um String
    public String toString() {
        String str = "{";
        Node<T> cur = first;
        while (cur != null) {
            str += cur.getValue();
            cur = cur.getNext();
            if (cur != null)
                str += ",";
        }
        str += "}";
        return str;
    }

    // NUEVOS METODOS

    // Elimina aquellos nodos de la lista que esten duplicados
    public void  deleteDuplicates(){  
    	//Se usa el ultimo valor del last, para compararlos en orden con los primeros
    	T valorUltimo = getLast();
    	
    	Node<T> cur = first;//Se crea un nodo auxiliar que empiece en first
    	//recorre y compara cada nodo
    	for(int e=0; e<size-1&&cur.getNext()!=null;) {
    		if((cur.getValue()).compareTo(valorUltimo)== 0){
    			deleteNth(size);
    			deleteDuplicates();
    			break;
    			
    		}
    		cur = cur.getNext();
    		e++;
    	}
    }

    // Inserta un nuevo nodo en una posicion especifica de la lista
    public void insertNth(T data, int position) {
    	if (isEmpty())
            return;
    	else if (position>size) {
    		System.out.println("???Fuera de rango.???");
            return ;}
    	else if (position == 0) {
           addFirst(data);
            }
    	else if (position == size) {
    		 addLast(data);
            }
        else {
            // Ciclo con for y uso de size para mostrar alternativa al while
            Node<T> cur = first;
            for (int i = 0; i < position-1; i++) {
            	cur = cur.getNext();
                }
            Node<T> newNode = new Node<T>(data, cur.getNext());
            cur.setNext(newNode);
        }
        size++;

    }

    // Elimina el nodo de una posicion especifica de la lista
    public void deleteNth(int position) {
    
    	if (isEmpty())
            return;
    	else if (position>size) {
    		System.out.println("???Fuera de rango.???");
            return ;}
    	else if (position == 0) {
            removeFirst();
            }
    	else if (position == size-1) {
            removeLast();
            }
        else {
            // Ciclo con for y uso de size para mostrar alternativa al while
            Node<T> cur = first;
            for (int i = 0; i < size-2; i++) {
            	cur = cur.getNext();
                }
            cur.setNext(cur.getNext().getNext());
        }
        size--;
    }

    public static void main(final String[] args) {

        testExercicio1();
        //testExercicio2();
        //testExercicio3();       

    }

    public static void testExercicio1(){

    	SinglyLinkedList<String> list = new SinglyLinkedList<String>();

        list.addLast("Jorge");
        list.addLast("Juan");
        list.addLast("Jorge");
        

        System.out.println(list);

        list.deleteDuplicates();

        System.out.println(list);
    }

    public static void testExercicio2(){

        SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

        list.addLast('a');
        list.addLast('b');
        list.addLast('d');

        System.out.println(list);
        int num=5;
        list.insertNth('c', num);
        if(num<=list.size)
        	System.out.println(list);
    }

    public static void testExercicio3(){

        SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

        list.addLast('a');
        list.addLast('b');
        list.addLast('d');
        System.out.println(list);
       
        
        int num=1;
        list.deleteNth(num);
        System.out.println(list);
    }
  
}
