package br.edu.infnet.cliente.services;




import br.edu.infnet.cliente.model.ClienteDto;

import java.util.List;


public interface ClienteService {

    public ClienteDto save(ClienteDto clienteDto);

    public ClienteDto find(String cpf);

    public List<ClienteDto> findAll();

    public void delete(String cpf);
}
