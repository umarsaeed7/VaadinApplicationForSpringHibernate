package com.applicationview;

// <editor-fold defaultstate="collapsed" desc=" imports ">
import com.controller.ApplicationController;
import com.entities.LoginEntity;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Table;
import java.util.List;
// </editor-fold>

/**
 *
 * @author umarsaeed
 */
public class MainScreen extends GridLayout {

    ApplicationController controller;

    public MainScreen(ApplicationController controller) {
        this.controller = controller;
    }

    public void setValues(Object user) {
        Table table = new Table("User Table");
        table.setSelectable(true);

        table.addContainerProperty("id", Integer.class, null, "Id", null, null);
        table.addContainerProperty("name", String.class, null, "Name", null, null);
        table.addContainerProperty("email", String.class, null, "Email", null, null);

        int indx = 0;
        List<LoginEntity> ueList = this.controller.getLoginService().getAllLoginUser();
        for (LoginEntity ue : ueList) {
            indx += 1;
            table.addItem(new Object[]{ue.getId(), ue.getName(), ue.getEmail()}, indx);
        }
        this.addComponent(table);
        table.setPageLength(table.size());
    }

}
