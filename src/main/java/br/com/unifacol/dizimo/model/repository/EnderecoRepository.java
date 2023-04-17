package br.com.unifacol.dizimo.model.repository;

import br.com.unifacol.dizimo.model.entidades.Endereco;
import br.com.unifacol.dizimo.model.interfaceRepository.IRepositoryEndereco;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.sql.SQLException;
import java.util.List;

public class EnderecoRepository implements IRepositoryEndereco {

    private EntityManager manager;

    public EnderecoRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void cadastrar(Endereco endereco) throws SQLException {
        EntityTransaction transaction = manager.getTransaction();
        try{
            transaction.begin();
            manager.persist(endereco);
            transaction.commit();
        }catch (Exception e){
            if (transaction.isActive()){
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao cadastrar: " + e);
        }
    }

    @Override
    public Endereco alterar(Endereco endereco) throws SQLException {
        Endereco endereco1 = manager.find(Endereco.class,endereco.getId());
        if (endereco1 == null) {
            return null;
        }

        endereco1.setRua(endereco.getRua());
        endereco1.setNumero(endereco.getNumero());
        endereco1.setBairro(endereco.getBairro());
        endereco1.setBairro(endereco.getBairro());
        endereco1.setCidade(endereco.getCidade());
        endereco1.setEstado(endereco.getEstado());

        return manager.merge(endereco1);

    }

    @Override
    public void excluir(Long id) throws SQLException {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            Endereco endereco = manager.find(Endereco.class,id);
            manager.remove(endereco);
            transaction.commit();
        }catch (Exception e){
            if (transaction.isActive()){
                transaction.rollback();
            }
            throw new RuntimeException("Erro: " + e);
        }
    }

    @Override
    public List<Endereco> listarEndereco() throws SQLException {
        String jqpl = "SELECT e FROM Endereco e";
        return manager.createQuery(jqpl,Endereco.class).getResultList();
    }

    @Override
    public List<Endereco> listarPorId(Long id) throws SQLException {
        String jqpl = "SELECT e FROM Endereco e WHERE e.id = :id";
        return manager.createQuery(jqpl,Endereco.class).setParameter("id",id).getResultList();
    }
}
