package br.com.unifacol.dizimo.model.teste;

import br.com.unifacol.dizimo.model.enums.Estado;
import br.com.unifacol.dizimo.model.repository.EnderecoRepository;
import br.com.unifacol.dizimo.model.service.EnderecoService;
import br.com.unifacol.dizimo.model.util.JPAUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;
import java.sql.SQLException;

public class Endereco {
    public static void main(String[] args) throws SQLException {
        EntityManager manager = JPAUtil.getManager();
        EnderecoRepository enderecoRepository = new EnderecoRepository(manager);
        EnderecoService enderecoService = new EnderecoService(enderecoRepository);
        String rua = JOptionPane.showInputDialog("RUA:");
        Integer numero = Integer.parseInt(JOptionPane.showInputDialog("Numero: "));
        String bairro = JOptionPane.showInputDialog("Bairro: ");
        String cidade = JOptionPane.showInputDialog("Cidade: ");
        Estado estado = Estado.valueOf(JOptionPane.showInputDialog("Estado: "));
        enderecoService.cadastar(rua,numero,bairro,cidade,estado);
        enderecoService.listarTodos();
    }
}
