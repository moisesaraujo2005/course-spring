package br.com.projeto.api.repository;

import br.com.projeto.api.entity.Pessoa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@org.springframework.stereotype.Repository


public interface Repository extends CrudRepository<Pessoa, Integer> {
    List<Pessoa> findAll();

    Pessoa findById(int id);

    List<Pessoa> findByOrderByNomeAsc();

    List<Pessoa> findByNomeOrderByIdadeDesc(String nome);

    List<Pessoa> findByNomeContaining(String termo);

    List<Pessoa> findByNomeStartsWith(String termo);

    List<Pessoa> findByNomeEndsWith(String termo);

    @Query(value = "SELECT SUM(idade) FROM pessoas", nativeQuery = true)
    int somaIdades();

    @Query(value = "SELECT * FROM pessoas where idade>= :idade", nativeQuery = true)
    List<Pessoa> idadeMaiorIgual(int idade);

    int countById(int id);

}
