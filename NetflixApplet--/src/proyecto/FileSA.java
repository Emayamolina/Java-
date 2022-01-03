/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class FileSA {

    static ListDouble Account = new ListDouble();
    static Netflix s = new Netflix();

    private File f;
    private FileReader fr;
    private FileWriter fw;
    private BufferedReader br;
    private BufferedWriter bw;

    public void EscribirVector(Object v[], String ruta) {

        f = new File(ruta);
        try {
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);
            //paso 4
            for (int i = 0; i < v.length; i++) {
                if (v[i] != null) {
                    AccountUser p = (AccountUser) v[i];
                    bw.write(p.getTitularPerson() + "\n");//los demás
                }
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public AccountUser[] LeerVector(String ruta) {
        String registro, campos[];
        AccountUser p[] = new AccountUser[Cantidad(ruta) + 5];
        int pos = 0;
        //paso 1
        f = new File(ruta);
        try {
            fr = new FileReader(f);   //paso 2
            br = new BufferedReader(fr);  //paso 3
            //paso 4
            while ((registro = br.readLine()) != null) {
                campos = registro.split(" ");
                p[pos] = new AccountUser(Integer.parseInt(campos[0]),campos[1], campos[2], campos[3], new Queue());

                pos++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }
    
    public int Cantidad(String ruta) {
        int pos = 0;
        //paso 1
        f = new File(ruta);
        try {
            fr = new FileReader(f);   //paso 2
            br = new BufferedReader(fr);  //paso 3
            //paso 4
            while ((br.readLine()) != null) {
                pos++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pos;
    }

    public List LeerLista(String ruta) {
        List list = new List();
        String registro, campos[];

        f = new File(ruta);
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            while ((registro = br.readLine()) != null) {
                campos = registro.split(" ");
                list.addLast(new AccountUser(Integer.parseInt(campos[0]),
                        campos[1],
                        (campos[2]),
                        campos[3],
                        new Queue()
                ));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void EscribirLista(ListDouble lista,ListDouble Re) {
        //paso 1

        try {

            //paso 4
            NodeDouble aux = lista.getFirst();
            while (aux != null) {
                AccountUser p = (AccountUser) aux.getData();
                f = new File(p.getTitularPerson() + ".txt");
                fw = new FileWriter(f); //paso 2            
                bw = new BufferedWriter(fw); 
                int cPSO[] = Account.accountFSO(p,Re);

                bw.write("Sr: " + p.getTitularPerson() + " you have enjoyned " + cPSO[0] + " movies "
                        + cPSO[1] + " series " + cPSO[2] + " others " + " don't forget to pay " + s.priceAccount(p));

                /*
                Ya devuelve los 3 contadores
                
                corregir el metodo
                 */
                aux = aux.getNext();
                bw.close();
            }
//            bw.close();  //paso 5
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//          -_______________-_________________-________________-____________________-
}