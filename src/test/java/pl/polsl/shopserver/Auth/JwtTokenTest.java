package pl.polsl.shopserver.Auth;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pl.polsl.shopserver.model.entities.dbentity.User;

class JwtTokenTest {

    @Test
    void validateToke() {
        User user=new User(1,"mail","pass","name","last","ph","1","com","txt","straBe","1","36-3","nrl","213","phon",null,null,"T",null);
        String token=JwtToken.creatToken(user);
        Assert.assertEquals(JwtToken.validateToke(token),"mail");
    }
}