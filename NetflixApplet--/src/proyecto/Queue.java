/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

public class Queue {
   private Node first;
    private Node last;

    public Queue() {
    }
    
    public boolean Empty(){
        return first == null && last == null;
    }
    
    public void SaveQueue(Object data){
        if(Empty()){
            first = new Node(data); last = first;
            } else {
            Node n = new Node(data); last.setLink(n);
            last = n;
        }
    }
    
    public Object Dequeue () {
        Object data=null;
        if(!Empty()){
            data= first.getData(); first=first.getLink();
            if(first==null)
                last = null;
        }
        return data;
    }
    
    
    
}
