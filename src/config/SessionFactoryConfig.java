package config;

import entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;
    private final SessionFactory sessionFactory;
    private SessionFactoryConfig() {
        // private constructor

        //1. create a service registry
        StandardServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder()
                        .build();

        //2. create a metadata source

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Customer.class)//addAnnotatedClass() is used to add the annotated class to the metadata

                // addAnnotatedClass() is used to add the annotated class to the metadata
                .getMetadataBuilder()
                .build();

        //3. create a session factory
        sessionFactory = metadata
                .buildSessionFactory();



    }

    public static SessionFactoryConfig getInstance() {
        return  (factoryConfig == null) ?
            factoryConfig = new SessionFactoryConfig()
                : factoryConfig;
    }

    public Session getSession() {


        //4. create a session and open a transaction
       return sessionFactory.openSession();

       //5. close the session
    }
}
