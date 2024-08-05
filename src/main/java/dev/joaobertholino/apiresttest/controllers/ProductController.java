package dev.joaobertholino.apiresttest.controllers;

import dev.joaobertholino.apiresttest.dtos.ProductDto;
import dev.joaobertholino.apiresttest.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<ProductDto>> findAll() {
		return ResponseEntity.status(HttpStatus.FOUND).body(this.productService.findAll());
	}

	@GetMapping(value = "/find/{id}")
	public ResponseEntity<ProductDto> findById(@PathVariable UUID id) {
		return ResponseEntity.status(HttpStatus.FOUND).body(this.productService.findById(id));
	}

	@GetMapping(value = "/insert")
	public ResponseEntity<ProductDto> insert(@RequestBody ProductDto newProduct) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.productService.insert(newProduct));
	}

	@GetMapping(value = "/update/{id}")
	public ResponseEntity<ProductDto> update(@PathVariable UUID id, @RequestBody ProductDto productUpdated) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.productService.update(id, productUpdated));
	}

	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
		this.productService.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
