package com.application.view;

import com.application.controller.Controller;
import com.application.controller.DeveloperController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    View view;

    public void startApp() {
        view = new DeveloperView();
        Controller controller = new DeveloperController();
        view.setController(controller);
        showCommandsMenu();
    }

    private void showCommandsMenu() {
        while (true) {
            try {
                writeToConsole("\nSelect command:\n\n" +
                        "0 - Create Developer\n" +
                        "1 - Select all\n" +
                        "2 - Select by id\n" +
                        "3 - Update by id\n" +
                        "4 - Delete by id\n" +
                        "5 - Exit\n");
                switch (Integer.parseInt(readString())) {
                    case 0:
                        view.viewCreate();
                        break;
                    case 1:
                        view.viewGetAll();
                        break;
                    case 2:
                        view.viewGetById();
                        break;
                    case 3:
                        view.viewUpdate();
                        ConsoleHelper.writeToConsole("Command executed successfully.");
                        break;
                    case 4:
                        view.viewDelete();
                        ConsoleHelper.writeToConsole("Command executed successfully.");
                        break;
                    case 5:
                        return;

                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IOException e) {
                writeToConsole(e.getMessage());
            } catch (IllegalArgumentException e) {
                writeToConsole(e.getMessage());
                writeToConsole("Wrong command. Try again.");
            }
        }
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static void writeToConsole(String message) {
        System.out.println(message);
    }
}
