package dev.joaobertholino.apiresttest.services;

import dev.joaobertholino.apiresttest.dtos.ProductDto;
import dev.joaobertholino.apiresttest.models.Product;
import dev.joaobertholino.apiresttest.repositories.ProductRepository;
import dev.joaobertholino.apiresttest.services.exceptions.ProductNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<ProductDto> findAll() {
		List<Product> productList = this.productRepository.findAll();
		if (productList.isEmpty()) throw new ProductNotFoundException("No product found in the database");
		return productList.stream().map(product -> new ProductDto(product)).toList();
	}

	public ProductDto findById(UUID id) {
		Optional<Product> product = this.productRepository.findById(id);
		return new ProductDto(product.orElseThrow(() -> new ProductNotFoundException("Product not found")));
	}

	@Transactional
	public ProductDto insert(ProductDto newProduct) {
		Product product = new Product();
		BeanUtils.copyProperties(newProduct, product);
		this.productRepository.save(product);
		return newProduct;
	}

	@Transactional
	public ProductDto update(UUID id, ProductDto productUpdated) {
		Product productNotUpdated = this.productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Insertion failed, product not found"));
		BeanUtils.copyProperties(productUpdated, productNotUpdated);
		this.productRepository.save(productNotUpdated);
		return productUpdated;
	}

	@Transactional
	public void deleteById(UUID id) {
		Optional<Product> deletedProduct = this.productRepository.findById(id);
		this.productRepository.delete(deletedProduct.orElseThrow(() -> new ProductNotFoundException("Delete failed, product not found")));
	}
}
