package com.dsw.miniaturas.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsw.miniaturas.domain.model.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

	public List<History> findByUserId(Long userId);

}
