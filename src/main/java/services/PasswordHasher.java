package services;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher {

    public static String Hashing(String pass){
        return BCrypt.hashpw(pass, BCrypt.gensalt());
    }

    public static Boolean checkPassword(String pass, String hash){
        return BCrypt.checkpw(pass, hash);
    }
}
