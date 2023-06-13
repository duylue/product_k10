package com.product.service.impl;

import com.product.model.User;
import com.product.repo.UserRepo;
import com.product.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private  EntityManager entityManager;
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;
    private static int TEST =1;

    public UserServiceImpl(UserRepo userRepo ) {
        this.userRepo = userRepo;


    }

    @Override
    public User getUser(int id) {
        return userRepo.findById(id).get();
    }

    @Override
    public Optional<User> getUserByUsername(String name) {
        return userRepo.findByUsername(name);
    }

    @Override
    public void test() {
try {
//    entityManager = entityManagerFactory.createEntityManager();
//    EntityTransaction transaction = entityManager.getTransaction();
//    transaction.begin();
//    User user = new User();
//    user.setName("duy");
//    user.setUsername("duy1234"+TEST);
//    TEST++;
//    user.setPassword("12345678");
//    entityManager.persist(user);
//    transaction.commit();
}catch (Exception e){
    throw new RuntimeException(e);
}


    }
}
