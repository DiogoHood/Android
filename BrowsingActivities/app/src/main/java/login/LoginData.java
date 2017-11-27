package login;

import java.util.ArrayList;

/**
 * Created by diogo on 20/11/17.
 */

public class LoginData {

    private static ArrayList<Login> loginData = new ArrayList<>();

    public boolean register(String email, String password, String name){

        Login loginAux = null;

        if(!this.authenticate(email,password)){
            Login login = new Login(email,password,name);
            loginData.add(login);
            return true;
        }

        return false;
    }

    public boolean authenticate(String email, String password){

        Login loginAux = null;

        for(int i=0; i < loginData.size();i++){

            loginAux = loginData.get(i);

            if(loginAux.getEmail().equals(email) && loginAux.getPassword().equals(password))
                return true;
        }

        return false;
    }
}
