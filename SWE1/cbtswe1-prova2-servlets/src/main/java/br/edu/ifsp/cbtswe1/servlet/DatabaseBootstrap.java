package br.edu.ifsp.cbtswe1.servlet;

import br.edu.ifsp.cbtswe1.dao.Database;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DatabaseBootstrap implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Database.initialize();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
