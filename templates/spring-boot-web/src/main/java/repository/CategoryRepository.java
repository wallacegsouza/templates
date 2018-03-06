package ${pkg}.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ${pkg}.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {}
