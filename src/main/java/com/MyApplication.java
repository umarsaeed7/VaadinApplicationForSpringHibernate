package com;

// <editor-fold defaultstate="collapsed" desc=" imports ">
import com.controller.ApplicationController;
import com.applicationview.MainScreen;
import com.applicationview.LoginScreen;
import com.vaadin.Application;
import com.vaadin.ui.Window;
import org.springframework.beans.factory.annotation.Autowired;
// </editor-fold>

/**
 *
 * @author umarsaeed
 */
@SuppressWarnings("serial")
public class MyApplication extends Application {

    private LoginScreen loginScreen;
    private MainScreen mainScreen;
    private Window mainWindow;

    @Autowired
    ApplicationController controller;

    @Override
    public void init() {
        mainWindow = new Window();
        mainScreen = new MainScreen(controller);
        loginScreen = new LoginScreen(controller);
        mainWindow.addWindow(loginScreen);
        setMainWindow(mainWindow);
    }

    @Override
    public void setUser(Object user) {
        super.setUser(user);

        if (user != null) {
            mainWindow.removeWindow(loginScreen);
            mainScreen.setValues(user);
            mainWindow.addComponent(mainScreen);
        }
    }
}
