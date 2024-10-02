package vn.hoidanit.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // lưu User
    public User handelSaveUser(User user) {
        return this.userRepository.save(user);
    }

    // lấy danh sách tất cả các user để hiển thi lên trang user detail
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    // lấy chi tiết 1 người dùng để hiển thị lên trang User detail
    public User getUserById(long id) {
        return userRepository.findById(id);
    }

    // xóa người dùng
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }
}
