package pl.polsl.shopserver.OrderControl;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.polsl.shopserver.Auth.JwtToken;
import pl.polsl.shopserver.CartControl.CartItem;
import pl.polsl.shopserver.CartControl.CartRepository;
import pl.polsl.shopserver.OrderHistoryControl.OrderItemRepository;
import pl.polsl.shopserver.UserControl.UserService;
import pl.polsl.shopserver.WarehouseController.WarehouseRepository;
import pl.polsl.shopserver.dbentity.*;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
     @Autowired
    OrderRepostiory orderRepostiory;
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    UserService userService;
    OrderService orderService;
    @BeforeEach
    void init(){
        orderService=new OrderService(orderRepostiory,orderItemRepository,cartRepository,warehouseRepository,userService);
    }
    @Test
    void purchaseCart() {

    }
    @Test
    void purchaseItem(){

    }
    void prepareDate(){
        Product product=new Product(null,1,"23",100.0,"100","100","100","100","Product","Description","Details");
        warehouseRepository.save(new Warehouse(1,product,30,40.2));
    }
}