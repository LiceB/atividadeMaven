package br.fiap.app.exemplo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fiap.app.exemplo.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
}
