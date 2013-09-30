package com.comedyClub.dao.impl;

import com.comedyClub.dao.IUserDao;
import com.comedyClub.domain.User;

import java.util.List;

public class UserDaoImpl extends BaseAbstractDao implements IUserDao {

    public UserDaoImpl() {
    }

    public void delete(User user) {
        super.deleteEntity(user);
    }

    public void deleteById(Long userId) {
        super.deleteEntityById(User.class, userId);
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return super.findAll(User.class);
    }

    public User getById(Long userId) {
        return (User) super.getEntityById(User.class, userId);
    }

    public User getByNameAndPassword(String name, String password) {
        String queryString = "from User u where u.name = :name and u.password = :password";

        List users = getHibernateTemplate()
                .findByNamedParam(queryString,
                        new String[]{"name", "password"},
                        new Object[]{name, password});

        return (User) users.get(0);
    }

    @SuppressWarnings("unchecked")
    public List<User> getUsersByName(String name) {

        String queryString = "from User u where u.name = :name";
        List usersList = getHibernateTemplate().findByNamedParam(queryString,
                new String[]{"name"},
                new Object[]{name});

        return usersList;
    }


    public void save(User user) {
        super.saveEntity(user);
    }

    public void update(User user) {
        super.updateEntity(user);
    }

}
