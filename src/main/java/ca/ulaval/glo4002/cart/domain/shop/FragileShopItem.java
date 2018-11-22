package ca.ulaval.glo4002.cart.domain.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlElement;

@Entity
public class FragileShopItem extends ShopItem {
  private static final int FLAT_PRICE = 5;
  private static final int PRICE_PER_KG = 3;

  @XmlElement
  @JsonProperty
  @Column
  private String name;

  @XmlElement
  @JsonProperty
  @Column
  private boolean available;

  @XmlElement
  @JsonProperty
  @Column
  private int price;

  @XmlElement
  @JsonProperty
  @Column
  private int weight;

  @XmlElement
  @JsonProperty
  @Column
  private double profitMarginPercentage;

  public FragileShopItem(String itemSku, String name, int price, int weight, double profitMarginPercentage,
      boolean available) {
    this.itemSku = itemSku;
    this.name = name;
    this.price = price;
    this.weight = weight;
    this.profitMarginPercentage = profitMarginPercentage;
    this.available = available;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean isAvailable() {
    return available;
  }

  @Override
  public int getPriceWithShipping() {
    return price + weight * PRICE_PER_KG + FLAT_PRICE;
  }
}
