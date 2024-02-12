package tn.esprit.test;

import tn.esprit.models.Personne;
import tn.esprit.servise.PersonneCrud;
import tn.esprit.utils.MyDataBase;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyDataBase mc =  MyDataBase.getInstance();
        MyDataBase mc1 =  MyDataBase.getInstance();

        System.out.println(mc.hashCode());
        System.out.println(mc1.hashCode());
        PersonneCrud pcd=new PersonneCrud();
        //pcd.add();
        Personne p= new Personne(23,"aziz","jlassi",122);
        //pcd.addPersonne(p);
        Personne p1= new Personne(6,"azipovz2","jlassi2",122);

        System.out.println(pcd.getAll());
        pcd.update(p1);
        System.out.println("******");
        System.out.println(pcd.getAll());
        pcd.delete(64);




    }
}