package ca.ulaval.glo4002.cart.application.shop;

import ca.ulaval.glo4002.cart.domain.shop.ShopItem;
import java.util.List;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Shop {
  @XmlElementWrapper
  private List<ShopItem> items;

  private Shop() {
    // JAXB
  }

  public Shop(List<ShopItem> items) {
    this.items = items;
  }

  public List<ShopItem> getItems() {
    return items;
  }
}
