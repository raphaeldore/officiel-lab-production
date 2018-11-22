package ca.ulaval.glo4002.cart.application;

public class PersistenceException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public PersistenceException(Throwable cause) {
    super("Une exception s'est produite lors de la persistence : voir la console du serveur", cause);
  }
}
