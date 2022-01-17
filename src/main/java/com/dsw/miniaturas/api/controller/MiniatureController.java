package com.dsw.miniaturas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsw.miniaturas.api.dto.MiniatureDTO;
import com.dsw.miniaturas.domain.model.Miniature;
import com.dsw.miniaturas.domain.service.MiniatureService;

@RestController
@RequestMapping("/miniatures")
public class MiniatureController {

	@Autowired
	private MiniatureService miniatureService;

	@GetMapping
	public List<MiniatureDTO> list() {
		return miniatureService.list();
	}

	@GetMapping("/{miniatureId}")
	public ResponseEntity<Miniature> search(@PathVariable Long miniatureId) {

		Miniature miniature = miniatureService.search(miniatureId);
		if (miniature != null)
			return ResponseEntity.ok(miniature);

		return ResponseEntity.notFound().build();
	}
}
