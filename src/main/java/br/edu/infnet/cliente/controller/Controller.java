package br.edu.infnet.cliente.controller;


import br.edu.infnet.cliente.model.ClienteDto;
import br.edu.infnet.cliente.services.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clientes")
public class Controller {

    private static final Logger log = LoggerFactory.getLogger(Controller.class);
    private final ClienteService clienteService;

    public Controller(ClienteService clienteService) {

        this.clienteService = clienteService;
    }

    @PostMapping(produces = "application/json")
    public ClienteDto save(@RequestBody ClienteDto clienteDto) {
        log.info("save got a request");
        return clienteService.save(clienteDto);
    }

    @GetMapping("/{cpf}")
    public ClienteDto findById(@PathVariable("cpf") String cpf) {
        log.info("findById got a request");
        return clienteService.find(cpf);
    }

    @GetMapping
    public List<ClienteDto> findAll(){
        log.info("findAll got a request");
        return clienteService.findAll();
    }

    @DeleteMapping("/{cpf}")
    public void deleteById(@PathVariable("cpf") String cpf) {
        log.info("deleteById got a request");
        clienteService.delete(cpf);
    }


}
