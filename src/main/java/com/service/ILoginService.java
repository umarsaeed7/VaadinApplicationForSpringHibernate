package com.service;

// <editor-fold defaultstate="collapsed" desc=" imports ">
import com.entities.LoginEntity;
import java.util.List;
// </editor-fold>

/**
 *
 * @author umarsaeed
 */
public interface ILoginService {

    List<LoginEntity> getAllLoginUser();

    LoginEntity authenticateEndUser(String email, String password);

    LoginEntity getLoginUser(Integer id);

}
