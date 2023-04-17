package br.com.unifacol.dizimo.model.repository;

import br.com.unifacol.dizimo.model.entidades.DadosPessoais;
import br.com.unifacol.dizimo.model.interfaceRepository.IRepositoryDadosPessoais;
import jakarta.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

public class DadosPessoaisRepository implements IRepositoryDadosPessoais {

    private EntityManager manager;

    public DadosPessoaisRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void cadastrar(DadosPessoais dadosPessoais) throws SQLException {
        this.manager.persist(dadosPessoais);
    }

    @Override
    public void alterar(DadosPessoais dadosPessoais) throws SQLException {
        this.manager.merge(dadosPessoais);
    }

    @Override
    public void excluir(Long id) throws SQLException {
        DadosPessoais dadosPessoais = manager.find(DadosPessoais.class, id);
        if (dadosPessoais != null) {
            manager.remove(dadosPessoais);
        }
    }

    @Override
    public List<DadosPessoais> listarDadosPessoais() throws SQLException {
        String jqpl = "SELECT d FROM DadosPessoais d";
        return manager.createQuery(jqpl,DadosPessoais.class).getResultList();
    }

    @Override
    public List<DadosPessoais> listarPorID(Long id) throws SQLException {
        String jqpl = "SELECT d FROM DadosPessoais d WHERE d.id = :id";
        return manager.createQuery(jqpl,DadosPessoais.class).setParameter("id",id).getResultList();
    }

    @Override
    public List<DadosPessoais> listarPorCPF(String cpf) throws SQLException {
        String jqpl = "SELECT d FROM DadosPessoais d WHERE d.cpf = :cpf ";
        return (List<DadosPessoais>) manager.createQuery(jqpl,DadosPessoais.class).setParameter("cpf",cpf);
    }
}
