package br.com.onshoes.service.admin;

import br.com.onshoes.model.Produto.Produto;
import br.com.onshoes.model.Produto.StatusProduto;
import br.com.onshoes.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoAdminService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public void salvar(Produto produto) {
        repository.save(produto);
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public void alterarStatus(Long id) {
        Produto produto = buscarPorId(id);
        if (produto != null) {
            produto.setStatus(
                produto.getStatus() == StatusProduto.ATIVO
                    ? StatusProduto.INATIVO
                    : StatusProduto.ATIVO
            );
            repository.save(produto);
        }
    }
}
