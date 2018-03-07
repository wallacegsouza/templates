package ${pkg}.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
public class Category implements Serializable {
  private static final long serialVersionUID = 1L;

  private int id;

  private String description;

  private List<Item> itens;

  public Category() {}

  public Category(String description) {
    this.description = description;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setId(String id) {
    this.id = Integer.parseInt(id);
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @OneToMany(mappedBy="category")
  @JsonManagedReference
  public List<Item> getItens() {
    return itens;
  }

  public void setItens(List<Item> itens) {
    this.itens = itens;
  }

}
