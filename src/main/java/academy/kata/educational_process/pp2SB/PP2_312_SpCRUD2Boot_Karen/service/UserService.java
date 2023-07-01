package academy.kata.educational_process.pp2SB.PP2_312_SpCRUD2Boot_Karen.service;


import academy.kata.educational_process.pp2SB.PP2_312_SpCRUD2Boot_Karen.entity.User;

import java.util.List;

public interface UserService {

    void add(User user);
    void updateUser(User user);
    void deleteUserFromTable(Long id);
    List<User> getAllUsers();
    User findById(Long id);

}
