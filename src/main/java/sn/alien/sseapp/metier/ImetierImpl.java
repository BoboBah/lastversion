package sn.alien.sseapp.metier;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.alien.sseapp.classses.*;
import sn.alien.sseapp.dao.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service
@Transactional
public class ImetierImpl implements Imetier {



    @Autowired
    private MedcinRepository medcinRepository;
    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private TypeSoinsRepository typeSoinsRepository;
    @Autowired
    private TraitementRepository traitementRepository;

    @Autowired
    private FactureRepository factureRepository;

    @Autowired

    private AssuranceRepository assuranceRepository;

    @Autowired
    private ConditionPCRepository conditionPCRepository;

    @Autowired
    private AccidentRepository accidentRepository;


    @Autowired
    private AssureRepository assureRepository;

    @Autowired
    private BeneficiaireRepository beneficiaireRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    //-------------------gestion des medcin---------------------------
    @Override
    public void ajouterMedcin(Medecin m) {

        medcinRepository.save(m);

    }

    @Override
    public List<Medecin> consulterTousLesMedcin() {
        return medcinRepository.findAll();
    }

    @Override
    public Medecin getMedcin(Long idMecin) {

        return medcinRepository.getOne(idMecin);
    }

    @Override
    public List<Medecin> chercherMedcin(String mc) {
        return medcinRepository.checherMedcin("%"+mc+"%");
    }

    @Override
    public Page<Medecin> pagesMedcin(int page, int size) {
        return medcinRepository.findAll(new PageRequest(page, size));
    }

    @Override
    public Page<Medecin> chercherMedcinParPage(String mc, int page, int size) {
        return medcinRepository.chercherMedcinPages("%"+mc+"%", new PageRequest(page, size));
    }


    //----------------------------gestion des personnes---------------------------

    @Override
    public void ajouterPersonne(Personne p) {

        personneRepository.save(p);

    }

    @Override
    public List<Personne> consulterTousLesPersonnes() {

        return personneRepository.findAll();
    }

    @Override
    public Personne getPersonne(Long idPersonne) {

        return personneRepository.getByIdPersonne(idPersonne);
    }

    @Override
    public List<Personne> chercherPersonne(String mc) {

        return personneRepository.chercherPersonne("%"+mc+"%");
    }

    @Override
    public Page<Personne> pagesPersonnes(int page, int size) {

        return personneRepository.findAll(new PageRequest(page, size));
    }

    @Override
    public Page<Personne> chercherPersonneParPage(String mc, int page, int size) {

        return personneRepository.pagesPersonne("%"+mc+"%", new PageRequest(page, size));
    }

    @Override
    public Page<Personne> chercherPersonneParAssurance(String nomAssurance, int page, int size) {
        return personneRepository.chercherParNomAssurance("%"+nomAssurance+"%", new PageRequest(page, size));
    }

   // @Override
    //public List<Personne> chercherPersonneParAssuranceId(Long ninea) {
      //  return
        //        null;
   // }

    @Override
    public List<Personne> chercherPersonneParAssuranceId(Long ninea) {
        return personneRepository.chercherParIdAssurance(ninea);
    }


    //-----------------------gestion des types soins ------------------------------------

    @Override
    public void ajouterTypeSoins(TypeSoins typeSoins) {

        typeSoinsRepository.save(typeSoins);

    }

    @Override
    public List<TypeSoins> consulterTousLesSoins() {

        return typeSoinsRepository.findAll();
    }

    @Override
    public TypeSoins getTypeSoins(Long id) {

        return typeSoinsRepository.getOne(id);
    }

    @Override
    public Page<TypeSoins> pagesSoins(int page, int size) {

        return typeSoinsRepository.findAll(new PageRequest(page, size));
    }


    //-----------------------------------------gestion des traitement--------------------
    @Override
    public void ajouterTraitement(Medecin m, Personne p, TypeSoins typeSoins) {
        Traitement traitement = new Traitement();
        traitement.setMedecin(m);
        traitement.setTypeSoins(typeSoins);
        traitement.setDate(new Date());
        traitementRepository.save(traitement);


    }


    //---------------------ajouter feuile soins--------------------------------------------

    @Override
    public void ajouterFeuilleSoins(Medecin m, Beneficiaire b, Assure a, TypeSoins typeSoins) {


        assureRepository.save(a);


        beneficiaireRepository.save(b);


        typeSoinsRepository.save(typeSoins);





        Traitement traitement = new Traitement();


        traitement.setDate(new Date());

        traitement.setMedecin(m);

        traitement.setBeneficiaire(b);

        traitement.setAssure(a);

        traitement.setTypeSoins(typeSoins);

        traitementRepository.save(traitement);



    }

    @Override
    public void saveForm(Medecin m, Beneficiaire b, Assure a, TypeSoins typeSoins, Accident accident, ConditionPC conditionPC) {

        assureRepository.save(a);


        beneficiaireRepository.save(b);


        typeSoinsRepository.save(typeSoins);


        conditionPCRepository.save(conditionPC);


        //dont forgive to correct after
        //accidentRepository.save(accident);


        Traitement traitement = new Traitement();


        traitement.setDate(new Date());

        traitement.setMedecin(m);

        //dont forgot to correct after

        //traitement.setAccident(accident);

        traitement.setConditionPC(conditionPC);

        traitement.setBeneficiaire(b);

        traitement.setAssure(a);

        traitement.setTypeSoins(typeSoins);

        traitementRepository.save(traitement);


        //-------------------new code-------------------------

        ajouterFacture(traitement);


    }


