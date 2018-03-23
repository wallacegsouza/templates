package ${pkg}.init;

import ${pkg}.entity.Item;
import ${pkg}.entity.Category;
import ${pkg}.repository.ItemRepository;
import ${pkg}.repository.CategoryRepository;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import static ${pkg}.util.Config.JENV_PRODUCTION;

@Component
public class Bootstrap {

  @Autowired
  private ItemRepository itemRepository;

  @Autowired
  private CategoryRepository categoryRepository;


  /**
    * Used only for development and test environment.
   */
  @Transactional
  public void seed() {
    if(!JENV_PRODUCTION) {
      
      Category categoryX = categoryRepository.save(new Category("X classes"));
      Category categoryY = categoryRepository.save(new Category("Y classes"));

      itemRepository.save(new Item("A", categoryX));
      itemRepository.save(new Item("B", categoryY));
      itemRepository.save(new Item("C", categoryY));
    }
  }
}