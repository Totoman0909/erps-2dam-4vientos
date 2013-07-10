
package info.pello.maven.hibernate.HibernateSamples;

/**
 * @author root
 *
 */


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
  
/**
 * provide Hibernate Session factory
 * @author Pello Xabier Altadill Izura
 * @greetz family
 */
public class HibernateSession {
  
    private static final SessionFactory sessionFactory = buildSessionFactory();
  
    /**
     * Based on hibernate.cfg.xml configuration creates
     * a SessionFactory
     * @return the session factory
     */
    private static SessionFactory buildSessionFactory() {
            Configuration configuration = new Configuration();
            configuration.configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
    }
  
    /**
     * this gives the desired session factory
     * @return hibernate Session Factory instance
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}