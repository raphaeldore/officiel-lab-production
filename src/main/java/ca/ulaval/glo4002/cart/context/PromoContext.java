package ca.ulaval.glo4002.cart.context;

import ca.ulaval.glo4002.cart.application.ServiceLocator;
import ca.ulaval.glo4002.cart.domain.cart.CartItemFactory;
import ca.ulaval.glo4002.cart.domain.cart.PromoCartItemFactory;

public class PromoContext {
  public void apply() {
    ServiceLocator.INSTANCE.register(CartItemFactory.class, new PromoCartItemFactory());
  }
}
