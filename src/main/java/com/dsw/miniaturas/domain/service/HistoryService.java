package com.dsw.miniaturas.domain.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsw.miniaturas.api.dto.HistoryDTO;
import com.dsw.miniaturas.domain.model.History;
import com.dsw.miniaturas.domain.model.Miniature;
import com.dsw.miniaturas.domain.model.User;
import com.dsw.miniaturas.domain.repository.HistoryRepository;
import com.dsw.miniaturas.domain.repository.MiniatureRepository;
import com.dsw.miniaturas.domain.repository.UserRepository;

@Service
public class HistoryService {

	@Autowired
	private HistoryRepository historyRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MiniatureRepository miniatureRepository;

	public List<String> list(Long userId) {
		List<History> histories = historyRepository.findByUserId(userId);
		return histories.stream().map(history -> {
			return history.getMiniature().getModel();
		}).collect(Collectors.toList());
	}

	public History save(HistoryDTO historyDTO) {
		User user = userRepository.findById(historyDTO.getUserId()).get();
		Miniature miniature = miniatureRepository.findById(historyDTO.getMiniatureId()).get();
		History history = new History();
		history.setUser(user);
		history.setMiniature(miniature);
		history.setAccessDate(LocalDateTime.now());
		return historyRepository.save(history);
	}

}
