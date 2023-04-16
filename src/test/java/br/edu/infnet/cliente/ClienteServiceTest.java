package br.edu.infnet.cliente;

import br.edu.infnet.cliente.model.Cliente;
import br.edu.infnet.cliente.model.ClienteDto;
import br.edu.infnet.cliente.model.Sexo;
import br.edu.infnet.cliente.repository.ClienteRepository;
import br.edu.infnet.cliente.services.ClienteService;
import br.edu.infnet.cliente.services.ClienteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ClienteServiceTest {

    private ClienteRepository repository;
    private ClienteService clienteService;

   @BeforeEach
    void initService() {
        MockitoAnnotations.openMocks(this);
        this.repository=Mockito.mock(ClienteRepository.class);
        clienteService = new ClienteServiceImpl(repository,null);
    }

    @Test
    void save() {

        ClienteDto cliente = new ClienteDto("123456789-10", "Solicitante Novo", Sexo.MASCULINO);
        when(repository.save(any(Cliente.class))).then(returnsFirstArg());

        Cliente savedCliente = clienteService.save(cliente).toCliente();

        assertEquals(cliente.getCpf(), savedCliente.getCpf());

        assertEquals(cliente.getNome(), savedCliente.getNome());
        assertEquals(cliente.getSexo(), savedCliente.getSexo());

    }

    @Test
    void find() {
        ClienteDto clienteOriginal = new ClienteDto("cpf3", "Cliente Pesquisado", Sexo.FEMININO);
        when(repository.findById("cpf3")).thenReturn(Optional.ofNullable(clienteOriginal.toCliente()));

        ClienteDto clienteRetornado = clienteService.find("cpf3");

        assertEquals(clienteOriginal.getCpf(), clienteRetornado.getCpf());
        assertEquals(clienteOriginal.getNome(), clienteRetornado.getNome());
        assertEquals(clienteOriginal.getSexo(), clienteRetornado.getSexo());
    }

    @Test
    void findAll() {
        when(repository.findAll()).thenReturn(clienteList());

        List<ClienteDto> list = clienteService.findAll();

        assertEquals(2, list.size());
    }

    private List<Cliente> clienteList(){
        Cliente u1 = new Cliente("cpf1", "nome1", Sexo.MASCULINO);
        Cliente u2 = new Cliente("cpf2", "nome2", Sexo.FEMININO);
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(u1);
        clientes.add(u2);
        return clientes;
    }

    @Test
    void delete() {
        clienteService.delete("cpf1");
        Mockito.verify(repository).deleteById("cpf1");
    }
}