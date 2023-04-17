package br.com.unifacol.dizimo.model.interfaceRepository;

import br.com.unifacol.dizimo.model.entidades.Membro;

import java.sql.SQLException;
import java.util.List;

public interface IRepositoryMembro {
    void cadastrarMembro(Membro membro) throws SQLException;
    void alterarMembro(Membro membro) throws SQLException;
    void excluirMembro(Long id) throws SQLException;
    List<Membro> listarMembros() throws SQLException;
    List<Membro> listarPorID(Long id) throws SQLException;
    List<Membro> listarPorCPF(String cpf) throws SQLException;

}
