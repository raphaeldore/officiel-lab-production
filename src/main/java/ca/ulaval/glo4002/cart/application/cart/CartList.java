package ca.ulaval.glo4002.cart.application.cart;

import ca.ulaval.glo4002.cart.domain.cart.Cart;
import java.util.List;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CartList {

  @XmlElementWrapper
  private List<Cart> carts;

  private CartList() {
    // JAXB
  }

  public CartList(List<Cart> carts) {
    this.carts = carts;
  }

  public List<Cart> getCarts() {
    return carts;
  }
}
