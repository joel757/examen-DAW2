package org.cibertec.edu.pe.interfaces;


import org.cibertec.edu.pe.modelo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository  extends JpaRepository<Product, String>{

	
	
}
