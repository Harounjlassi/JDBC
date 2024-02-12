package tn.esprit.IServices;

import java.util.List;

// we can add the CRUD operations here
public interface IService<T,I > {
    public void add();
    public void addPersonne(T T);
    public void delete(I I);
    public void update(T T);
    public List<T> getAll();
    public void getById();






}
