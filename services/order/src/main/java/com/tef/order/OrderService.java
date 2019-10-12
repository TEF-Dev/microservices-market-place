package com.tef.order;

import com.tef.order.dtos.ItemDto;
import com.tef.order.dtos.OrderDto;
import com.tef.order.services.OrderService;
import com.tef.order.types.OrderStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
	private OrderService orderService;

	public OrderController() {
		orderService = new OrderService();
	}

	@GetMapping("api/orders")
	public List<OrderDto> getOrders() {
		return orderService.getOrders();
	}


	@GetMapping("api/orders/{order_id}")
	public OrderDto getOrderById(@PathVariable Integer order_id) throws Exception {
		return orderService.getOrderById(order_id);
	}

	@PutMapping("api/orders/{order_id}/item/{item_id}")
	public void addItemToOrder(@PathVariable Integer order_id, @PathVariable Integer item_id) throws Exception {
		 orderService.addItemToOrder(order_id, item_id);
	}

	@PostMapping("api/orders/{order_id}/status/{status}")
	public void changeOrderStatus(@PathVariable Integer order_id, @PathVariable OrderStatus status) throws Exception {
		 orderService.changeOrderStatus(order_id, status);
	}

	@DeleteMapping("api/orders/{order_id}/remove/")
	public void removeItemFromOrder(@PathVariable Integer order_id, @PathVariable Integer item_id) {
		 orderService.removeItemFromOrder(order_id, item_id);
	}
}