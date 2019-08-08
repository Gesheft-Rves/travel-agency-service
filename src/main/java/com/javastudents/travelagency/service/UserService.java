package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.User;
import com.javastudents.travelagency.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class UserService implements PojoService<User>, UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> list() {
        return repository.findAll();
    }

    @Override
    public User getById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public User save(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        return repository.save(user);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(getById(id));
    }

    @Override
    public UserDetails loadUserByUsername(@NotNull String str) throws UsernameNotFoundException {
        return repository.findByLogin(str);
    }
}
