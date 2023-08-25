package org.acme;

import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.transaction.Transactional;

public class UserManager {
final static String USERROLE = "user";
final static String SEPARATOR = ";";

@Transactional
public static void addUser(User user){
    if(!userExists(user.username))
{
        user.roles = USERROLE;
        user.password = BcryptUtil.bcryptHash(user.password);
        user.persist();
    }else{

    }
}
public static String generateJWT(String username){
    User foundUser = User.find("username", username).firstResult();
    return TokenGenerator.generate(username, foundUser.roles);
}

private static boolean userExists(String username){
    return (User.count("username", username) > 0);
}

/*private static void addRole(User user, String role){
    user.roles = user.roles + SEPARATOR + role;
}*/

}
