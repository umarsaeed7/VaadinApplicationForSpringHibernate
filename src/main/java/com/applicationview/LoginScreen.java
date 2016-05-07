package com.applicationview;

// <editor-fold defaultstate="collapsed" desc=" imports ">
import com.controller.ApplicationController;
import com.entities.LoginEntity;
import com.vaadin.event.Action;
import com.vaadin.event.Action.Handler;
import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.Notification;
// </editor-fold>

/**
 *
 * @author umarsaeed
 */
public class LoginScreen extends Window {

    private ApplicationController controller;

    private static final String LOGIN_ERROR_MSG = "<br/><br/>Please check your email-address and password.<ul><li>user@test.com/12345</li></ul>";

    private final ShortcutAction ENTER_KEY = new ShortcutAction("Login", ShortcutAction.KeyCode.ENTER, null);

    TextField email = new TextField("Email address");
    PasswordField password = new PasswordField("Password");

    Button loginButton = new Button("Log In", new Button.ClickListener() {
        public void buttonClick(ClickEvent event) {
            tryToLogIn();
        }
    });

    public LoginScreen(ApplicationController controller) {
        this.controller = controller;
        setCaption("Application - login");
        center();
        setWidth("200px");
        setHeight("200px");
        setClosable(false);
        setScrollable(false);
        setDraggable(false);
        setResizable(false);

        // Layout
        VerticalLayout layout = new VerticalLayout();
        setContent(layout);
        addComponent(email);
        email.focus();
        addComponent(password);
        addComponent(loginButton);
        layout.addComponent(email);
        layout.addComponent(password);
        layout.addComponent(loginButton);
        layout.setSpacing(true);
        layout.setMargin(true);

        // Keyboard navigation - enter key is a shortcut to login
        addActionHandler(new Handler() {
            public Action[] getActions(Object target, Object sender) {
                return new Action[]{ENTER_KEY};
            }

            public void handleAction(Action action, Object sender, Object target) {
                tryToLogIn();
            }
        });
    }

    private void tryToLogIn() {
        LoginEntity loginUser = controller.getLoginService().authenticateEndUser(email.getValue().toString(), password.getValue().toString());
        if (loginUser != null) {
            getApplication().setUser(loginUser);
        } else {
            getWindow().showNotification("Login failed", LOGIN_ERROR_MSG, Notification.TYPE_WARNING_MESSAGE);
        }
    }
}
