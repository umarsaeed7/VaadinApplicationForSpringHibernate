package com.dao;

// <editor-fold defaultstate="collapsed" desc=" imports ">
import com.entities.LoginEntity;
import java.util.List;
// </editor-fold>

/**
 *
 * @author umarsaeed
 */
public interface ILoginDAO {

    public List<LoginEntity> getLoginUsers();

    LoginEntity authenticateUser(String email, String password);

    LoginEntity getLoginUser(Integer id);
}
