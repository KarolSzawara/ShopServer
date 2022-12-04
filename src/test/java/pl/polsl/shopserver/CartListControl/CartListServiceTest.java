package pl.polsl.shopserver.CartListControl;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.polsl.shopserver.Auth.JwtToken;
import pl.polsl.shopserver.CartControl.CartItem;
import pl.polsl.shopserver.CartControl.CartRepository;
import pl.polsl.shopserver.CartControl.CartService;
import pl.polsl.shopserver.PhotoControl.PhotoRepository;
import pl.polsl.shopserver.ProductControl.ProductRepository;
import pl.polsl.shopserver.UserControl.UserRepository;
import pl.polsl.shopserver.dbentity.Cart;
import pl.polsl.shopserver.dbentity.Photo;
import pl.polsl.shopserver.dbentity.Product;
import pl.polsl.shopserver.dbentity.User;
import pl.polsl.shopserver.dbview.Cartlist;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
@SpringBootTest()
@RunWith(SpringRunner.class)
class CartListServiceTest {


    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PhotoRepository photoRepository;
    @Autowired
    CartListRepository cartListRepository;
    CartListService cartListService;

    @Autowired
    CartRepository cartRepository;
    String token;
    @BeforeEach
    void setUp() {
        cartListService=new CartListService(cartListRepository,userRepository);
        prepareData();
    }

    @AfterEach
    void tearDown() {
        photoRepository.deleteAll();
        userRepository.deleteAll();
        cartRepository.deleteAll();
    }

    @Test
    void getCartByUser() {
        List<Cartlist> cartList=cartListService.getCartByUser(token);
        Cartlist cartItem=cartList.get(0);
        Assert.assertEquals(cartItem.getIdCart().intValue(),1);
        Assert.assertEquals(cartItem.getOrderItemQuantity().intValue(),1);

    }
    void prepareData(){
        Product product=productRepository.save(new Product(null,1,"23",100.0,"100","100","100","100","Product","Description","Details"));
        Photo photo = new Photo("/src",product);
        photoRepository.save(photo);
        User user=new User(1,"mail","pass","name","last","ph","1","com","txt","straBe","1","36-3","nrl","213","phon",null,null,"T",null);
        userRepository.save(user);
        cartRepository.save(new Cart(1,user,product));
        token=JwtToken.creatToken(user);
    }
}