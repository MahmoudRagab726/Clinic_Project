/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author Mahmoud Ragab
 */
public class Connect {
    
    static SessionFactory sessionFactory;
    static Session session;
    
    
    public static Session openSessions(){
        session = sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }
    
    public static void closeSessions(){
        session.getTransaction().commit();
        session.close();
    }
    
    public static void config(){
         Configuration config = new Configuration().configure();
        //2
        ServiceRegistry serviceregistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        //3
         sessionFactory = config.buildSessionFactory(serviceregistry);
        
    }
}
 
