package com.service;

// <editor-fold defaultstate="collapsed" desc=" imports ">
import com.entities.LoginEntity;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.ILoginDAO;
// </editor-fold>
/**
 *
 * @author umarsaeed
 */
@Service
public class LoginService implements ILoginService, Serializable {

    @Autowired
    private ILoginDAO loginUserDAO;

    @Override
    @Transactional
    public List<LoginEntity> getAllLoginUser() {
        return loginUserDAO.getLoginUsers();
    }

    @Override
    @Transactional
    public LoginEntity authenticateEndUser(String email, String password) {
        return loginUserDAO.authenticateUser(email, password);
    }

    @Override
    @Transactional
    public LoginEntity getLoginUser(Integer id) {
        return loginUserDAO.getLoginUser(id);
    }

}
