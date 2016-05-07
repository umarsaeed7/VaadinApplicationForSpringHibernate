package com.controller;

// <editor-fold defaultstate="collapsed" desc=" imports ">
import com.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
// </editor-fold>

/**
 *
 * @author umarsaeed
 */
@Component
public class ApplicationController {

    @Autowired
    private ILoginService loginService;

    // <editor-fold defaultstate="collapsed" desc=" Screens specific setter/getter methods ">
    /**
     * @return the loginService
     */
    public ILoginService getLoginService() {
        return loginService;
    }

    /**
     * @param loginService the loginService to set
     */
    public void setLoginService(ILoginService loginService) {
        this.loginService = loginService;
    }
    //</editor-fold>
}
