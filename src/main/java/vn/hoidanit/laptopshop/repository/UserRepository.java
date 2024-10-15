package vn.hoidanit.laptopshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hoidanit.laptopshop.domain.User;

//crud: create, read, update, delete
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User dataUser);

    List<User> findAll();

    User findById(long id);

    void deleteById(long id);

    // check email exist
    boolean existsByEmail(String email);

    // lay user bang email
    User findByEmail(String email);
}