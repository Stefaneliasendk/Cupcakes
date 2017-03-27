package backend;

import data.CakeMapper;
import model.User;

public class DummyLoginService implements LoginService
{
    CakeMapper cm = new CakeMapper();
    
    @Override
    public User login(String userID, String password, int balance)
    {
        if(cm.getUser(userID).getUserID().equals(userID) && cm.getUser(userID).getPassword().equals(password))
        {
            return new User(userID, password, cm.getUser(userID).getBalance());
        }
        return null;
    }
    
}
