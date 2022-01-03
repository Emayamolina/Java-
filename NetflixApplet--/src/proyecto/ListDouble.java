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
public class ListDouble {

    Queue Vc = new Queue();
    Stack PU = new Stack();

    private NodeDouble First;
    private NodeDouble Last;

//get 
    public NodeDouble getFirst() {
        return First;
    }

    public NodeDouble getLast() {
        return Last;
    }

    public Stack getPU() {
        return PU;
    }

    public Queue getVc() {
        return Vc;
    }

    //set
    public void setFirst(NodeDouble First) {
        this.First = First;
    }

    public void setLast(NodeDouble Last) {
        this.Last = Last;
    }

    public void setPU(Stack PU) {
        this.PU = PU;
    }

    public void setVc(Queue Vc) {
        this.Vc = Vc;
    }

    public ListDouble() {
    }

    public boolean ListEmpty() {
        return First == null && Last == null;
    }

    public void AddFirst(Object data) {
        if (ListEmpty()) {
            First = new NodeDouble(data);
            Last = First;
        } else {
            NodeDouble nn = new NodeDouble(data);
            First.setPreviuos(nn);
            nn.setPreviuos(First);
            First = nn;
        }
    }

    public void AddLast(Object data) {
        if (ListEmpty()) {
            AddFirst(data);
        } else {
            NodeDouble nn = new NodeDouble(data);
            Last.setNext(nn);
            nn.setPreviuos(Last);
            Last = nn;
        }

    }

    public int Size() {
        int cont = 0;
        NodeDouble aux = Last;
        while (aux != null) {
            cont++;
            aux = aux.getPreviuos();
        }
        return cont;
    }

    public String toString() {
        String txt = " ";
        NodeDouble aux = First;
        while (aux != null) {
            txt = txt + aux.getData() + " \n";
            JOptionPane.showMessageDialog(null, aux.getData());
            aux = aux.getNext();
        }
        return txt;
    }

    public void AddM(Object data, int pos) {
        if (pos == 1) {
            AddFirst(data);
        } else {
            if (pos == Size() + 1) {
                AddLast(data);
            } else {
                NodeDouble aux = First;
                int cont = 1;

                while (aux != null && cont < pos) {
                    aux = aux.getNext();
                    cont++;
                }
                NodeDouble n = new NodeDouble(data);
                n.setNext(aux);
                n.setPreviuos(aux.getPreviuos());
                aux.getPreviuos().setNext(n);
                aux.setPreviuos(n);
            }
        }
    }

    public void Add(Object data) {
        NodeDouble aux = First;
        while (aux != null) {
            System.out.println(aux.getData());
            aux = aux.getNext();
        }

        if (aux != null) {
            if (aux.getPreviuos() != null) {

                NodeDouble n = new NodeDouble(data);
                n.setNext(aux);
                n.setPreviuos(aux.getPreviuos());
                aux.getPreviuos().setNext(n);
                aux.setPreviuos(n);
            } else {
                AddFirst(data);
            }
        } else {
            AddLast(data);
        }

    }

    public boolean RemoverFirst() {
        if (!ListEmpty()) {
            First = First.getNext();
            if (First == null) {
                Last = null;
            } else {
                First.setPreviuos(null);
            }
            return true;
        }
        return false;
    }

    public boolean RemoveLast() {
        if (!ListEmpty()) {
            Last = Last.getPreviuos();
            if (Last == null) {
                First = null;
            } else {
                Last.setNext(null);
            }
            return true;
        }
        return false;
    }

    public boolean Remove(int pos) {
        if (!ListEmpty()) {
            if (pos == 1) {
                RemoverFirst();
            } else {
                if (pos == Size()) {
                    RemoveLast();
                } else {
                    int cont = 1;
                    NodeDouble aux = First;
                    while (cont < pos) {
                        aux = aux.getNext();
                        cont++;
                    }
                    aux.getPreviuos().setNext(aux.getNext());
                    aux.getNext().setPreviuos(aux.getPreviuos());
                }
            }
            return true;
        }

        return false;
    }

    public boolean Remove(String name) {
        NodeDouble aux = First;
        while (aux != null && !((String) aux.getData()).equalsIgnoreCase(name)) {
            aux = aux.getNext();
        }

        if (aux != null) {
            if (aux.getPreviuos() == null) {
                RemoverFirst();
            } else {
                if (aux.getNext() == null) {
                    RemoveLast();
                } else {
                    aux.getPreviuos().setNext(aux.getNext());
                    aux.getNext().setPreviuos(aux.getPreviuos());
                }
            }
            return true;
        }
        return false;
    }

