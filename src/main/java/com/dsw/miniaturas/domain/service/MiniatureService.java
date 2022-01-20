package com.dsw.miniaturas.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsw.miniaturas.api.dto.MiniatureDTO;
import com.dsw.miniaturas.domain.model.Miniature;
import com.dsw.miniaturas.domain.repository.MiniatureRepository;

@Service
public class MiniatureService {

	@Autowired
	private MiniatureRepository miniatureRepository;

	public List<MiniatureDTO> list() {

		List<Miniature> miniatures = miniatureRepository.findAll();

		return miniatures.stream().map(miniature -> {
			return new MiniatureDTO(miniature.getId(), miniature.getBrand(), miniature.getModel(), miniature.getPrice(), miniature.getImage());
		}).collect(Collectors.toList());

	}

	public Miniature search(Long miniatureId) {
		Optional<Miniature> miniOptional = miniatureRepository.findById(miniatureId);

		if (miniOptional.isPresent())
			return miniOptional.get();

		return null;
	}

}
