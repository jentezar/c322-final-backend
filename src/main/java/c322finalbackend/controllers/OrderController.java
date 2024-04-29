package c322finalbackend.controllers;

import c322finalbackend.model.Order;
import c322finalbackend.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {
    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Order order) {
        try {
            Order orderData = orderRepository.save(order);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(orderData);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}