    public String showTop10() {
        String txt = " ";
        NodeDouble aux = Last;
        Reproduction almr = null;
        int contTOP = 0;
        while (aux != null) {
            if (contTOP <= 10) {
                contTOP++;
                almr = (Reproduction) aux.getData();
                txt += contTOP + " The title is: " + almr.getTitle() + " the type is: " + almr.getType() + "\n";
                JOptionPane.showMessageDialog(null, "This is top 10: ");
            }
            aux = aux.getPreviuos();
        }
        return txt;
    }

    public AccountUser validateDates(String password, int code) {
        NodeDouble aux = First;
        while (aux != null) {
            if (((AccountUser) aux.getData()).getPassword().equals(password) && ((AccountUser) aux.getData()).getCode() == code) {
                return (AccountUser) aux.getData();
            }
            aux = aux.getNext();
        }
        return null;
    }

    public Reproduction Search(String title) {
        String ms = " ";
        NodeDouble aux = First;
        while (aux != null) {
            if (((Reproduction) aux.getData()).getTitle().equalsIgnoreCase(title)) {
                return (Reproduction) aux.getData();
            }
            aux = aux.getNext();
        }
        return null;
    }

    public static int SizeQ(Queue q) {
        int size = 0;
        Queue aux = new Queue();
        while (!q.Empty()) {
            aux.SaveQueue(q.Dequeue());
            size++;
        }
        while (!aux.Empty()) {
            q.SaveQueue(aux.Dequeue());
        }
        return size;
    }

    public void cantidadper() {
        NodeDouble aux = First;
        String m = " ";

        while (aux != null) {
            Queue x = ((AccountUser) aux.getData()).getVc();
            String typeprofile = ((AccountUser) aux.getData()).getTypeC();
            if (typeprofile.equalsIgnoreCase("Basic") || SizeQ(x) < 2) {
                m = m + "The user is " + ((AccountUser) aux.getData()).getTitularPerson() + " have " + (2 - SizeQ(x));
            } else if (typeprofile.equalsIgnoreCase("Plus") || SizeQ(x) < 3) {
                m = m + "The user is " + ((AccountUser) aux.getData()).getTitularPerson() + " have " + (3 - SizeQ(x));
            } else {
                m = m + "The user is " + ((AccountUser) aux.getData()).getTitularPerson() + " have " + (4 - SizeQ(x));

            }
        }
    }

    public static void top10FilmsMoreSee(ListDouble peliculas, ListDouble accountsusers) {

        int acum = 0;
        int acum2 = 0;
        String txt = " ";

        NodeDouble nd1 = peliculas.getLast();
        NodeDouble nd2 = accountsusers.getLast();
        ListDouble ld1 = new ListDouble();

        Queue qu1 = new Queue();
        Stack st1 = new Stack();
        AccountUser acu1 = null;

        ProfileUser pu1 = null;
        Reproduction rp1 = null;
        Reproduction rp2 = null;

        while (nd1 != null) {
            rp2 = (Reproduction) nd1.getData();
            nd2 = accountsusers.getLast();
            acum = 0;
            acum2 = 0;
            while (nd2 != null) {
                acu1 = (AccountUser) nd2.getData();
                while (!acu1.getVc().Empty()) {
                    pu1 = (ProfileUser) acu1.getVc().Dequeue();
                    if (pu1 != null) {
                        while (!pu1.getPU().isEmpty()) {
                            rp1 = (Reproduction) pu1.getPU().Pop();
                            if (rp2.getTitle().equalsIgnoreCase(rp1.getTitle())) {
                                acum++;
                                acum2 = 1;
                            }
                            st1.Push(rp1);
                        }
                    }
                    while (!st1.isEmpty()) {
                        pu1.getPU().Push(st1.Pop());
                    }
                    qu1.SaveQueue(pu1);
                }
                while (!qu1.Empty()) {
                    acu1.getVc().SaveQueue(qu1.Dequeue());
                }
                nd2 = nd2.getPreviuos();
            }
            if (acum2 == 1) {
                rp2.setSee(acum);
                ld1.AddFirst(rp2);

            }

            nd1 = nd1.getPreviuos();
        }
        organize(ld1);
        JOptionPane.showMessageDialog(null, "The top 10 is: " + ld1.showTop10());
    }

    public static void organize(ListDouble top10) {
        Reproduction rp1;
        Reproduction rp2;
        Reproduction ax;
        /////------------////
        NodeDouble aux1 = top10.getLast();
        NodeDouble aux2 = top10.getLast();
        while (aux1 != null) {
            rp1 = (Reproduction) aux1.getData();
            aux2 = aux1.getPreviuos();
            while (aux2 != null) {
                rp2 = (Reproduction) aux2.getData();
                if (rp1.getSee() > rp2.getSee()) {
                    ax = rp2;
                    aux2.setData(rp1);
                    aux1.setData(ax);
                }
                aux2 = aux2.getPreviuos();
            }
            aux1 = aux1.getPreviuos();
        }

    }

