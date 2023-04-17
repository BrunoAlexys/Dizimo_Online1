package br.com.unifacol.dizimo.model.repository;

import br.com.unifacol.dizimo.model.entidades.Membro;
import br.com.unifacol.dizimo.model.interfaceRepository.IRepositoryMembro;
import jakarta.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

public class MembroRepository implements IRepositoryMembro {

    private EntityManager manager;

    public MembroRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void cadastrarMembro(Membro membro) throws SQLException {
        this.manager.persist(membro);
    }

    @Override
    public void alterarMembro(Membro membro) throws SQLException {
        this.manager.merge(membro);
    }

    @Override
    public void excluirMembro(Long id) throws SQLException {
        Membro membro = manager.find(Membro.class, id);
        if (membro != null) {
            manager.remove(membro);
            }
        }

        @Override
        public List<Membro> listarMembros () throws SQLException {
            String jpql = "SELECT m FROM Membro m";
            return manager.createQuery(jpql, Membro.class).getResultList();
        }

        @Override
        public List<Membro> listarPorID (Long id) throws SQLException {
            String jqpl = "SELECT m FROM Membro m WHERE m.id = :id";
            return manager.createQuery(jqpl,Membro.class).setParameter("id",id).getResultList();
        }

        @Override
        public List<Membro> listarPorCPF (String cpf) throws SQLException {
            String jqpl = "SELECT m FROM Membro m WHERE m.dadosPessoais.cpf = :cpf";
            return (List<Membro>) manager.createQuery(jqpl,Membro.class).setParameter("cpf",cpf);
        }
    }

