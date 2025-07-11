package br.com.onshoes.repository.client.queries;

import br.com.onshoes.model.Produto.CategoriaProduto;
import br.com.onshoes.model.Produto.Produto;
import br.com.onshoes.model.Produto.StatusProduto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Page<Produto> findByStatus(@Param("status") StatusProduto status, Pageable pageable);

    Page<Produto> findByCategoriaAndStatus(@Param("categoria") CategoriaProduto categoria, @Param("status") StatusProduto status, Pageable pageable);

    Page<Produto> findOfertas(Pageable pageable);

    Page<Produto> search(@Param("query") String query, Pageable pageable);
}