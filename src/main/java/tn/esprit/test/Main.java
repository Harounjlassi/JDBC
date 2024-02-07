package tn.esprit.test;

import tn.esprit.utils.MyDataBase;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyDataBase mc =  MyDataBase.getInstance();
        MyDataBase mc1 =  MyDataBase.getInstance();

        System.out.println(mc.hashCode());
        System.out.println(mc1.hashCode());

    }
}