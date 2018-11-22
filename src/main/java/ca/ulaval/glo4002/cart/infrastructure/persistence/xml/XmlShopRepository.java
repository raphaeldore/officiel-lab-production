package ca.ulaval.glo4002.cart.infrastructure.persistence.xml;

import ca.ulaval.glo4002.cart.application.PersistenceException;
import ca.ulaval.glo4002.cart.application.shop.Shop;
import ca.ulaval.glo4002.cart.domain.shop.ShopItem;
import ca.ulaval.glo4002.cart.domain.shop.ShopRepository;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlShopRepository implements ShopRepository {
  private static final String SHOP_STORAGE = "shop";

  private static File storageFile;

  static {
    storageFile = XmlUtils.createStorageFile(SHOP_STORAGE);
  }

  @Override
  public List<ShopItem> listShopItems() {
    Unmarshaller unmarshaller = XmlUtils.createUnmarshaller();
    try {
      return ((Shop) unmarshaller.unmarshal(storageFile)).getItems();
    } catch (JAXBException e) {
      return new ArrayList<>();
    }
  }

  @Override
  public void persistShop(List<ShopItem> items) {
    Marshaller marshaller = XmlUtils.createMarshaller();
    try {
      marshaller.marshal(new Shop(items), storageFile);
    } catch (JAXBException e) {
      throw new PersistenceException(e);
    }
  }
}
