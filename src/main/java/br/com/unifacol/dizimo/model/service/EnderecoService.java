package br.com.unifacol.dizimo.model.service;

import br.com.unifacol.dizimo.model.entidades.Endereco;
import br.com.unifacol.dizimo.model.enums.Estado;
import br.com.unifacol.dizimo.model.interfaceService.IEnderecoService;
import br.com.unifacol.dizimo.model.repository.EnderecoRepository;
import java.sql.SQLException;

public class EnderecoService implements IEnderecoService {

    private EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public void cadastar(String rua, Integer numero, String bairro, String cidade, Estado estado) throws SQLException {
        Endereco endereco = new Endereco(rua,numero,bairro,cidade,estado);
        enderecoRepository.cadastrar(endereco);

    }

    @Override
    public void alterar(String rua, Integer numero, String bairro, String cidade, Estado estado) throws SQLException {
        Endereco endereco = new Endereco(rua,numero,bairro,cidade,estado);
        enderecoRepository.alterar(endereco);
    }

    @Override
    public void excluir(Long id) throws SQLException {
        enderecoRepository.excluir(id);
    }

    @Override
    public void listarTodos() throws SQLException {
        enderecoRepository.listarEndereco();
    }

    @Override
    public void listarPorID(Long id) {
        try {
            enderecoRepository.listarPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
