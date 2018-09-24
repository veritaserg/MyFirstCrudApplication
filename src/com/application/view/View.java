package com.application.view;

import com.application.controller.Controller;

public interface View {
    void setController(Controller controller);

    void viewCreate();

    void viewGetById();

    void viewGetAll();

    void viewUpdate();

    void viewDelete();
}


