/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class TertiaryTree {

    private TertiaryNode root;

    public TertiaryTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void Add(Object data, TertiaryNode aux) {
        if (isEmpty()) {
            root = new TertiaryNode(data);
        } else {
            double number = Math.random();
            System.out.println("side " + number);
            if (number < 0.33) 
            {
                if (aux.getLeft() == null) 
                {
                    aux.setLeft(new TertiaryNode(data));
                } else 
                {
                    Add(data, aux.getLeft());
                }
            } else {
                if (number < 0.66) {

                    if (aux.getCenter() == null) {
                        aux.setCenter(new TertiaryNode(data));
                    } else {
                        Add(data, aux.getCenter());
                    }
                } else {
                    if (aux.getRigth() == null) {
                        aux.setRigth(new TertiaryNode(data));
                    } else {
                        Add(data, aux.getRigth());
                    }
                }

            }
        }
    }

    public TertiaryNode getRoot() {
        return root;
    }

    public String PreOrder(TertiaryNode aux) {
        if (aux != null) {
            return aux.getData() + "  " + PreOrder(aux.getLeft()) + PreOrder(aux.getRigth()) + " " + PreOrder(aux.getCenter());
        } 
        else {
            return "";
        }
    }

    public String InOrder(TertiaryNode aux) {
        if (aux != null) {
            return InOrder(aux.getLeft()) + aux.getData() + "  " + InOrder(aux.getRigth()) + aux.getData() + " " + InOrder(aux.getCenter());
        } 
        else {
            return "";
        }
    }

    public String PostOrder(TertiaryNode aux) {
        if (aux != null) {
            return PostOrder(aux.getLeft()) + PostOrder(aux.getRigth()) + PostOrder(aux.getCenter()) + aux.getData();
        } 
        else {
            return "";
        }
    }

    public int Size(TertiaryNode aux) {
        if (aux != null) {
            return Size(aux.getLeft()) + Size(aux.getRigth()) + Size(aux.getCenter()) + 1;  //PostOrder
        } else {
            return 0;
        }
    }

    public boolean Search(int x, TertiaryNode aux) 
    {
        if (aux != null) {
            if (((int) aux.getData()) == x) {
                return true;
            } else {
                return Search(x, aux.getLeft()) || Search(x, aux.getRigth()) || Search(x, aux.getCenter());
            }
        } else {
            return false;
        }
    }

    public int Heigth(TertiaryNode aux) {
        if (aux != null) {
            return 1 + Math.max(Heigth(aux.getLeft()), Heigth(aux.getRigth()));
        } else {
            return 0;
        }
    }

    public TertiaryNode SearchNode(int x, TertiaryNode aux) {
        TertiaryNode res;
        if (aux != null) {
            if ((int) aux.getData() == x) {
                return aux;
            } else {
                res = SearchNode(x, aux.getLeft());
                if (res == null) 
                {
                    res = SearchNode(x, aux.getRigth()); 
                } else {
                    res = SearchNode(x, aux.getCenter());
                }
                return res;
            }
        }
        return null;
    }

    public TertiaryNode getFather(int x, TertiaryNode aux) {
        TertiaryNode father = null;
        if (root != null && (int) root.getData() == x) {
            return null;
        } else {
            if (aux != null) {
                if (aux.getLeft() != null && (int) aux.getLeft().getData() == x
                        || aux.getRigth() != null && (int) aux.getRigth().getData() == x
                        || aux.getCenter() != null && (int) aux.getCenter().getData() == x) {
                    return aux;
                } else {
                    father = getFather(x, aux.getLeft());
                    if (father == null) { 
                        father = getFather(x, aux.getRigth()); 
                    } else if (father == null) {
                        father = getFather(x, aux.getLeft());
                    } else {
                        father = getFather(x, aux.getCenter());
                    }
                }
                return father;
            }
        }
        return null;
    }

    public List Predeccessor(TertiaryNode aux, List prede) {

        if (aux != null) {
            prede.addFirst(aux.getData());
            Predeccessor(getFather((int) aux.getData(), getRoot()), prede);
        }
        return prede;
    }

    public boolean Delete(int x) {
        TertiaryNode delete = SearchNode(x, getRoot());
        if (delete != null) {
            if (delete.getLeft() == null && delete.getRigth() == null || delete.getCenter() == null) {
                return DeleteLeaf(delete);
            } else {
                if (delete.getLeft() == null || delete.getRigth() == null || delete.getCenter() == null) {
                    return DeleteBranch(delete);
                } else {
                    return Delete2Branch(delete);
                }
            }
        }
        return false;
    }

    private boolean DeleteLeaf(TertiaryNode delete) {
        TertiaryNode father = getFather((int) delete.getData(), getRoot());
        if (father == null) {
            root = null;
        } else {
            if (father.getLeft() == delete) {
                father.setLeft(null);
            } else if (father.getRigth() == delete) {
                father.setRigth(root);
            } else {
                father.setCenter(null);
            }
        }
        return true;
    }

    private boolean DeleteBranch(TertiaryNode delete) {
        TertiaryNode father = getFather((int) delete.getData(), getRoot());
        if (father == null) {
            if (delete.getLeft() != null) {
                root = delete.getLeft();
            } else if (delete.getRigth() != null) {
                root = delete.getRigth();
            } else {
                root = delete.getCenter();
            }
        } else {
            if (father.getLeft() == delete) {
                if (delete.getLeft() != null) {
                    father.setLeft(delete.getLeft());
                } else if (delete.getRigth() != null) {
                    father.setLeft(delete.getRigth());
                } else {
                    father.setCenter(delete.getCenter());
                }
            } else {
                if (delete.getLeft() != null) {
                    father.setRigth(delete.getLeft());
                } else if (delete.getRigth() != null) {
                    father.setLeft(delete.getRigth());
                } else {
                    father.setCenter(delete.getRigth());
                }
            }
        }
        return true;
    }

    private boolean Delete2Branch(TertiaryNode delete) {
        int left = MoreLeft(delete);
        Delete(left);
        delete.setData(left);
        return true;
    }

    private int MoreLeft(TertiaryNode aux) {
        if (aux.getLeft() != null) {
            return MoreLeft(aux.getLeft());
        } else {
            return (int) aux.getData();
        }
    }

    private int MoreCenter(TertiaryNode aux) {
        if (aux.getCenter() != null) {
            return MoreCenter(aux.getLeft());
        } else {
            return (int) aux.getData();
        }
    }

     public String pointTree(TertiaryNode aux) {
         if( aux != null){
        if (aux.getLeft() == null || aux.getRigth() == null || aux.getCenter() == null) {
            ((AccountUser) aux.getData()).setStatus(" Active ");
               return ((AccountUser) aux.getData()).getTitularPerson();
        } else {
            return pointTree(aux.getLeft()) + pointTree(aux.getRigth()) + pointTree(aux.getCenter());
        }
    }
         return " ";
     }
 
}
