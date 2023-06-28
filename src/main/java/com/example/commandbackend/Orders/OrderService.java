package com.example.commandbackend.Orders;

import com.example.commandbackend.Clients.ClientsRepository;
import com.example.commandbackend.Clients.Dtos.ClientDto;
import com.example.commandbackend.Clients.Entities.Clients;
import com.example.commandbackend.OrderHasProduct.Dtos.OrderHasProductsDto;
import com.example.commandbackend.OrderHasProduct.Entities.OrderHasProduct;
import com.example.commandbackend.Orders.Enums.OrderStatusEnum;
import com.example.commandbackend.Orders.Dtos.CreateOrderDto;
import com.example.commandbackend.Orders.Dtos.OrderDto;
import com.example.commandbackend.Orders.Entities.Orders;
import com.example.commandbackend.ProductCategory.Dtos.ProductCategoryDto;
import com.example.commandbackend.ProductCategory.Entities.ProductCategory;
import com.example.commandbackend.Products.Enums.ProductStatusEnum;
import com.example.commandbackend.Products.Dtos.ProductDto;
import com.example.commandbackend.Products.Entities.Products;
import com.example.commandbackend.Products.ProductsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
     @Autowired
     private OrdersRepository ordersRepository;
     @Autowired
     private ClientsRepository clientsRepository;
     @Autowired
     private ProductsRepository productsRepository;
     @Autowired
     private EntityManager entityManager;

     public Orders create(CreateOrderDto createOrder){
         Orders newOrder = new Orders();

         Clients client = clientsRepository.findById(createOrder.clientId).get();
         List<Long> productsIdsList = createOrder.productsList.stream().map(x -> x.productId).toList();
         List<Products> productsList = productsRepository.findAllById(createOrder.productsList.stream().map(x -> x.productId).toList());

         List<OrderHasProduct> orderHasProductList = new ArrayList<OrderHasProduct>();
         for (Products product : productsList
              ) {
            OrderHasProduct orderHasProduct = new OrderHasProduct(
                    createOrder.productsList.stream().filter(x -> x.productId == product.getId()).findFirst().get().quantity,
                    newOrder,
                    ProductStatusEnum.Required,
                    product
            );
             orderHasProductList.add(orderHasProduct);
         }
         newOrder.setClient(client);
         newOrder.setOrderHasProductList(orderHasProductList);
         newOrder.setOrderStatus(OrderStatusEnum.Required);
         ordersRepository.save(newOrder);

         return newOrder;
     }

     public OrderDto getById(Long id){
         CriteriaBuilder cb = entityManager.getCriteriaBuilder();
         CriteriaQuery<Orders> query = cb.createQuery(Orders.class);
         Root<Orders> orders = query.from(Orders.class);
         Join<Orders, Clients> join = orders.join("client", JoinType.INNER);
         Join<Orders, OrderHasProduct> joinOrderProducts = orders.join("orderHasProductList", JoinType.INNER);
         Join<OrderHasProduct, Products> joinProducts = joinOrderProducts.join("product", JoinType.INNER);
         Join<Products, ProductCategory> joinCategory = joinProducts.join("category", JoinType.INNER);
         query.where(cb.equal(orders.get("id"), id));

         query.select(orders);

         Orders result = entityManager.createQuery(query).getSingleResult();
         List<OrderHasProductsDto> orderProducts =
                 result.getOrderHasProductList().stream()
                         .map(x -> new OrderHasProductsDto(
                                 x.getId(),
                                 x.getQuantity(),
                                 new ProductDto(
                                         x.getProduct().getId().describeConstable(),
                                         x.getProduct().getName(),
                                         x.getProduct().getValue(),
                                         x.getProduct().isHasStock(),
                                         x.getProduct().isBlocked(),
                                         x.getProduct().isCustom(),
                                         x.getProduct().getImageUrl(),
                                         x.getProduct().getCategoryId(),
                                         new ProductCategoryDto(
                                                 x.getProduct().getCategory().getId(),
                                                 x.getProduct().getCategory().getDescription()
                                         )))).toList();

         ClientDto clientRes = new ClientDto(
                 result.getClient().getId(),
                 result.getClient().getName(),
                 result.getClient().getDocument(),
                 result.getClient().isHasTicket());

         OrderDto orderRes = new OrderDto(result.getId(), result.getOrderStatus(), clientRes, orderProducts);
         return orderRes;
     }
}
