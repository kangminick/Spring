package com.kangmin.basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kangmin.basic.model.Product;

// @Controller @Service @Repository @Component
 
@Repository //�ҷ��� �༮�̶�� ����  IoC / DI �� IoC
public interface ProductRepository extends JpaRepository<Product, Long> {

	public List<Product> findByName(String name); 
	// findByName �޼ҵ� ���, �̸��� name�� ��� ã����



}