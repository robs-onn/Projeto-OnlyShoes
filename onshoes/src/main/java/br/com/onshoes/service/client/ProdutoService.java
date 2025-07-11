package br.com.onshoes.service.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.onshoes.model.Produto.CategoriaProduto;
import br.com.onshoes.model.Produto.Produto;
import br.com.onshoes.model.Produto.StatusProduto;
import br.com.onshoes.repository.client.queries.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Page<Produto> findAtivosByCategoria(CategoriaProduto categoria, Pageable pageable) {
        if (categoria != null) {
            return produtoRepository.findByCategoriaAndStatus(categoria, StatusProduto.ATIVO, pageable);
        } else {
            return produtoRepository.findByStatus(StatusProduto.ATIVO, pageable);
        }
    }

    public Page<Produto> findOfertas(Pageable pageable) {
        return produtoRepository.findOfertas(pageable);
    }
    
    public Page<Produto> search(String query, Pageable pageable) {
        if (query == null || query.trim().isEmpty()) {
            return Page.empty(pageable);
        }
        return produtoRepository.search(query, pageable);
    }
    
    public Produto findById(Long codigo) {
        return produtoRepository.findById(codigo).orElse(null);
    }
}