/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

public class TertiaryNode {
    private TertiaryNode left;
    private Object data;
    private TertiaryNode rigth;
    private TertiaryNode center;

    public void setCenter(TertiaryNode center) {
        this.center = center;
    }

    public TertiaryNode getCenter() {
        return center;
    }
    
    public TertiaryNode(Object data) {
        this.data = data;
    }
    public TertiaryNode getLeft() {
        return left;
    }
    public void setLeft(TertiaryNode left) {
        this.left = left;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public TertiaryNode getRigth() {
        return rigth;
    }
    public void setRigth(TertiaryNode rigth) {
        this.rigth = rigth;
    }  

    public TertiaryNode(TertiaryNode left, Object data, TertiaryNode rigth, TertiaryNode center) {
        this.left = left;
        this.data = data;
        this.rigth = rigth;
        this.center = center;
    }
    
    
      
    
    
}

