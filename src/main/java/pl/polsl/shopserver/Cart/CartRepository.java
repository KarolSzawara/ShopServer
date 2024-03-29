package pl.polsl.shopserver.Cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.polsl.shopserver.model.entities.dbentity.Cart;
import java.util.List;
public interface CartRepository extends JpaRepository<Cart,Integer> {
    @Query(value = "SELECT c.id FROM Cart c where c.idUse.id=:userId and c.idProd.id=:productId")
    Integer findCartByUserIdAndProductId(@Param("userId")Integer userId,@Param("productId")Integer productId);
    @Query(value = "SELECT c FROM Cart c where c.idUse.id=:userId")
    List<Cart> findCartByIdUser(@Param("userId")Integer userId);
}
