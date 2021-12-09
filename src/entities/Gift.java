package entities;

import enums.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class Gift {
  private String productName;
  private Double price;
  private String category;

  public Gift(final String productName, final Double price, final String category) {
    this.productName = productName;
    this.price = price;
    this.category = category;
  }

  @Override
  public String toString() {
    return "Gift{"
        + "\n"
        + "productName='"
        + productName
        + '\''
        + "\n"
        + ", price="
        + price
        + "\n"
        + ", category='"
        + category
        + '\''
        + "\n"
        + '}';
  }
}
