package pl.polsl.shopserver.Auth;

import net.bytebuddy.utility.RandomString;

public class ConfirmationLink {
    static public String createLink(){

        var randomCode = RandomString.make(45);
        return randomCode;
    }
}
