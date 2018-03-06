package ${pkg}.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Item implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  @ManyToOne
  @JoinColumn(name="itemId")
  @JsonBackReference
  private Category category;

  public Item() {
  }

  public Item(String name, Category category) {
    this.name = name;
    this.category = category;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setId(String id) {
    this.id = Integer.parseInt(id);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Category getCategory() {
    return this.category;
  }

}
