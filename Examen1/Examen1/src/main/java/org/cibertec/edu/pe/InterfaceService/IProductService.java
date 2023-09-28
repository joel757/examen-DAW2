package org.cibertec.edu.pe.InterfaceService;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.modelo.Product;



public interface IProductService {

	public List<Product> Listar();
	public Optional<Product> Buscar(String id);
	public int grabar(Product producto);
	public void Eliminar(String id);
	

	
}
