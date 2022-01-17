package com.dsw.miniaturas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsw.miniaturas.domain.model.Miniature;

@Repository
public interface MiniatureRepository extends JpaRepository<Miniature, Long> {

}
