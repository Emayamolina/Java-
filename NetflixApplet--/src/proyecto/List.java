/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

public class List {
    private Node first;
    
    public List(){
        first=null;    
    }

    public Node getFirst() {
        return first;
    }
    
    public boolean isEmpty(){
        return first==null;    
    }
 
    
    public void addFirst(Object data){
        if(first==null){

            first = new Node(data);
        } else {
            Node nodo= new Node(data);
            nodo.setLink(first);
            first=nodo;  
        }
    }
    
    public void addLast(Object data){
         if(isEmpty()){

            first = new Node(data);
        } else {
             Node n= new Node(data);
             Node last= Last();
             last.setLink(n);
         }
    }
    
    public Node Last(){
        Node aux= first, pre=null;
        while(aux!=null){
        pre=aux;
        aux=aux.getLink();
    }
        return pre;
    }

    public String toString(){
        String text=" ";
        Node aux= first;
        while(aux!=null){
            text= text+ aux.getData() + " /n";
            aux=aux.getLink();
        }
                return text;
       
    }
    
    public Node Previous(Object data){
        Node aux= first, pre=null;
        while (aux != null && aux.getData().equals(data)) {            
            pre = aux;
            aux = aux.getLink();
        }
        if (aux==null) 
            return null;
        else 
            return pre;
    }
     public String Search(String title) {
        String mess = "";
       Node aux = first;
        while (aux != null) {
            
            if (((Reproduction)aux.getData()).getTitle().equals(title)) {
                mess = mess + aux.getData().toString() + "\n";
            }
            aux = aux.getLink();
        }
        return mess;
    }
    public void Add(Object data){
        Node aux=first;
        while (aux != null && ((Reproduction)aux.getData()).getYear()>((Reproduction)data).getYear()) 
            aux=aux.getLink();
            if(aux==null)
                addLast(data);            
        else {
                Node p=Previous(aux.getData());
            if( p==null)
                addFirst(data);
            else {
                
                
                Node n= new Node(data);
                p.setLink(n);
            }
        }
    }
    
    public int Size(){
        Node aux=first;
        int cont=0;
        while (aux!=null) {            
            cont ++;
            aux=aux.getLink();
        }
        return cont;
    }
    
    public boolean removeFirst(){
        if (!isEmpty()) {
            Node aux= first;
            first= first.getLink();
            aux=null;
            return true;
        }
        return false;
    }
    
   public boolean RemoveLast(){
          if(!isEmpty())
          {
              Node last=Last();
              Node pre=Previous(last.getData());
              if(pre!=null)
                  pre.setLink(null);
              else
                  first=null;
              last=null;
              return true;
          }
          return false;
      }

    public boolean Remove(int pos) {
        if(!isEmpty()){
            if(pos==1)
                removeFirst();
            else{
                if(pos==Size())
                    RemoveLast();
                else{
                    Node aux = first;
                    int cont = 1;
                    while(cont<pos){
                        aux = aux.getLink();
                        cont++;
                    }
                    Node pre = Previous(aux.getData());  
                    pre.setLink(aux.getLink());
                    aux=null;                     
                }
            }
            return true;
        }
        return false;
    }
    
    
 
    
}