package com.application.view;

import com.application.controller.SkillController;
import com.application.model.Skill;

import java.util.List;

public class SkillView {
    SkillController sc = new SkillController();

    public void viewGetAll() {
        List<Skill> skills = sc.list();
        if (skills.isEmpty()) {
            ConsoleHelper.writeToConsole("\nThere are no records to view.\n");
        } else {
            for (Skill skill : skills) {
                ConsoleHelper.writeToConsole("\n" + "ID = " + skill.getId().toString() + " || Skills: " + skill.getName());
            }
        }
    }

}

