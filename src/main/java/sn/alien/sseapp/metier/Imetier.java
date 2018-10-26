package sn.alien.sseapp.metier;




import org.springframework.data.domain.Page;
import sn.alien.sseapp.classses.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


public interface Imetier {

    //-----------gestion des medcins ----------------------------------

    public void ajouterMedcin(Medecin m);

    public List<Medecin> consulterTousLesMedcin();

    public Medecin getMedcin(Long idMecin);

    public List<Medecin> chercherMedcin(String mc);

    public Page<Medecin> pagesMedcin(int page, int size);

    public Page<Medecin> chercherMedcinParPage(String mc, int page, int size);



    //---------------gestion des personnnes------------------------

    public void ajouterPersonne(Personne p);

    public List<Personne> consulterTousLesPersonnes();

    public Personne getPersonne(Long idPersonne);

    public List<Personne> chercherPersonne(String mc);

    public Page<Personne> pagesPersonnes(int page, int size);

    public Page<Personne> chercherPersonneParPage(String mc, int page, int size);

    public Page<Personne> chercherPersonneParAssurance(String nomAssurance, int page, int size);

    public List<Personne> chercherPersonneParAssuranceId(Long ninea);

    //------------------gestion des types de soins---------------------

    public void ajouterTypeSoins(TypeSoins typeSoins);

    public List<TypeSoins> consulterTousLesSoins();

    public TypeSoins getTypeSoins(Long id);

    public Page<TypeSoins> pagesSoins(int page, int size);

    //-----------------------gestion des traitements--------------------

    public void ajouterTraitement(Medecin m, Personne p, TypeSoins typeSoins);

    public void ajouterFeuilleSoins(Medecin m, Beneficiaire b, Assure a, TypeSoins typeSoins);


    public void saveForm(Medecin m, Beneficiaire b, Assure a, TypeSoins typeSoins, Accident accident, ConditionPC conditionPC);

    public List<Traitement> consuletTousLesTraitement();

    public Traitement getTraitement(Long id);

    public Page<Traitement> pagesTraitement(int page, int size);

    public Page<Traitement> getTraitementByMedcin(Long idMedcin, int page, int size);

    //----------------gestion des factures---------------------------------

    public void ajouterFacture(Traitement t);

    public List<Facture> consulterTousLesFactures();

    public Facture getFacture(Long id);

    public Facture validerFacture(Long id);

    public Page<Facture> pagesFacture(int page, int size);

    public Page<Facture> facturesParMedecin(Medecin medecin, int page, int size);

    public Page<Facture> facturesParMedecinAssurance(Medecin medecin, Assurance assurance, int page, int size);


    public Page<Facture> facturesByEtat(String etat, int page, int size);

    public Page<Facture> facturesByMedecin(Medecin m, int page, int size, String etat);

    public Page<Facture> historiqueByMedecin(Medecin m, int page, int size);

    public Page<Facture> getFacuteByAssurance(Assurance a, int page, int size);

    public Page<Facture> getFactureByMedcin(Medecin m, int page, int size);

    public int totalFacture(Medecin m, String etat);
    public int totalHistorique(Medecin m);
    //-------------------gestion des assurances----------------------

    public void ajouterAssurance(Assurance a);

    public Assurance getAssurance(String nomAssurance);

    public Page<Assurance> pagesAssurance(int page, int size);

    public Assurance giveAssuranceByUser(String username);


    //-------------------service authentification--------------------------

    public void addUser(User user);

    public void addRole(Role role);

    public User addRoleToUser(String username, String role);


    public Map<String, Object> getLoged(HttpServletRequest httpServletRequest);

    public String getUsername(HttpServletRequest httpServletRequest);

    public Medecin getMedecinByUser(String username);



}
