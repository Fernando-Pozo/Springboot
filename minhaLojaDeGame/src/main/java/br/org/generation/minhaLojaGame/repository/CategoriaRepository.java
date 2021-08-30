package br.org.generation.minhaLojaGame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.minhaLojaGame.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria , Long > {
	public List <Categoria> findAllByDescricaoContainingIgnoreCase(String descricao);
}
