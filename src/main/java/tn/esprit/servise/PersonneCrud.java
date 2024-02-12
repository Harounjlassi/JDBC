package tn.esprit.servise;


import tn.esprit.IServices.IService;
import tn.esprit.models.Personne;
import tn.esprit.utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonneCrud implements IService<Personne,Integer> {
    Connection cnx2;
    public PersonneCrud(){
        cnx2= MyDataBase.getInstance().getCnx();

    }
    // ajouer un personne en utilisant une requete static
    @Override
    public void add() {
        try {
            String req = "INSERT INTO personne (nom,prenom,age) VALUES ('haroun','jlassi',23)";
            Statement st = cnx2.createStatement();
            st.executeUpdate(req);

            System.out.println("Personne ajoute avec succes");


        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }


    }
    // ajouer un personne en utilisant une requete dynamique
    @Override
    public void addPersonne(Personne personne) {
        try {
            String req = "INSERT INTO personne (nom,prenom,age) VALUES (?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(req);
            pst.setString(1,personne.getNom());
            pst.setString(2,personne.getPrenom());
            pst.setInt(3,personne.getAge());
            pst.executeUpdate();
            System.out.println("Personne ajoute avec succes");


        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }


    }

    @Override
    public void delete(Integer id) {
        try {
            String req = "DELETE FROM `personne` WHERE id = " + id;
            Statement st = cnx2.createStatement();
            if(st.executeUpdate(req)>0){
                System.out.println("Personne deleted successfully!");
            } else {
                System.out.println("No Personne deleted!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void update(Personne p ) {
        try {
            String req = "UPDATE `personne` SET `nom` = '" + p.getNom() + "', `prenom` = '" + p.getPrenom() +
                     "', `age` = '" + p.getAge() +"' WHERE `personne`.`id` = " + p.getId();
            Statement st = cnx2.createStatement();
            if(st.executeUpdate(req)>0){
                System.out.println("Personne updated successfully!");
            } else {
                System.out.println("No Personne updated!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<Personne> getAll() {
        List<Personne> myList = new ArrayList<>();

        try{
        String req= "SELECT  * FROM personne";
        Statement st= cnx2.createStatement();
        ResultSet rs=st.executeQuery(req);
        while(rs.next()){
            Personne p=new Personne();
            p.setId(rs.getInt(1));
            p.setNom(rs.getString("nom"));
            p.setPrenom(rs.getString("prenom"));
            p.setAge(rs.getInt("age"));
            myList.add(p);

        }


    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }
        return myList;
    }

    @Override
    public void getById() {

    }

}
