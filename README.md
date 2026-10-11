# TP 4 : Héritage avec Hibernate - Stratégies de Mapping

Ce projet implémente et compare les trois stratégies de mapping d'héritage objet-relationnel fournies par **JPA** et **Hibernate ORM** avec une base de données **H2**.

---

## 1. Les 3 Stratégies d'Héritage implémentées

### Stratégie 1 : `SINGLE_TABLE` (Une seule table par hiérarchie)
- **Hiérarchie :** `CompteBancaire` (racine) $\rightarrow$ `CompteCourant` & `CompteEpargne`.
- **Principe :** Une unique table `t_comptes_bancaires` stocke tous les enregistrements. Une colonne discriminante `@DiscriminatorColumn(name = "type_compte")` distingue les types (`COURANT` / `EPARGNE`).
- **Avantage :** Excellentes performances en lecture (aucun JOIN nécessaire).
- **Inconvénient :** Colonnes spécifiques nullables.

### Stratégie 2 : `JOINED` (Table par sous-classe avec jointure)
- **Hiérarchie :** `VehiculeService` (racine) $\rightarrow$ `VoitureTourisme` & `CamionLivraison`.
- **Principe :** Une table pour la classe mère (`t_vehicules_parc`) contenant les attributs communs, et une table dédiée pour chaque classe fille (`t_voitures_tourisme`, `t_camions_livraison`) liée par clé étrangère / clé primaire.
- **Avantage :** Schéma relationnel normalisé sans colonnes nulles superflues.
- **Inconvénient :** Requêtes polymorphes nécessitant des jointures SQL (`LEFT OUTER JOIN`).

### Stratégie 3 : `TABLE_PER_CLASS` (Une table par classe concrète)
- **Hiérarchie :** `Collaborateur` (abstraite) $\rightarrow$ `Developpeur` & `ChefProjet`.
- **Principe :** Chaque classe concrète possède sa propre table autonome (`t_collaborateurs_dev`, `t_collaborateurs_chef`) contenant la totalité des attributs.
- **Avantage :** Modèle physique simple par entité.
- **Inconvénient :** Les requêtes sur la classe mère utilisent des `UNION ALL`.

---

## 2. Traces des Requêtes Polymorphes Réalisées

```sql
-- Consultation polymorphe SINGLE_TABLE
SELECT * FROM t_comptes_bancaires;

-- Consultation polymorphe JOINED
SELECT * FROM t_vehicules_parc v
LEFT JOIN t_voitures_tourisme vt ON v.id_vehicule = vt.id_voiture
LEFT JOIN t_camions_livraison cl ON v.id_vehicule = cl.id_camion;

-- Consultation polymorphe TABLE_PER_CLASS
SELECT * FROM (
    SELECT id_collaborateur, nom_prenom, salaire_base FROM t_collaborateurs_chef
    UNION ALL
    SELECT id_collaborateur, nom_prenom, salaire_base FROM t_collaborateurs_dev
);
```

---

## 3. Démarrage et Exécution

```bash
# Compilation et test
mvn clean compile exec:java "-Dexec.mainClass=ma.enset.tp4.App"
```
