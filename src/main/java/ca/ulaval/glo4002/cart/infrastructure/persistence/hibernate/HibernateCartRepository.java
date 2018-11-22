package ca.ulaval.glo4002.cart.infrastructure.persistence.hibernate;

import ca.ulaval.glo4002.cart.application.jpa.EntityManagerProvider;
import ca.ulaval.glo4002.cart.domain.cart.Cart;
import ca.ulaval.glo4002.cart.domain.cart.CartRepository;
import java.util.List;
import javax.persistence.EntityManager;

public class HibernateCartRepository implements CartRepository {

  @Override
  public List<Cart> listCarts() {
    EntityManager entityManager = EntityManagerProvider.getEntityManager();
    return entityManager.createQuery("from Carts", Cart.class).getResultList();
  }

  @Override
  public synchronized void persistCarts(List<Cart> newCarts) {
    EntityManager entityManager = EntityManagerProvider.getEntityManager();
    entityManager.getTransaction().begin();
    newCarts.forEach(x -> entityManager.merge(x));
    entityManager.getTransaction().commit();
  }
}
