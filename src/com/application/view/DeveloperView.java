package com.application.view;

import com.application.controller.AccountControler;
import com.application.controller.Controller;
import com.application.controller.SkillController;
import com.application.model.Account;
import com.application.model.Developer;
import com.application.model.Skill;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeveloperView implements View {
    private Controller<Developer> controller;

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void viewCreate() {
        controller.create(createDev());
    }

    @Override
    public void viewGetById() {
        while (true) {
            ConsoleHelper.writeToConsole("Input ID:");
            try {
                int id = Integer.parseInt(ConsoleHelper.readString());
                writeById(controller.get(id));
                break;
            } catch (IOException e) {
                ConsoleHelper.writeToConsole("Wrong ID. Try again.\n");
            }
        }
    }

    private void writeById(Developer dev) {
        if (dev == null || (dev.getId() == 0 && dev.getName() == null)) {
            ConsoleHelper.writeToConsole("\nThere is no such ID\n");
        } else {
            ConsoleHelper.writeToConsole("\n" + dev.toString() + "\n");
        }
    }

    @Override
    public void viewGetAll() {
        List<Developer> developers = controller.list();
        if (developers.isEmpty()) {
            ConsoleHelper.writeToConsole("\nThere are no records to view.\n");
        } else {
            for (Developer dev : developers) {
                ConsoleHelper.writeToConsole(String.valueOf(dev));
            }
        }
    }

    @Override
    public void viewUpdate() {
        ConsoleHelper.writeToConsole("Creating Developer for update ...");
        controller.update(createDev());
    }

    @Override
    public void viewDelete() {
        while (true) {
            ConsoleHelper.writeToConsole("Input ID:");
            try {
                int id = Integer.parseInt(ConsoleHelper.readString());
                controller.remove(id);
                break;
            } catch (IOException e) {
                ConsoleHelper.writeToConsole("Wrong ID. Try again.\n");
            }
        }
    }

    private Developer createDev() {
        Developer developer;
        int id;
        String devName;
        Account account;
        Set<Skill> skills = new HashSet<>();

        while (true) {
            try {
                ConsoleHelper.writeToConsole("Input ID");
                id = Integer.parseInt(ConsoleHelper.readString());
                break;
            } catch (IOException e) {
                ConsoleHelper.writeToConsole("Wrong integer. Try again");
            }
        }
        while (true) {
            try {
                ConsoleHelper.writeToConsole("Input Name Developer");
                devName = ConsoleHelper.readString();
                break;
            } catch (IOException e) {
                ConsoleHelper.writeToConsole("Failed input. Try again");
            }
        }
        while (true) {
            try {
                ConsoleHelper.writeToConsole("Input Account of you repository");
                String acname = ConsoleHelper.readString();
                account = new Account(id, acname);
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            try {
                ConsoleHelper.writeToConsole("Input skill's  of developer: (for finish input 'exit')");
                String str;
                ArrayList<String> idSet = new ArrayList<>();
                while (!(str = ConsoleHelper.readString()).equalsIgnoreCase("exit")) {
                    try {
                        idSet.add(str);
                    } catch (NumberFormatException e) {
                        ConsoleHelper.writeToConsole("Wrong integer. Try again");
                    }
                }
                SkillController controller = new SkillController();
                Skill skill = (new Skill(idSet, id));
                controller.create(skill);
                skills.add(skill);

                AccountControler controler = new AccountControler();
                controler.create(account);
                developer = new Developer(id, devName);
                developer.setSkills(skills);
                developer.setAccount(account);
                return developer;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
