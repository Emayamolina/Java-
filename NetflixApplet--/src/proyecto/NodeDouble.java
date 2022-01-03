/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
public class NodeDouble {
    private NodeDouble previuos;//restructura recursiva
    private Object data;
    private NodeDouble next;

    public NodeDouble(Object data) {
        this.data = data;
    }

    //CREACIÓN DE GET
    public Object getData() {
        return data;
    }

    public NodeDouble getNext() {
        return next;
    }

    public NodeDouble getPreviuos() {
        return previuos;
    }
    
    //CREACIÓN DE SET 
    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(NodeDouble next) {
        this.next = next;
    }

    public void setPreviuos(NodeDouble previuos) {
        this.previuos = previuos;
    }
    
    
    
}