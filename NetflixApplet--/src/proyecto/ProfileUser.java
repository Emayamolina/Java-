/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

public class ProfileUser {

    private String nameC;
    private String lenguage;
    private int age; //Configuración por edad
    private Stack PU;

    //get
    public Stack getPU() {
        return PU;
    }

    public int getAge() {
        return age;
    }

    public String getLenguage() {
        return lenguage;
    }

    public String getNameC() {
        return nameC;
    }

    //set
    public void setAge(int age) {
        this.age = age;
    }

    public void setLenguage(String lenguage) {
        this.lenguage = lenguage;
    }

    public void setNameC(String nameC) {
        this.nameC = nameC;
    }

    public void setPU(Stack PU) {
        this.PU = PU;
    }

    //CONSTRUCTOR 
    public ProfileUser(String nameC, String lenguage, int age, Stack PU) {
        this.nameC = nameC;
        this.lenguage = lenguage;
        this.age = age;
        this.PU = PU;
    }

    //TOSTRING
    public String toString() {
        String text = "";
        Stack aux = new Stack();
        Reproduction number;
        while (!PU.isEmpty()) {
            number = (Reproduction) PU.Pop();
            text = text + number + "\n";
            aux.Push(number);
        }
        while (!aux.isEmpty()) {
            PU.Push(aux.Pop());
        }
        return "ProfileUser: " + "the name is: " + nameC + ", the name lenguage: " +
                lenguage + ", the age: " + age + ", The reproduccions is: " + text + '|';
    }
    
    //-------------1-------------------------1-----------------------1--------------------------1
}
