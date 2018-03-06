package ${pkg}.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import ${pkg}.entity.Item;
import ${pkg}.repository.ItemRepository;

@Service
public class ItemService {

  @Autowired
  private ItemRepository itemRepository;

  public List<Item> findAll() {
    return itemRepository.findAll();
  }

}
