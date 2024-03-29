package pl.polsl.shopserver.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.polsl.shopserver.model.entities.dbentity.Order;
import pl.polsl.shopserver.model.entities.dbview.Cartlist;

import java.util.List;

public interface OrderRepostiory extends JpaRepository<Order,Integer> {
    @Query(value = "SELECT o FROM Order o where o.idUser.id=:iduser")
    List<Order> findOrderByUserId(@Param("iduser")Integer iduser);
}
