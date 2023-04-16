package br.edu.infnet.cliente.services;



import br.edu.infnet.cliente.model.Cliente;
import br.edu.infnet.cliente.model.ClienteDto;
import br.edu.infnet.cliente.repository.ClienteRepository;
import io.micrometer.observation.ObservationRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);
    private final ClienteRepository repository;
    private final ObservationRegistry registry;
    private final Random random = new Random();


    public ClienteServiceImpl(ClienteRepository repository, ObservationRegistry registry) {
        this.repository = repository;
        this.registry = registry;
    }

    @Override
    public ClienteDto save(ClienteDto clienteDto) {
        log.info("Salvando cliente {}", clienteDto.getNome());
        Cliente cliente = repository.save(clienteDto.toCliente());
        return cliente.toDto();
    }

    @Override
    public ClienteDto find(String cpf) {
        log.info("Buscando cliente com cpf = {}", cpf);
        Cliente cliente = repository.findById(cpf).orElseThrow();
        return cliente.toDto();
    }

    @Override
    public List<ClienteDto> findAll() {

        log.info("Buscando todos os clientes");
        List<Cliente> clientes = repository.findAll();
        //return clientes.stream().map(Cliente::toDto).toList();
        return clientes.stream().map(Cliente::toDto).collect(Collectors.toList());
    }

    @Override
    public void delete(String cpf) {

        log.info("Apagando cliente com o cpf = <{}>", cpf);
        repository.deleteById(cpf);
    }
}
