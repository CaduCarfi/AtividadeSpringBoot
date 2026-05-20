package atividade.spring.controller;

import atividade.spring.models.Produto;
import atividade.spring.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto){
        return service.save(produto);
    }

    @GetMapping
    public List<Produto> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Produto update(@PathVariable Long id,
                          @RequestBody Produto produto){
        return service.update(id, produto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}