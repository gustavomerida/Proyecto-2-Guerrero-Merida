/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuxClass;

import MainPackage.Block;

/**
 *
 * @author Angelo
 */
public class List<T> {

    private Node<T> pFirst;
    private String name;
    private int iN;

    public List(String s) {
        this.name = s;
        this.pFirst = null;
        this.iN = 0;
    }

    public Node<T> getSpecificNode(Object elem) {
        Node<T> actual = this.pFirst;
        while (actual != null) {
            if (actual.gettInfo().equals(elem)) {
                return actual;
            }
            actual = actual.getpNext();
        }
        return null;
    }

    public int size() {
        return this.iN;
    }

    public boolean isEmpty() {
        return this.pFirst == last();
    }

    public Node last() {
        return null;
    }

    public Node first() {
        return this.pFirst;
    }

    public T read(Node<T> pValor) {
        return pValor.gettInfo();
    }

    public Node<T> next(Node<T> pValor) {
        if (pValor != this.last()) {
            return pValor.getpNext();
        } else {
            return null;
        }
    }

    public T get(int index) {
        if (index < 0 || index >= iN) {
            throw new IndexOutOfBoundsException("index overflow");
        }

        Node<T> current = pFirst;
        for (int i = 0; i < index; i++) {
            current = current.getpNext();
        }
        return current.gettInfo();
    }

    public void insert(T x, Node<T> pValor) {
        // postinsertar.   
        Node<T> pNew = new Node<>(x);
        if (this.isEmpty()) {
            this.pFirst = pNew;
        } else {
            pNew.setpNext(pValor.getpNext());
            pValor.setpNext(pNew);
        }
        iN++;
    }

    public Node<T> getpFirst(){
        return this.pFirst;
    }
    public String travel() {
        Node<T> pAux;
        String result = "";
        if (this.isEmpty()) {
            result = "Está vacía";
        } else {
            pAux = this.first();
            while (pAux != this.last()) {
                result = result + this.read(pAux) + ", ";
                pAux = this.next(pAux);
            }

        }
        return result;
    }

    public String travel2() {
        Node<T> pAux = this.first();
        StringBuilder result = new StringBuilder();

        if (this.isEmpty()) {
            return "Está vacía";
        }
        
        while (pAux != this.last()) {
            T info = pAux.gettInfo(); // Obtener el valor del nodo

            // Verificar si el tipo es Block y llamar a ShowID, de lo contrario usar toString()
            if (info instanceof Block) {
                result.append(((Block) info).ShowID());
            } else {
                result.append(info.toString()); // Usar toString() para otros tipos
            }
            result.append(", "); // Separar elementos con una coma

            pAux = this.next(pAux); // Pasar al siguiente nodo
        }

        return result.toString();
    }

    public void append(T data) {
        Node<T> newNode = new Node<>(data);
        if (pFirst == null) {
            pFirst = newNode;
        } else {
            Node<T> temp = pFirst;
            while (temp.getpNext() != null) {
                temp = temp.getpNext();
            }
            temp.setpNext(newNode);
        }
        iN++;
    }

    public Node<T> beforeLast() {
        if (this.isEmpty()) {
            return null;
        } else {
            Node<T> pAux = this.first();
            while (pAux.getpNext() != this.last()) {
                pAux = this.next(pAux);
            }
            return pAux;
        }
    }
    public boolean remove(T elem) {
        
        if (this.isEmpty()) {
            return false; // La lista está vacía
        }

        // Si el primer nodo es el que se quiere eliminar
        
        if (this.pFirst.gettInfo().equals(elem)) {
            System.out.println("Era el primero");
            this.pFirst = this.pFirst.getpNext(); // Cambiar el primer nodo
            iN--;
            return true;
        }

        Node<T> current = this.pFirst;
        while (current.getpNext() != null) {
            System.out.println("¿Son igualessss?" + current.getpNext().gettInfo().equals(elem));
            if (current.getpNext().gettInfo().equals(elem)) {
                System.out.println("si soon");
                current.setpNext(current.getpNext().getpNext()); // Eliminar el nodo
                iN--;
                return true;
            }
            current = current.getpNext();
        }

        return false; // No se encontró el elemento
    }
}