    public AccountUser AccountSt() {

        NodeDouble aux = Last;
        AccountUser m = null;
        String accountsSI = "";
        while (aux != null) {

            m = (AccountUser) aux.getData();
            if (m.getStatus().equalsIgnoreCase("Suspended") || m.getStatus().equalsIgnoreCase("Inactive")) {
                accountsSI += accountsSI + " - " + aux.getData();

            }
            aux = aux.getPreviuos();

        }
        return m;

    }

    public double moneyAccountPays() {

        //CORREGIR ORTOGRAFIA
        NodeDouble aux = Last;
        AccountUser p = null;
        double pay = 0;

        while (aux != null) {
            p = (AccountUser) aux.getData();
            if (p.getStatus().equalsIgnoreCase("Active")) {
                if (p.getTypeC().equalsIgnoreCase("Basic")) {
                    pay += 21900;
                } else if (p.getTypeC().equalsIgnoreCase("Plus")) {
                    pay += 31900;
                } else {
                    pay = 38900;
                }
            }
            aux = aux.getPreviuos();
        }
        return pay;
    }

    public int AccountPercent(String type) {
        NodeDouble aux = Last;
        AccountUser a = null;
        int con = 0;
        while (aux != null) {
            a = (AccountUser) aux.getData();
            if (a.getTypeC().equalsIgnoreCase(type)) {
                con++;
            }
            aux = aux.getPreviuos();
        }
        return con;
    }

    public String percentage() {
        String percent = "";
        percent += ("The basic account percentage is " + AccountPercent("Basic") / Size()
                + "The plus account percentage is" + AccountPercent("Plus") / Size()
                + "The premium account percentage is" + AccountPercent("Premium") / Size());
        return percent;
    }

    public int AccountPercentage(String type) {
        NodeDouble aux = Last;
        AccountUser a = null;
        int con = 0;
        while (aux != null) {
            a = (AccountUser) aux.getData();
            if (a.getTypeC().equalsIgnoreCase(type)) {
                con++;
            }
            aux = aux.getPreviuos();
        }
        return con;
    }

    public int miguellS() {

        int s = 0, p = 0, o = 0;
        Reproduction rpu;

        NodeDouble aux = Last;
        Reproduction ap = null;

        while (aux != null) {

            ap = (Reproduction) aux.getData();
            if (ap.getType().equalsIgnoreCase("Movie")) {
                p++;
                if (p <= 10) {
                    JOptionPane.showMessageDialog(null, "The use is lower");
                }
            } else if (ap.getType().equalsIgnoreCase("serie")) {
                if (s > 11 || s <= 50) {
                    JOptionPane.showMessageDialog(null, "The use is medium");
                }
                s++;
            } else {
                JOptionPane.showMessageDialog(null, "The use is high");
                o++;
            }

            JOptionPane.showMessageDialog(null, "The use is that");
            aux = aux.getPreviuos();

        }
        return 0;
    }

    public void randomStatus() {
        NodeDouble aux = Last;
        AccountUser p = null;

        while (aux != null) {
            p = (AccountUser) aux.getData();
            int st = (int) (Math.random() * 3 + 1);
            if (st == 1) {
                p.setStatus("Suspended");//SET DE STATUS  SUSPENDIDO
            }
            if (st == 2) {
                p.setStatus("Inactive");//SET DE STATUS INACTIVA
            }
            if (st == 3) {
                p.setStatus("Active");
            }
            aux = aux.getPreviuos();
        }

    }

    public int[] accountFSO(AccountUser ac, ListDouble Re) {
        int cPSO[] = {0, 0, 0};
        /*llamar todos los perfiles de la cuenta*/
        Queue auxi = new Queue();
        Stack auxP = new Stack();
        ProfileUser pfu;
        Reproduction rpu;
        String peli = "";
        NodeDouble aux = Last;
        Reproduction p = null;
        //sacar de cuenta perfil reproducciones

        //1 c
        //2 p
        //3 r
        Vc = ac.getVc();

        while (!Vc.Empty()) {
            ProfileUser pr = (ProfileUser) Vc.Dequeue();
            PU = pr.getPU();
            while (!PU.isEmpty()) {
                p = (Reproduction) PU.Pop();
                if (p.getType().equalsIgnoreCase("Movie")) {
                    cPSO[0]++;
                } else if (p.getType().equalsIgnoreCase("Serie")) {
                    cPSO[1]++;
                } else {
                    JOptionPane.showMessageDialog(null, "Is other type: ");
                    cPSO[2]++;
                }
                auxP.Push(peli);
            }
            while (!auxP.isEmpty()) {
                PU.Push(auxP.Pop());

            }
            auxi.SaveQueue(pr);
        }
        while (!auxi.Empty()) {
            Vc.SaveQueue(auxi.Dequeue());
        }
        return cPSO;
    }


}
