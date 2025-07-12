package br.com.onshoes.repository;

import br.com.onshoes.model.Produto.CategoriaProduto;
import br.com.onshoes.model.Produto.Produto;
import br.com.onshoes.model.Produto.StatusProduto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p WHERE p.status = :status")
    Page<Produto> findByStatus(@Param("status") StatusProduto status, Pageable pageable);
    
    @Query("SELECT p FROM Produto p WHERE p.status = :status AND p.categoria = :categoria")
    Page<Produto> findByCategoriaAndStatus(@Param("categoria") CategoriaProduto categoria, @Param("status") StatusProduto status, Pageable pageable);
    
    @Query("SELECT p FROM Produto p WHERE p.status = 'ATIVO' AND p.precoPromocional IS NOT NULL AND p.precoPromocional > 0")
    Page<Produto> findOfertas(Pageable pageable);

    @Query("SELECT p FROM Produto p WHERE p.status = 'ATIVO' AND " +
           "(LOWER(p.nome) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(p.descricao) LIKE LOWER(CONCAT('%', :query, '%')))")
    Page<Produto> search(@Param("query") String query, Pageable pageable);
}