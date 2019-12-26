package com.kangmin.basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kangmin.basic.model.Product;

// @Controller @Service @Repository @Component
 
@Repository //불려질 녀석이라고 선언  IoC / DI 의 IoC
public interface ProductRepository extends JpaRepository<Product, Long> {

	public List<Product> findByName(String name); 
	// findByName 메소드 사용, 이름이 name인 사람 찾아줘



}