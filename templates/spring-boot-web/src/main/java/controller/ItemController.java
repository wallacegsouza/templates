package ${pkg}.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ${pkg}.entity.Item;
import ${pkg}.service.ItemService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class ItemController {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private ItemService itemService;

  @GetMapping("/teste")
  public List<Item> items() {
    logger.info("This is an info message.");
    return itemService.findAll();
  }

}
