package br.com.unifacol.dizimo.model.interfaceRepository;

import br.com.unifacol.dizimo.model.entidades.DadosPessoais;
import jakarta.persistence.TypedQuery;

import java.sql.SQLException;
import java.util.List;

public interface IRepositoryDadosPessoais {
    void cadastrar(DadosPessoais dadosPessoais) throws SQLException;
    void alterar(DadosPessoais dadosPessoais) throws SQLException;
    void excluir(Long id) throws SQLException;
    List<DadosPessoais> listarDadosPessoais() throws SQLException;
    List<DadosPessoais> listarPorID(Long id) throws SQLException;
    List<DadosPessoais> listarPorCPF(String cpf) throws SQLException;

}
