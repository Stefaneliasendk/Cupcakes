package backend;

import model.User;

public interface LoginService
{
    public User login(String userID, String password, int balance);
}
