package com.murex.retail.experience.database;

import com.murex.retail.experience.computercomponent.ComputerComponent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

public class ComputerComponentDAO {
    private static final Logger LOGGER = LogManager.getLogger(ComputerComponentDAO.class);
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("entityManagerPersistence");
    static EntityManager ef = emf.createEntityManager();

    public void insert(List<ComputerComponent> computerComponentList) {
        for (ComputerComponent x : computerComponentList) {
            ef.getTransaction().begin();
            ef.persist(x);
            ef.getTransaction().commit();
        }
    }

    public List<ComputerComponent> readAll() {
        List<ComputerComponent> returnedList;
        returnedList = ef.createQuery("select a from AbstractComputerComponent a").getResultList();
        return returnedList;
    }
}

