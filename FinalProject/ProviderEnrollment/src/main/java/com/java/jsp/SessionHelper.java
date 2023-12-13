package com.java.jsp;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionHelper {

    public static SessionFactory getConnection() {
        Configuration configuration = new Configuration().configure();
        return configuration.buildSessionFactory();
    }

}
