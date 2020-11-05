package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;


    public String buildTrelloCardEmail(String message){
        List<String> motivation = new ArrayList<>();
        motivation.add("Yes, you can do it!");
        motivation.add("Everything is possible!");
        motivation.add("The world is not enough!");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "https://trello.com/");
        context.setVariable("button", "Click here and go to work!");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("good_bye", "May the force be with you.... :)");
        context.setVariable("show_button", true);
        context.setVariable("is_male", true);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_motivation", motivation);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }
}
