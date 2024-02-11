import config.SessionFactoryConfig;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInitializer {
    public static void main(String[] args) {

        Session session = SessionFactoryConfig
                .getInstance()
                .getSession();


        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer();
        customer.setId(4);
        customer.setName("John Doe");
        customer.setAddress("Colombo");
        customer.setSalary(100000);

        session.save(customer);
        transaction.commit();

        //////////////////////////////////////////////////////////////////////////////////////

//get session

        System.out.println("Get Customer");
        Session getSession = SessionFactoryConfig
                .getInstance()
                .getSession();

        Customer exists = getSession.get(Customer.class,1);
        System.out.println(exists);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Update Customer");
     //update session
        Session updateSession = SessionFactoryConfig
                .getInstance()
                .getSession();


        Transaction updateTransaction = updateSession.beginTransaction();

        Customer existsCus = updateSession.get(Customer.class,1);
        existsCus.setAddress("Matara");
        updateSession.update(existsCus);
        updateTransaction.commit();
        updateSession.close();

        ///////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Delete Customer");
//delete session
        Session deleteSession = SessionFactoryConfig
                .getInstance()
                .getSession();

        Transaction deleteTransaction = deleteSession.beginTransaction();

        Customer existedeleteCus = deleteSession.get(Customer.class,1);
        deleteSession.delete(existedeleteCus);
        deleteTransaction.commit();
        deleteSession.close();
    }
}