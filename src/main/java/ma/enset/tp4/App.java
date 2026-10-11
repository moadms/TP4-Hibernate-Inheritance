package ma.enset.tp4;

import ma.enset.tp4.joined.CamionLivraison;
import ma.enset.tp4.joined.VehiculeService;
import ma.enset.tp4.joined.VoitureTourisme;
import ma.enset.tp4.singletable.CompteBancaire;
import ma.enset.tp4.singletable.CompteCourant;
import ma.enset.tp4.singletable.CompteEpargne;
import ma.enset.tp4.tableperclass.ChefProjet;
import ma.enset.tp4.tableperclass.Collaborateur;
import ma.enset.tp4.tableperclass.Developpeur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App {

    public static void main(String[] args) {
        System.out.println("==============================================================");
        System.out.println(">>> DEMARRAGE DU TP4 - HIBERNATE STRATEGIES D'HERITAGE <<<");
        System.out.println("==============================================================");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp4_heritage_mapping");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // 1. Démonstration SINGLE_TABLE
            System.out.println("\n--- [1] STRATEGIE SINGLE_TABLE (Comptes Bancaires) ---");
            CompteCourant cc = new CompteCourant(14500.0, "Moad Moussaoui", 5000.0);
            CompteEpargne ce = new CompteEpargne(85000.0, "Moad Moussaoui", 3.25);
            em.persist(cc);
            em.persist(ce);

            // 2. Démonstration JOINED
            System.out.println("\n--- [2] STRATEGIE JOINED (Flotte de Véhicules) ---");
            VoitureTourisme voiture = new VoitureTourisme("12345-A-1", "Peugeot 308", 220000.0, 5, "Diesel");
            CamionLivraison camion = new CamionLivraison("67890-B-2", "Volvo FH16", 850000.0, 24.5, 3);
            em.persist(voiture);
            em.persist(camion);

            // 3. Démonstration TABLE_PER_CLASS
            System.out.println("\n--- [3] STRATEGIE TABLE_PER_CLASS (Collaborateurs) ---");
            Developpeur dev = new Developpeur("DEV-90", "Karim Bennani", 18000.0, "Java / Spring Boot", 2500.0);
            ChefProjet chef = new ChefProjet("CP-42", "Fatima Zahra", 26000.0, true, 500000.0);
            em.persist(dev);
            em.persist(chef);

            em.getTransaction().commit();
            System.out.println("✓ Toutes les entités ont été persistées avec succès.");

            // Requêtes Polymorphiques
            System.out.println("\n--- [4] REQUETES POLYMORPHES ---");
            List<CompteBancaire> comptes = em.createQuery("SELECT c FROM CompteBancaire c", CompteBancaire.class).getResultList();
            System.out.println("Total comptes trouvés : " + comptes.size());
            for (CompteBancaire c : comptes) {
                System.out.println(" - Compte #" + c.getNumero() + " (" + c.getClass().getSimpleName() + ") : Solde=" + c.getSolde() + " DH");
            }

            List<VehiculeService> vehicules = em.createQuery("SELECT v FROM VehiculeService v", VehiculeService.class).getResultList();
            System.out.println("Total véhicules trouvés : " + vehicules.size());
            for (VehiculeService v : vehicules) {
                System.out.println(" - Véhicule " + v.getImmatriculation() + " (" + v.getClass().getSimpleName() + ") : " + v.getMarque());
            }

            List<Collaborateur> collaborateurs = em.createQuery("SELECT col FROM Collaborateur col", Collaborateur.class).getResultList();
            System.out.println("Total collaborateurs trouvés : " + collaborateurs.size());
            for (Collaborateur col : collaborateurs) {
                System.out.println(" - Collaborateur " + col.getNom() + " (" + col.getClass().getSimpleName() + ") : Salaire=" + col.getSalaireBase() + " DH");
            }

            System.out.println("\n==============================================================");
            System.out.println(">>> EXECUTION DU TP4 TERMINEE AVEC SUCCES <<<");
            System.out.println("==============================================================");

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
