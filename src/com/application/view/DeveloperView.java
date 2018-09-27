package com.application.view;

import com.application.controller.DeveloperController;
import com.application.model.Account;
import com.application.model.Developer;
import com.application.model.Skill;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeveloperView {
    private DeveloperController controller = new DeveloperController();

    public void viewCreate() {
        controller.create(createDev(0));
    }

    public void viewGetById() {
        while (true) {
            ConsoleHelper.writeToConsole("Input ID:");
            try {
                Long id = Long.valueOf(Integer.parseInt(ConsoleHelper.readString()));
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
            ConsoleHelper.writeToConsole("\n" + "ID = " + dev.getId() + " || Name: " + dev.getName() + " || Skill:" +
                    dev.getSkills() + " || Account:  " + dev.getAccount() + "\n");
        }
    }


    public void viewGetAll() {
        List<Developer> developers = controller.list();
        if (developers.isEmpty()) {
            ConsoleHelper.writeToConsole("\nThere are no records to view.\n");
        } else {
            for (Developer dev : developers) {
                ConsoleHelper.writeToConsole("\n" + "ID = " + dev.getId() + " || Name: " + dev.getName() + " || Skill:" +
                        dev.getSkills() + " || Account:  " + dev.getAccount());
            }
        }
    }


    public void viewUpdate() {
        ConsoleHelper.writeToConsole("Creating Developer for update ...");


        controller.update(createDev(1));
    }

    public void viewDelete() {
        while (true) {
            ConsoleHelper.writeToConsole("Input ID:");
            try {
                Long id = Long.valueOf(ConsoleHelper.readString());
                controller.remove(id);
                break;
            } catch (IOException e) {
                ConsoleHelper.writeToConsole("Wrong ID. Try again.\n");
            }
        }
    }

    private Developer createDev(int i) {
        Developer developer;
        Long id = 0l;
        String devName;
        Account account;
        Set<Skill> skills = new HashSet<>();

        if (i > 0) {
            while (true) {
                try {
                    ConsoleHelper.writeToConsole("Input ID");
                    id = Long.valueOf(ConsoleHelper.readString());
                    break;
                } catch (IOException e) {
                    ConsoleHelper.writeToConsole("Failed input. Try again");
                }
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
                    {
                        try {
                            idSet.add(str);
                        } catch (NumberFormatException e) {
                            ConsoleHelper.writeToConsole("Wrong integer. Try again");
                        }
                    }
                }
                if (idSet.size() <= 0)
                    idSet.add("NULL");
                for (String list : idSet) {

                    skills.add(new Skill(id, list));
                }
                break;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new Developer(id, devName, skills, account);
    }

}

