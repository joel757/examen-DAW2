package org.cibertec.edu.pe.service;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.InterfaceService.IProductService;
import org.cibertec.edu.pe.interfaces.IProductRepository;
import org.cibertec.edu.pe.modelo.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
	
	private IProductRepository data;

	@Override
	public List<Product> Listar() {
		return (List<Product>)data.findAll();
	}

	@Override
	public Optional<Product> Buscar(String id) {
		return data.findById(id);
	}

	@Override
	public int grabar(Product producto) {
		int rpta = 0;
		Product Obj = data.save(producto);
		if(!Obj.equals(null))rpta = 1;
		return rpta;
	}

	@Override
	public void Eliminar(String id) {
		data.deleteById(id);
		
	}

	

}
