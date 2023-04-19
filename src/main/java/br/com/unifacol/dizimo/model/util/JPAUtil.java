package br.com.unifacol.dizimo.model.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory FACTORY = Persistence
            .createEntityManagerFactory("dizimo_online");

    public static EntityManager getManager (){
        return FACTORY.createEntityManager();
    }
}
