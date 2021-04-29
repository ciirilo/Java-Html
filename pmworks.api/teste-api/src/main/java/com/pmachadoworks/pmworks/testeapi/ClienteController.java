package com.pmachadoworks.pmworks.testeapi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
//Usamos o @Request Mapping para usar um prefixo
//em todas as nossas rotas
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private CadastroClienteService cadastroCliente;
    //Rota de Read
    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    //Rota de find
    @GetMapping("/{clienteId}")
    public  ResponseEntity<Cliente> buscar(@PathVariable Long clienteId){
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);

        if (cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();
    }

    //Rota de Create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente){
        Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
        if(clienteExistente != null && clienteExistente.equals(cliente)){

        }
        return cadastroCliente.salvar(cliente);
    }

    //Rota de Update
    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@Valid  @PathVariable Long clienteId,
            @Valid @RequestBody Cliente cliente) {

        if(!clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }
        cliente.setId(clienteId);
        cliente = cadastroCliente.salvar(cliente);
        return ResponseEntity.ok(cliente);
    }

    //Rota de Delete
    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> remover(@PathVariable Long clienteId){

        if(!clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }
        cadastroCliente.excluir(clienteId);

        return ResponseEntity.noContent().build();
    }
}
