import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main ( String[] args ) {
            EntityManagerFactory emf =
                    Persistence.createEntityManagerFactory("vehicle_hierarchy_table_per_class");
            EntityManager entityManager = emf.createEntityManager();

            entityManager.getTransaction().begin();

            entityManager.getTransaction ().commit ();
            entityManager.close ();
    }
}
