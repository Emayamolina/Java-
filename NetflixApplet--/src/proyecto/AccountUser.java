/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

public class AccountUser {
    
    private int code;
    private String titularPerson;
    private String password;
    private String typeC; // basic plus premium 
    private String status;
    private Queue Vc;
    
    
    //get  
    public int getCode() {
        return code;
    }
    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
 
    public String getTitularPerson() {
        return titularPerson;
    }

    public String getTypeC() {
        return typeC;
    }
  
    //SET
    public void setCode(int code) {
        this.code = code;
    }
    public void setPassword(String password) {
        this.password = password;
    }
   
    public void setTitularPerson(String titularPerson) {
        this.titularPerson = titularPerson;
    }

    public void setTypeC(String typeC) {
        this.typeC = typeC;
    }

    public Queue getVc() {
        return Vc;
    }

    public void setVc(Queue Vc) {
        this.Vc = Vc;
    }
   
    //constructor 
    public AccountUser(int code, String titularPerson, String password, String typeC,  Queue Vc) {
        this.code = code;
        this.titularPerson = titularPerson;
        this.password = password;
        this.typeC = typeC;
        this.status = "Active";
        this.Vc = Vc;
    }

    public AccountUser(int code) {
        this.code = code;
    }
    
    //TO STRING
    public String toString() {
        return "AccountUser:" + " the code is:" + code + ", the titular person is:" + titularPerson +
                ", the password is: " + password + ", the type account: " + typeC + ", the status is: " + status + "♡" + '}';
    }
    
}
    
   
    