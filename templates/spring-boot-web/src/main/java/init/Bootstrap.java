package ${pkg}.init;

import ${pkg}.entity.Item;
import ${pkg}.repository.ItemRepository;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import static ${pkg}.util.Config.JENV_PRODUCTION;

@Component
public class Bootstrap {

  @Autowired
  private ItemRepository itemRepository;

  /**
    * Used only for development and test environment.
   */
  @Transactional
  public void seed() {
    if(!JENV_PRODUCTION) {
      itemRepository.save(new Item(1, "A"));
      itemRepository.save(new Item(2, "B"));
      itemRepository.save(new Item(3, "C"));
    }
  }
}