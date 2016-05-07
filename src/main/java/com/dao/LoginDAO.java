package com.dao;

// <editor-fold defaultstate="collapsed" desc=" imports ">
import com.entities.LoginEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// </editor-fold>

/**
 *
 * @author umarsaeed
 */
@Repository
public class LoginDAO implements ILoginDAO, Serializable {

    @Autowired
    protected SessionFactory sessionFactory;

    Logger logger = Logger.getLogger(LoginDAO.class.getName());

    @Override
    public List<LoginEntity> getLoginUsers() {
        logger.log(Level.INFO, "get All Login Users");
        List<LoginEntity> users = new ArrayList<LoginEntity>();
        try {
            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LoginEntity.class);
            users = (List<LoginEntity>) criteria.list();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An exception when get all login users");
        }
        return users;
    }

    @Override
    public LoginEntity authenticateUser(String email, String password) {
        try {
            logger.log(Level.INFO, "authenticate login User");
            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LoginEntity.class);
            criteria.add(Restrictions.eq("email", email));
            criteria.add(Restrictions.eq("password", password));
            List<LoginEntity> users = (List<LoginEntity>) criteria.list();
            if (users.size() > 0) {
                return users.get(0);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An exception when authenticate login User");
        }
        return null;
    }

    @Override
    public LoginEntity getLoginUser(Integer id) {
        try {
            logger.log(Level.INFO, "get Login User by id");
            List<LoginEntity> users = null;
            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LoginEntity.class);
            criteria.add(Restrictions.eq("id", id));
            users = (List<LoginEntity>) criteria.list();
            if (users.size() > 0) {
                return users.get(0);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An exception when get login User by id:" + id);
        }
        return null;
    }

}
