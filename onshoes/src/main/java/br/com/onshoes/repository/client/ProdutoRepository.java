package br.com.onshoes.repository.client;

import br.com.onshoes.model.Produto.Produto;
import br.com.onshoes.model.Produto.StatusProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p WHERE p.status = :status")
    List<Produto> findByStatus(@Param("status") StatusProduto status);
}