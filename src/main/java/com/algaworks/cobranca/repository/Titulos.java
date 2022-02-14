package com.algaworks.cobranca.repository;

import java.util.List;

import com.algaworks.cobranca.model.Titulo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Titulos extends JpaRepository<Titulo, Long>{

    public List<Titulo> findByDescricaoContaining(String descricao);

}
