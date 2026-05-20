package atividade.spring.service;

import atividade.spring.models.Produto;
import atividade.spring.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto save(Produto produto){
        return repository.save(produto);
    }

    public List<Produto> findAll(){
        return repository.findAll();
    }

    public Produto findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto update(Long id, Produto produtoAtualizado){
        Produto produto = findById(id);

        produto.setNome(produtoAtualizado.getNome());
        produto.setPreco(produtoAtualizado.getPreco());

        return repository.save(produto);
    }

    public void delete(Long id){
        Produto produto = findById(id);
        repository.delete(produto);
    }
}

