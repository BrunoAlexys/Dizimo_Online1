package br.com.unifacol.dizimo.model.interfaceService;

import br.com.unifacol.dizimo.model.entidades.Endereco;
import br.com.unifacol.dizimo.model.entidades.Membro;
import br.com.unifacol.dizimo.model.enums.Sexo;

import java.sql.SQLException;
import java.time.LocalDate;

public interface IMembroService {
    void cadastrar()throws SQLException;
    void alterar(Membro membro) throws SQLException;
    void excluir(String cpf) throws SQLException;
    void listarTodos() throws SQLException;
    void listarPorID(String cpf) throws SQLException;
}
