package ca.ulaval.glo4002.cart.application.cart;

import ca.ulaval.glo4002.cart.application.ServiceLocator;
import ca.ulaval.glo4002.cart.domain.cart.CannotFindCartException;
import ca.ulaval.glo4002.cart.domain.cart.Cart;
import ca.ulaval.glo4002.cart.domain.cart.CartItemFactory;
import ca.ulaval.glo4002.cart.domain.cart.CartRepository;
import ca.ulaval.glo4002.cart.domain.shop.ShopItem;
import java.util.List;

public class CartApplicationService {

  private final CartItemFactory cartItemFactory;
  private CartRepository cartRepository;

  public CartApplicationService() {
    this.cartRepository = ServiceLocator.INSTANCE.resolve(CartRepository.class);
    this.cartItemFactory = ServiceLocator.INSTANCE.resolve(CartItemFactory.class);
  }

  public Cart findOrCreateCartForClient(String email) {
    try {
      List<Cart> carts = cartRepository.listCarts();
      return getCartByOwner(email, carts);
    } catch (Exception e) {
      throw new CannotFindCartException("Cannot find cart for " + email);
    }
  }

  public void addItemToCart(String email, ShopItem item) {
    List<Cart> carts = cartRepository.listCarts();
    Cart cart = getCartByOwner(email, carts);

    cart.addItem(cartItemFactory.createItem(item));

    cartRepository.persistCarts(carts);
  }

  private Cart getCartByOwner(String email, List<Cart> carts) {
    return carts.stream().filter(c -> c.ownerEmail.equals(email)).findFirst().orElseGet(() -> {
      Cart newCart = new Cart(email);
      carts.add(newCart);
      cartRepository.persistCarts(carts);
      return newCart;
    });
  }
}
