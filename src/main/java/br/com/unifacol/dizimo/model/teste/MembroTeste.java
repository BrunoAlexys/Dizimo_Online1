package br.com.unifacol.dizimo.model.teste;

import br.com.unifacol.dizimo.model.repository.MembroRepository;
import br.com.unifacol.dizimo.model.service.MembroService;
import br.com.unifacol.dizimo.model.util.JPAUtil;


import javax.persistence.EntityManager;
import java.sql.SQLException;


public class MembroTeste {
    public static void main(String[] args) throws SQLException {
        EntityManager manager = JPAUtil.getEntityManager();
        MembroRepository membroRepository = new MembroRepository(manager);
        MembroService membroService = new MembroService(membroRepository);
        membroService.cadastrar();

    }
}
