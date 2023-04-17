package br.com.unifacol.dizimo.model.interfaceService;

import br.com.unifacol.dizimo.model.enums.Estado;

import java.sql.SQLException;

public interface IEnderecoService {
    void cadastar(String rua, Integer numero, String bairro, String cidade, Estado estado) throws SQLException;
    void alterar(String rua, Integer numero, String bairro, String cidade, Estado estado) throws SQLException;
    void excluir(Long id) throws SQLException;
    void listarTodos() throws SQLException;
    void listarPorID(Long id) throws SQLException;
}
