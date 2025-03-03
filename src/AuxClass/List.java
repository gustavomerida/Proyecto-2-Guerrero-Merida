/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuxClass;


/**
 *
 * @author Angelo
 */
public class List <T>{
    private Node <T> pFirst;
    private String name;
    private int iN;
    
    
    public List (String s){
        this.name=s;
        this.pFirst=null;
        this.iN=0;
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
    
    public int size (){
        return this.iN;
    }
    
    public boolean isEmpty(){
        return this.pFirst==last();
    }
    
    public Node last(){
        return null;
    }
    
    public Node first(){
        return this.pFirst;
    }
    
    public T read(Node <T> pValor){
        return pValor.gettInfo();
    }
    
    public Node <T> next (Node <T> pValor){
        if (pValor != this.last()){
            return pValor.getpNext();
        }else{
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
    
    public void insert(T x, Node <T> pValor){
     // postinsertar.   
        Node <T> pNew= new Node <>(x);
        if (this.isEmpty()){
            this.pFirst=pNew;
        }else{
            pNew.setpNext(pValor.getpNext());
            pValor.setpNext(pNew);
        }
        iN++;
    }
    public String travel (){
        Node <T> pAux; 
        String result="";
        if(this.isEmpty()){
            result="Está vacía";
        }else{
            pAux=this.first();
            while (pAux != this.last()){
                result=result+this.read(pAux)+ ", ";
                pAux=this.next(pAux);
            }
            
        }
        return result;
    }
    
    public void append(T data) {
        Node<T> newNode = new Node<>(data);
        if (pFirst == null) {
            pFirst = newNode;
        } else {
            Node<T> temp = pFirst;
            while (temp.getpNext()!= null) {
                temp = temp.getpNext();
            }
            temp.setpNext(newNode);
        }
        iN++;
    }
    
    
    public Node <T> beforeLast(){
        if (this.isEmpty()){
            return null;
        }else{
            Node <T> pAux=this.first();
            while (pAux.getpNext()!= this.last()){
                pAux=this.next(pAux);
            }
            return pAux;
        }
    }
}