    @Override
    public List<Traitement> consuletTousLesTraitement() {
        return traitementRepository.findAll();
    }

    @Override
    public Traitement getTraitement(Long id) {
        return traitementRepository.getOne(id);
    }



    @Override
    public Page<Traitement> pagesTraitement(int page, int size) {

        return traitementRepository.traitementParDate(new PageRequest(page, size));
    }

   // @Override
    //public Page<Traitement> getTraitementByMedcin(int idMedcin, int page, int size) {
      //  return null;
    //}

    @Override
    public Page<Traitement> getTraitementByMedcin(Long idMedcin, int page, int size) {
        return traitementRepository.chercherTraitementByMedcin(idMedcin, new PageRequest(page, size));
    }

    //----------------------------gestion des factures----------------------------

    @Override
    public void ajouterFacture(Traitement t) {

        Facture facture = new Facture();
        facture.setTraitement(t);
        facture.setDate(new Date());
        facture.EnCours();
        factureRepository.save(facture);

    }

    @Override
    public List<Facture> consulterTousLesFactures() {

        return factureRepository.findAll();
    }

    @Override
    public Facture getFacture(Long id) {

        return factureRepository.getByIdFacture(id);
    }

    @Override
    public Facture validerFacture(Long id) {

        Facture facture = factureRepository.getByIdFacture(id);
        facture.valider();
        return factureRepository.saveAndFlush(facture);
    }

    @Override
    public Page<Facture> pagesFacture(int page, int size) {

        return factureRepository.findAll(new PageRequest(page, size));
    }

    @Override
    public Page<Facture> facturesParMedecin(Medecin medecin, int page, int size) {
        return factureRepository.facturesParMedcin(medecin, new PageRequest(page, size));
    }

    @Override
    public Page<Facture> facturesParMedecinAssurance(Medecin medecin, Assurance assurance, int page, int size) {
        return factureRepository.facturesParMedcinAssurance(medecin, assurance, new PageRequest(page, size));
    }

    @Override
    public Page<Facture> facturesByEtat(String etat, int page, int size) {
        return factureRepository.pagesFactureByEtat(etat, new PageRequest(page, size));
    }

    @Override
    public Page<Facture> facturesByMedecin(Medecin m, int page, int size, String etat) {

        return factureRepository.pagesFacturesParMedcin(m, new PageRequest(page, size), etat);
    }

    @Override
    public int totalFacture(Medecin m, String etat){
        return factureRepository.totalFacture(m,etat);
    }

    @Override
    public Page<Facture> historiqueByMedecin(Medecin m, int page, int size) {

        return factureRepository.historiqueParMedcin(m, new PageRequest(page, size));
    }

    @Override
    public int totalHistorique(Medecin m){
        return factureRepository.totalHistorique(m);
    }

    @Override
    public Page<Facture> getFacuteByAssurance(Assurance a, int page, int size) {
        return factureRepository.pagesFacturesParAssurance(a, new PageRequest(page,size));
    }

    @Override
    public Page<Facture> getFactureByMedcin(Medecin m, int page, int size) {
        return null;
    }

    //--------------------gestion des assurances------------------------
    @Override
    public void ajouterAssurance(Assurance a) {
        assuranceRepository.save(a);
    }

    @Override
    public Assurance getAssurance(String nomAssurance) {
        return assuranceRepository.getByNomAssurance(nomAssurance);
    }

    @Override
    public Page<Assurance> pagesAssurance(int page, int size) {
        return assuranceRepository.findAll(new PageRequest(page, size));
    }

    @Override
    public Assurance giveAssuranceByUser(String username) {

        User user = userRepository.getOne(username);

        return assuranceRepository.getByUser(user);
    }

    //----------------service authentification---------------------------------------------------

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void addRole(Role role) {
        roleRepository.save(role);

    }

    @Override
    public User addRoleToUser(String username, String role) {


        User u = userRepository.getOne(username);

        Role r = roleRepository.getOne(role);

        u.getRoles().add(r);

        userRepository.save(u);

        return u;
    }
//--------------------user and role -------------------------------------------
    @Override
    public Map<String, Object> getLoged(HttpServletRequest httpServletRequest) {

        HttpSession httpSession = httpServletRequest.getSession();

        SecurityContext securityContext = (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");

        String username = securityContext.getAuthentication().getName();

        List<String> roles = new ArrayList<>();

        for (GrantedAuthority ga : securityContext.getAuthentication().getAuthorities())

        {
            roles.add(ga.getAuthority());


        }

        Map<String, Object> params = new HashMap<>();

        params.put("username", username);

        params.put("roles", roles);

        return params;
    }

    //------------------recupere le username de l'utilisateur------------------------------

    @Override
    public String getUsername(HttpServletRequest httpServletRequest) {

        HttpSession httpSession = httpServletRequest.getSession();

        SecurityContext securityContext = (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");

        String username = securityContext.getAuthentication().getName();

        return username;
    }

    @Override
    public Medecin getMedecinByUser(String username) {


        User user = userRepository.getOne(username);

        Medecin medecin = medcinRepository.getByUser(user);


        return medecin;
    }

    //-----------------------------------------------------------------







}
