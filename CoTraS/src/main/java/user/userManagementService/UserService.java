package user.userManagementService;


import exceptions.classs.CtsException;
import user.model.User;

public interface UserService {
        String registerUser(Register registerRequest) throws CtsException;
        String login(Login loginRequest) throws CtsException;
        User getUserByUsername(String username);

    }


