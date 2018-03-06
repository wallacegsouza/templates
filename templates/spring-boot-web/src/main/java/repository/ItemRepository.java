package ${pkg}.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ${pkg}.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {}
