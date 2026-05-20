package atividade.spring.service;

import atividade.spring.models.Cliente;
import atividade.spring.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente save(Cliente cliente){
        return repository.save(cliente);
    }

    public List<Cliente> findAll(){
        return repository.findAll();
    }

    public Cliente findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente update(Long id, Cliente clienteAtualizado){
        Cliente cliente = findById(id);

        cliente.setNome(clienteAtualizado.getNome());

        return repository.save(cliente);
    }

    public void delete(Long id){
        Cliente cliente = findById(id);
        repository.delete(cliente);
    }
}

