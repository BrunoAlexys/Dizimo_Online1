package br.com.unifacol.dizimo.model.interfaceRepository;

import br.com.unifacol.dizimo.model.entidades.Endereco;

import java.sql.SQLException;
import java.util.List;

public interface IRepositoryEndereco {
    void cadastrar(Endereco endereco) throws SQLException;
    Endereco alterar(Endereco endereco) throws SQLException;
    void excluir(Long id) throws SQLException;
    List<Endereco> listarEndereco() throws SQLException;
    List<Endereco> listarPorId(Long id) throws SQLException;
}
