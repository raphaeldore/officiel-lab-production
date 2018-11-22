package ca.ulaval.glo4002.cart.interfaces.rest.shop.dto;

import static java.util.stream.Collectors.toList;

import ca.ulaval.glo4002.cart.domain.shop.ShopItem;
import java.util.List;

public class ShopItemDtoAssembler {
  public List<ShopItemDto> toDto(List<ShopItem> items) {
    return items.stream().map(this::toDto).collect(toList());
  }

  public ShopItemDto toDto(ShopItem item) {
    return new ShopItemDto(item.getName(), item.getSku());
  }
}
