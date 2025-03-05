/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuxClass;

/**
 *
 * @author Angelo
 * @param <T>
 */
public class Node <T>{
    private T tInfo;
    private Node <T> pNext;
    
    //Constructor
    public Node (T elem){
        this.tInfo=elem;
        this.pNext=null;
        
    } 

    /**
     * @return the tInfo
     */
    public T gettInfo() {
        return tInfo;
    }

    /**
     * @param tInfo the tInfo to set
     */
    public void settInfo(T tInfo) {
        this.tInfo = tInfo;
    }

    /**
     * @return the pNext
     */
    public Node <T> getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(Node <T> pNext) {
        this.pNext = pNext;
    }
    
}
