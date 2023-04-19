package br.com.unifacol.dizimo.model.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("dizimo_online");
        } catch (Throwable ex) {
            System.err.println("Erro ao inicializar EntityManagerFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void closeEntityManagerFactory() {
        emf.close();
    }

}

