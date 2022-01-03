/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Netflix {

    //CREACIÓN DE LISTAS
    static ListDouble Account = new ListDouble();
    static ListDouble peliculas = new ListDouble();
    
    //CREACIÓN DE PILAS
    static Stack pilp = new Stack();
    static Stack auxRp = new Stack();

    //CREACIÓN DE COLAS
    static Queue dc = new Queue();
    static Queue Vc = new Queue();
    static Queue auxVc = new Queue();

    //CREACION DE ARBOLES
    static TertiaryTree mami = new TertiaryTree();
    static TertiaryNode mamasita;
    
    //CREACIÓN DE ARCHIVO
    static FileSA fl = new FileSA();
    
    //VARIABLES GLOBALES
    static String type;
    static String title;
    static String gender;
    static double duration;
    static int year;

    public static void main(String[] args) {

        String menu[] = {"Register reproduction", "Show reproduction", "Register account", "Show account",
            "Register profile", "Show profile user", "See playback",
            "Charge account", "Top 10", "Carry out raffle",
            "Delete profile", "Update status", "Others", "Exit"};
        String name, ptm;
        Reproduction f = new Reproduction(type, title, gender, 0, 0);

        do {
            ptm = (String) JOptionPane.showInputDialog(null, "Selected option",
                    "Main menu", 1,
                    null, menu, menu[0]);

            switch (ptm) {
                case "Register reproduction":
                    addFilmSD(Vc);
                    break;
                case "Show reproduction":

                    Object txt = " ";
                    Object pkd = " ";

                    while (!Vc.Empty()) {
                        pkd = Vc.Dequeue();
                        txt += pkd + "\n";
                        auxVc.SaveQueue(pkd);
                    }
                    while (!auxVc.Empty()) {
                        Vc.SaveQueue(auxVc.Dequeue());

                    }
                    JOptionPane.showMessageDialog(null, "The productions are: " + peliculas.toString());
                    break;

                case "Register account":
                    Queue Vc = new Queue();
                    int ie = Integer.parseInt(JOptionPane.showInputDialog("Please enter id:"));
                    String titularPerson = JOptionPane.showInputDialog("Please enter the name of titular person: ");
                    String password = JOptionPane.showInputDialog("Enter the password: ");
                    String typeC = JOptionPane.showInputDialog("Enter the type: basic/plus/premium ");
                    AccountUser newA = new AccountUser(ie, titularPerson, password, typeC, Vc);
                    Account.Add(newA);
                    JOptionPane.showMessageDialog(null, "Saved account");
                    break;

                case "Show account":
                    Account.toString();
                    break;

                case "Register profile":
                    int code = Integer.parseInt(JOptionPane.showInputDialog("Enter code: "));
                    password = JOptionPane.showInputDialog("Enter the password: ");
                    AccountUser ac = Account.validateDates(password, code);

                    if (ac != null) {
                        if (ac.getTypeC().equalsIgnoreCase("Premium: ")) {
                            Queue dc = ac.getVc();
                            if (Size(dc) < 4) {
                                String nameC = JOptionPane.showInputDialog("Enter name of person: ");
                                String lenguage = JOptionPane.showInputDialog(null, "Enter language of account: ");
                                int agec = Integer.parseInt(JOptionPane.showInputDialog("Enter age of: " + nameC));
                                Stack PU = new Stack();
                                ProfileUser a = new ProfileUser(nameC, lenguage, agec, PU);
                                ac.getVc().SaveQueue(a);
                                JOptionPane.showMessageDialog(null, "Created profile: ");
                            } else {
                                JOptionPane.showMessageDialog(null, "The account already exist: ");
                            }
                        }
                        if (ac.getTypeC().equalsIgnoreCase("Basic: ")) {
                            Queue dc = ac.getVc();
                            if (Size(dc) < 2) {
                                String nameC = JOptionPane.showInputDialog("Enter name of person: ");
                                String lenguage = JOptionPane.showInputDialog(null, "Enter language of account: ");
                                int agec = Integer.parseInt(JOptionPane.showInputDialog("Enter age of: " + nameC));
                                Stack PU = new Stack();
                                ProfileUser a = new ProfileUser(nameC, lenguage, agec, PU);
                                ac.getVc().SaveQueue(a);
                                JOptionPane.showMessageDialog(null, "Created profile");
                            } else {
                                JOptionPane.showMessageDialog(null, "The account already exist");
                            }
                        }
                        if (ac.getTypeC().equalsIgnoreCase("Plus")) {
                            Queue dc = ac.getVc();
                            if (Size(dc) < 3) {
                                String nameC = JOptionPane.showInputDialog("Enter name of person: ");
                                String lenguage = JOptionPane.showInputDialog(null, "Enter language of account: ");
                                int agec = Integer.parseInt(JOptionPane.showInputDialog("Enter age of: " + nameC));
                                Stack PU = new Stack();
                                ProfileUser a = new ProfileUser(nameC, lenguage, agec, PU);
                                ac.getVc().SaveQueue(a);
                                JOptionPane.showMessageDialog(null, "Created profile");
                            } else {
                                JOptionPane.showMessageDialog(null, "The account already exist");
                            }
                        }
                    }
                    break;

                case "Show profile user":
                    code = Integer.parseInt(JOptionPane.showInputDialog("Enter code: "));
                    password = JOptionPane.showInputDialog("Enter the password: ");
                    ac = Account.validateDates(password, code);
                    if (ac != null) {
                        String nameC = JOptionPane.showInputDialog("Enter name of person: ");
                        dc = ac.getVc();
                        JOptionPane.showMessageDialog(null, PrintC(dc));

                    }

                    break;

                case "See playback":
                    code = Integer.parseInt(JOptionPane.showInputDialog("Enter code: "));
                    password = JOptionPane.showInputDialog("Enter the password: ");
                    ac = Account.validateDates(password, code);

                    if (ac != null & ac.getStatus().equalsIgnoreCase("Active")) {
                        String nameC = JOptionPane.showInputDialog("Enter name of person: ");
                        String title = JOptionPane.showInputDialog("Enter the name film: ");
                        dc = ac.getVc();
                        while (!dc.Empty()) {
                            ProfileUser ps = (ProfileUser) dc.Dequeue();
                            if (ps.getNameC().equalsIgnoreCase(nameC)) {

                                Reproduction nombre = peliculas.Search(title);
                                ps.getPU().Push(nombre);

                            }
                            auxVc.SaveQueue(ps);
                        }
                        while (!auxVc.Empty()) {
                            dc.SaveQueue(auxVc.Dequeue());
                        }
                        JOptionPane.showMessageDialog(null, PrintC(dc));
                    }

                    break;

                case "Charge account":
                    //punto de ARCHIVOS
                    fl.EscribirLista(Account, peliculas);
                    //sacar los datos de la lista 
                    break;

                case "Top 10": //de reps más vistas CON EL METODO DE CUANTAS SERIE PELICULAS DEMÁS
                    Account.top10FilmsMoreSee(peliculas, Account);

                    break;

                case "Carry out raffle"://arbol
                    mami.Add(Account, mamasita);
                    mami.pointTree(mami.getRoot());
                    JOptionPane.showMessageDialog(null, "The accounts is: " + mami.InOrder(mami.getRoot()));
                    JOptionPane.showMessageDialog(null, "The accounts is: " + mami.PostOrder(mami.getRoot()));
                    JOptionPane.showMessageDialog(null, "The accounts is: " + mami.PreOrder(mami.getRoot()));

                    break;

                case "Delete profile":
                    auxVc = new Queue();
                    //metodo borrar de la cola seleccionando el que se quiere eliminar 
                    code = Integer.parseInt(JOptionPane.showInputDialog("Enter code: "));
                    password = JOptionPane.showInputDialog("Enter the password: ");
                    ac = Account.validateDates(password, code);
                    if (ac != null) {
                        String nameC = JOptionPane.showInputDialog("Enter name of person: ");

                        Queue dc = ac.getVc();
                        while (!dc.Empty()) {
                            ProfileUser PU = (ProfileUser) dc.Dequeue();
                            if (!PU.getNameC().equals(nameC)) {
                                auxVc.SaveQueue(PU);
                            }
                        }
                        while (!auxVc.Empty()) {
                            dc.SaveQueue(auxVc.Dequeue());
                        }

                        JOptionPane.showMessageDialog(null, PrintC(dc));

                    }

                    break;

                case "Update status":
                    JOptionPane.showMessageDialog(null, "Status");
                    Account.randomStatus();
                    JOptionPane.showMessageDialog(null, "Update");

                    break;

                case "Others":
                    String oth;
                    String abcde[] = {"ae", "b", "c", "d", "e", "Exit"};
                    do {
                        oth = (String) JOptionPane.showInputDialog(null, "Selected option",
                                "Main menu", 1,
                                null, abcde, abcde[0]);

                        switch (oth) {

                            case "ae":
                                JOptionPane.showMessageDialog(null, Account.AccountSt());

                                break;
                            case "b":
                                JOptionPane.showMessageDialog(null, Account.percentage());

                                //metodo de porcentaje de cuentas 
                                break;
                            case "c":
                                JOptionPane.showMessageDialog(null, Account.moneyAccountPays());

                                //dinero cuentas pagas
                                break;
                            case "d":

                                JOptionPane.showMessageDialog(null, " a ");

                                //perfiles que faltan
                                break;
                            case "e":
                                code = Integer.parseInt(JOptionPane.showInputDialog("Enter code"));
                                password = JOptionPane.showInputDialog("Enter the password");
                                AccountUser adc = Account.validateDates(password, code);

                                if (adc != null) {
                                    String nameC = JOptionPane.showInputDialog("Enter name of person");
                                    Queue dc = adc.getVc();
                                    while (!dc.Empty()) {
                                        ProfileUser PU = (ProfileUser) dc.Dequeue();
                                        if (!PU.getNameC().equalsIgnoreCase(nameC)) {
                                            Account.miguellS();

                                            auxVc.SaveQueue(PU);
                                        }
                                    }
                                }

                                //determinar uso de la cuenta
                                break;
                                
                                

                        }
                    } while (!oth.equals("Exit"));

                    break;

            }
        } while (!ptm.equals("Exit"));

    } //CREACION DE METODOS

    public static void addFilmSD(Queue Vc) {

        type = JOptionPane.showInputDialog("Enter the type of reproduction: ");
        title = JOptionPane.showInputDialog("Enter the title of reproduction: ");
        gender = JOptionPane.showInputDialog("Enter the gender of reproduction: ");
        duration = Double.parseDouble(JOptionPane.showInputDialog("Enter the duration of reproduction in minutes: " ));
        year = Integer.parseInt(JOptionPane.showInputDialog("Enter the year of reproduction: "));
        JOptionPane.showMessageDialog(null, "Registered reproduction: ");
        Reproduction film = new Reproduction(type, title, gender, duration, year);
        peliculas.AddLast(film);

    }

    public static int Size(Queue q) {
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

    public static Object PrintC(Queue Vc) {
        Object txt = "";
        Object pkd = "";

        while (!Vc.Empty()) {
            pkd = Vc.Dequeue();
            txt += pkd + "\n";
            auxVc.SaveQueue(pkd);
        }
        while (!auxVc.Empty()) {
            Vc.SaveQueue(auxVc.Dequeue());
        }
        return txt;
    }

    public int priceAccount(AccountUser p) {
        int B = 21900, PL = 31900, PR = 38900;
        if (p.getTypeC().equalsIgnoreCase("Basic")) {//basic
            return B;
        } else if (p.getTypeC().equalsIgnoreCase("Plus")) {//plus
            return PL;
        } else { //premium
            return PR;
        }
    }

    //metodo random 
    //FIN///////////////////////////////////////
    //FIN //////////////////////
}
