package me.yevgnenll.core.service;

import me.yevgnenll.core.order.Order;

public interface OrderService {

  Order createOrder(Long memberId, String itemName, int itemPrice);

}
