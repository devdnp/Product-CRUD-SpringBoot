package com.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.Product;
import com.crud.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products){
		return repository.saveAll(products);
	}
	
	public List<Product> getProducts(){
		return repository.findAll();
	}
	
	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Product getProductByName(String name) {
		return repository.findByName(name);
	}
	
	public String deleteProduct(int id) {
		repository.deleteById(null);
		return "Product removed having id: "+id;
	}
	
	public Product updateProduct(Product product) {
		Product existingProduct = repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		
		return repository.save(existingProduct);
	}
}
