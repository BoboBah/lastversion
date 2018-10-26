package sn.alien.sseapp.web;





import com.itextpdf.text.DocumentException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.xhtmlrenderer.pdf.ITextRenderer;
import sn.alien.sseapp.classses.*;
import sn.alien.sseapp.metier.Imetier;
import sn.alien.sseapp.sendemail.SmptMailSender;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
@CrossOrigin("*")
public class SseController {


    public static final String OUTPUT_FILE ="C:\\Users\\hp-pc\\Desktop\\sseapp\\src\\main\\resources\\pdfs\\testpdf19.pdf";

    public static final String TARGET = "C:\\Users\\hp-pc\\Desktop\\sseapp\\src\\main\\resources\\pdfs\\";

    public static final String DEST = String.format("%stest.pdf", TARGET);



    private List<String> myListOfStrings;



    @Autowired
    private Imetier metier;

    @Autowired
    private SmptMailSender smptMailSender;


    @RequestMapping(value = "/indexn", method = RequestMethod.GET)
    public String indexn()
    {



        return "index";
    }


    //-----------------login---------------------------------
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }



    //------------------------service des medcins-----------------------------------
    @RequestMapping(value = "/medecins", method = RequestMethod.GET)
    public String getAllMedecins(Model model, @RequestParam(name = "motCle", defaultValue = "") String mc,
                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "size", defaultValue = "2") int size)

    {


        Page<Medecin> medecins = metier.chercherMedcinParPage(mc, page, size);


        int nbPages = medecins.getTotalPages();

        int [] pages = new int[nbPages];

        for (int i=0; i<nbPages; i++)
        {
            pages[i]=i;
        }

        model.addAttribute("pages", pages);

        model.addAttribute("pageCourante", page);

        model.addAttribute("medecins", medecins);


        model.addAttribute("motCle", mc);


        return "medecins";
    }


    //--------------------------les medecins-----------------------------------------

    @RequestMapping(value = "/lesmedecins", method = RequestMethod.GET)
    public String lesmedecins(Model model, @RequestParam(name = "motCle", defaultValue = "") String mc,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "size", defaultValue = "6") int size)

    {


        Page<Medecin> medecins = metier.chercherMedcinParPage(mc, page, size);


        int nbPages = medecins.getTotalPages();

        int [] pages = new int[nbPages];

        for (int i=0; i<nbPages; i++)
        {
            pages[i]=i;
        }

        model.addAttribute("pages", pages);

        model.addAttribute("pageCourante", page);

        model.addAttribute("medecins", medecins);


        model.addAttribute("motCle", mc);


        return "lesmedecins";
    }

    //------------------dossiers medecins------------------------------------------------
    @RequestMapping(value = "/assurance/dossier/dossiermedecins", method = RequestMethod.GET)
    public String dossiermedecins(Model model, @RequestParam(name = "motCle", defaultValue = "") String mc,
                                  @RequestParam(name = "page", defaultValue = "0") int page,
                                  @RequestParam(name = "size", defaultValue = "6") int size)

    {


        Page<Medecin> medecins = metier.chercherMedcinParPage(mc, page, size);


        int nbPages = medecins.getTotalPages();

        int [] pages = new int[nbPages];

        for (int i=0; i<nbPages; i++)
        {
            pages[i]=i;
        }

        model.addAttribute("pages", pages);

        model.addAttribute("pageCourante", page);

        model.addAttribute("medecins", medecins);


        model.addAttribute("motCle", mc);


        return "a_dossierMedecin";
    }








    //-------------------------------ajouter un medcin-----------------------------------
    @RequestMapping(value = "/save", method = RequestMethod.POST)

    public String saveMedecin(Medecin m)
    {


        System.out.println("-------------------------");
        System.out.println(m.getNom());
        System.out.println("---------------------------");

        metier.ajouterMedcin(m);


        return "redirect:/lesmedecins";
    }

    //--------------------------ajouter medecin et son user-------------

    @RequestMapping(value = "/MedecinToUser", method = RequestMethod.POST)


    public String MedecinToUser(Medecin m, User user)


    {
        System.out.println("----------------------");

        System.out.println(m.getNom());

        System.out.println("------------------------");

        metier.addUser(user);


        m.setUser(metier.addRoleToUser(user.getUsername(), "admin"));


        metier.ajouterMedcin(m);

        return "redirect:/lesmedecins";

    }

    @RequestMapping(value = "/inscription/medecin", method= RequestMethod.GET)
    public String inscriptionMedecin(Model model)


    {
        model.addAttribute("medecin", new Medecin());

        model.addAttribute("user", new User());

        return "register-medecin";
    }
    //----------------------medecin and user----------------------------------------

   /* @RequestMapping(value = "/MedecinAndUser", method = RequestMethod.GET)

    public String MedecinAndUser(Model model)
    {

        model.addAttribute("medecin", new Medecin());

        model.addAttribute("user", new User());

        return "register-medecin";
    }*/


    //---------------------------ajouter un medcin------------------------------------------
    @RequestMapping(value = "/addPraticien", method = RequestMethod.GET)

    public String addMedecin(Model model)
    {

        model.addAttribute("medecin", new Medecin());

        model.addAttribute("user", new User());

        return "saveMedecin";
    }






    //--------------------------service des personnes-------------------------------------

    @RequestMapping(value = "/personnes", method = RequestMethod.GET)

    public String getAllPersonnes(Model model, @RequestParam(name = "motCle", defaultValue = "") String mc,

                                  @RequestParam(name = "page", defaultValue = "0") int page,

                                  @RequestParam(name = "size", defaultValue = "5") int size)




    {


        Page<Personne> personnes = metier.chercherPersonneParPage(String.valueOf(mc), page, size);


        int nbPages = personnes.getTotalPages();

        int [] pages = new int[nbPages];

        for (int i=0; i<nbPages; i++)
        {
            pages[i]=i;
        }

        model.addAttribute("pages", pages);

        model.addAttribute("pageCourante", page);

        model.addAttribute("personnes", personnes);


        model.addAttribute("motCle", mc);



        return "personnes";
    }

    //---------------------------ajouter une personne---------------------------------------

    @RequestMapping(value = "/savePersonne", method = RequestMethod.POST)
    public String savePersonne(Personne p)
    {
        System.out.println(p.getAssurance());

        metier.ajouterPersonne(p);

        return "redirect:/personnes";
    }

    //-------------------------------ajouter une personne---------------------------------------

    @RequestMapping(value = "/addPersonne", method = RequestMethod.GET)

    public String addPersonne(Model model)
    {
        String param = "Nom Assurance";

        model.addAttribute("personne", new Personne());
        model.addAttribute("param", param);


        return "ajouterPersonne";
    }


    //------------------------ajouter personne suivant un assurance----------------------

    @RequestMapping(value = "/ajouter", method = RequestMethod.POST)

    public String ajouter(Personne p, String param)

    {
        Assurance assurance = metier.getAssurance(param);

        p.setAssurance(assurance);

        metier.ajouterPersonne(p);

        return "redirect:/personnes";

    }



    //---------------------------service des assurances------------------------------------
    @RequestMapping(value = "/assurances", method = RequestMethod.GET)

    public String getAllAssurances(Model model,
                                   @RequestParam(name = "motCle", defaultValue = "") String mc,
                                   @RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(name = "size", defaultValue = "5") int size)


    {

        Page<Assurance> assurances = metier.pagesAssurance(page, size);
        int nbPages = assurances.getTotalPages();
        int [] pages = new int[nbPages];
        for (int i=0; i<nbPages; i++)
        {
            pages[i]=i;
        }
        model.addAttribute("pages", pages);
        model.addAttribute("pageCourante", page);
        model.addAttribute("assurances", assurances);
        model.addAttribute("motCle", mc);

        return "assurances";
    }

    //--------------------les assurances-----------------------------------------------
    @RequestMapping(value = "/lesassurances", method = RequestMethod.GET)

    public String lesassurances(Model model,
                                @RequestParam(name = "motCle", defaultValue = "") String mc,
                                @RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "size", defaultValue = "5") int size)


    {

        Page<Assurance> assurances = metier.pagesAssurance(page, size);
        int nbPages = assurances.getTotalPages();
        int [] pages = new int[nbPages];
        for (int i=0; i<nbPages; i++)
        {
            pages[i]=i;
        }
        model.addAttribute("pages", pages);
        model.addAttribute("pageCourante", page);
        model.addAttribute("assurances", assurances);
        model.addAttribute("motCle", mc);

        return "lesassurances";
    }






    //-------------------------------ajouter un assurance-------------------------------

    @RequestMapping(value = "/saveAssurance", method = RequestMethod.POST)
    public String saveAssurance(Assurance a)
    {

        metier.ajouterAssurance(a);

        return "redirect:/lesassurances";

    }

    //-----------------------------ajouter un assurance---------------------------
    @RequestMapping(value = "/addAssurance", method = RequestMethod.GET)

    public String addAssurance(Model model)

    {
        model.addAttribute("assurance", new Assurance());

        return "saveAssurance";

    }


    //--------------------gestion des traitements-----------------------------------

    @RequestMapping(value = "/addTraitement", method = RequestMethod.GET)

    public String addTraitement(Model model)

    {

        model.addAttribute("medecin", new Medecin());

        model.addAttribute("personne", new Personne());

        model.addAttribute("typesoins", new TypeSoins());

        return "addTraitement";

    }

    //-------------------------ajouter soins--------------------------------------------
    @RequestMapping(value = "/ajouterSoins", method = RequestMethod.GET)

    public String ajouterSoins(Model model)

    {

        model.addAttribute("medecin", new Medecin());

        model.addAttribute("beneficiare", new Beneficiaire());

        model.addAttribute("assure", new Assure());

        model.addAttribute("typesoins", new TypeSoins());

        model.addAttribute("assurance", new Assurance());

        return "Formulaire";

    }

    //-----------------------------add consultation---------------------------------------

    @RequestMapping(value = "/addConsultation", method = RequestMethod.GET)
    public String addConsulation(Model model)

    {

        model.addAttribute("medecin", new Medecin());

        model.addAttribute("beneficiare", new Beneficiaire());

        model.addAttribute("assure", new Assure());

        model.addAttribute("typesoins", new TypeSoins());

        model.addAttribute("assurance", new Assurance());

        model.addAttribute("conditionPC", new ConditionPC());

        model.addAttribute("accident", new Accident());



        return "testform";
    }


    //--------------------------add standart consultation-------------------------

    @RequestMapping(value = "/medecin" +
            "/fse/standard", method = RequestMethod.GET)
    public String addStandard(Model model, HttpServletRequest httpServletRequest)

    {

        String username = httpServletRequest.getRemoteUser();

        Medecin medecin = metier.getMedecinByUser(username);

        model.addAttribute("medecin", medecin);

        model.addAttribute("beneficiare", new Beneficiaire());

        model.addAttribute("assure", new Assure());

        model.addAttribute("typesoins", new TypeSoins());

        model.addAttribute("assurance", new Assurance());

        model.addAttribute("conditionPC", new ConditionPC());

        model.addAttribute("accident", new Accident());



        return "m_ficheStandard";
    }





    //-------------------enregistrer traitement old version----------------------------------------------------

    @RequestMapping(value = "/saveTraitement", method = RequestMethod.POST)
    public String saveTraitement(Medecin m, Personne p, TypeSoins typeSoins)

    {

        Medecin mm = metier.getMedcin(m.getIdMedcin());

        Personne pp = metier.getPersonne(p.getIdPersonne());

        TypeSoins tt = metier.getTypeSoins(typeSoins.getId());

        metier.ajouterTraitement(mm, pp, tt);

        return "redirect:/traitements";
    }

    //-----------------------enregistrer soins new version o cas ou les down good oouffe----------------------------------------------------

    @RequestMapping(value = "/saveSoins", method = RequestMethod.POST)

    public String saveSoins(Medecin m, Beneficiaire b, Assure a, TypeSoins typeSoins, Assurance assurance)
    {



        Medecin mm = metier.getMedcin(m.getIdMedcin());

        a.setAssurance(metier.getAssurance(assurance.getNomAssurance()));

        //TypeSoins tt = metier.getTypeSoins(typeSoins.getId());



        metier.ajouterFeuilleSoins(mm, b, a, typeSoins);



        return "redirect:/feuillesoins";
    }


    //-------------save formulaire  important enrigistre une consultation --------------------------------------------------------
    @RequestMapping(value = "/saveForm", method = RequestMethod.POST)

    public String saveForm(Medecin m, Beneficiaire b, Assure a, TypeSoins typeSoins, Assurance assurance, ConditionPC conditionPC, Accident accident,HttpServletRequest httpServletRequest)
    {



        System.out.println("---------------------------");
        System.out.println(accident.getTemoins());
        System.out.println("-------------------------------");

        System.out.println(m.getIdMedcin());

        String username = httpServletRequest.getRemoteUser();

        Medecin mm = metier.getMedecinByUser(username);

        // Medecin mm = metier.getMedcin(m.getIdMedcin());

        a.setAssurance(metier.getAssurance(assurance.getNomAssurance()));

        //TypeSoins tt = metier.getTypeSoins(typeSoins.getId());



        //metier.ajouterFeuilleSoins(mm, b, a, typeSoins);


        //  metier.saveForm(mm, b, a, typeSoins, conditionPC, accident);

        metier.saveForm(mm, b, a, typeSoins, accident, conditionPC);


        //return "redirect:/lestraitements";

        return "redirect:/lesfactures";
    }




    //---------------------------tous les traitements-------------------------------------

    @RequestMapping(value = "/traitements",method = RequestMethod.GET)

    public String getAllTraitements(Model model, @RequestParam(name = "motCle", defaultValue = "") String mc,
                                    @RequestParam(name = "page", defaultValue = "0") int page,
                                    @RequestParam(name = "size", defaultValue = "5") int size
    )
    {
        Page<Traitement> traitements = metier.pagesTraitement(page, size);
        int nbPages = traitements.getTotalPages();
        int [] pages = new int[nbPages];
        for (int i=0; i<nbPages; i++)
        {
            pages[i]=i;
        }
        model.addAttribute("pages", pages);
        model.addAttribute("pageCourante", page);
        model.addAttribute("traitements", traitements);
        model.addAttribute("motCle", mc);
        return "traitements";
    }

    //---------------------------tous les assurances------------------------------------------





    //-----------------tous les feuilles soins------------------------------------------------

    @RequestMapping(value = "/feuillesoins",method = RequestMethod.GET)

    public String getAllsoins(Model model, @RequestParam(name = "motCle", defaultValue = "") String mc,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "size", defaultValue = "5") int size
    )
    {
        Page<Traitement> traitements = metier.pagesTraitement(page, size);
        int nbPages = traitements.getTotalPages();
        int [] pages = new int[nbPages];
        for (int i=0; i<nbPages; i++)
        {
            pages[i]=i;
        }
        model.addAttribute("pages", pages);
        model.addAttribute("pageCourante", page);
        model.addAttribute("traitements", traitements);
        model.addAttribute("motCle", mc);
        return "feuillesoins";
    }

    //-----------------------------les traitements-------------------------------------------

    @RequestMapping(value = "/lestraitements",method = RequestMethod.GET)

    public String lestraitements(Model model, @RequestParam(name = "motCle", defaultValue = "") String mc,
                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "size", defaultValue = "2") int size
    )
    {
        Page<Traitement> traitements = metier.pagesTraitement(page, size);
        int nbPages = traitements.getTotalPages();
        int [] pages = new int[nbPages];
        for (int i=0; i<nbPages; i++)
        {
            pages[i]=i;
        }
        model.addAttribute("pages", pages);
        model.addAttribute("pageCourante", page);
        model.addAttribute("traitements", traitements);
        model.addAttribute("motCle", mc);
        return "lestraitements";
    }




    //----------------------------service de la facturation-----------------------------------

    @RequestMapping(value = "/factures", method = RequestMethod.GET)

    public String getAllFactures(Model model,
                                 @RequestParam(name = "motCle", defaultValue = "") String mc,
                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "size", defaultValue = "5") int size

    )

    {

        //Page<Traitement> traitements = metier.pagesTraitement(page, size);

        Page<Facture> factures = metier.pagesFacture(page, size);


        int nbPages = factures.getTotalPages();

        int [] pages = new int[nbPages];

        for (int i=0; i<nbPages; i++)
        {
            pages[i]=i;
        }

        model.addAttribute("pages", pages);

        model.addAttribute("pageCourante", page);

        model.addAttribute("factures", factures);


        model.addAttribute("motCle", mc);



        return "factures";
    }

    //--------------------------tous les factures----------------------------------------

    @RequestMapping(value = "/lesfactures", method = RequestMethod.GET)

    public String lesfactures(Model model,
                              @RequestParam(name = "motCle", defaultValue = "") String mc,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "size", defaultValue = "10") int size)

    {

        //Page<Traitement> traitements = metier.pagesTraitement(page, size);

        Page<Facture> factures = metier.pagesFacture(page, size);


        int nbPages = factures.getTotalPages();

        int [] pages = new int[nbPages];

        for (int i=0; i<nbPages; i++)
        {
            pages[i]=i;
        }

        model.addAttribute("pages", pages);

        model.addAttribute("pageCourante", page);

        model.addAttribute("factures", factures);


        model.addAttribute("motCle", mc);



        return "lesfactures";
    }


    //---------------------les factures par etat en attente pour un medecin particulier------------------------------------------

    @RequestMapping(value = "/medecin/fse/enattente", method = RequestMethod.GET)

    public String facturesByEtat(Model model,
                                 @RequestParam(name = "motCle", defaultValue = "") String mc,
                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "size", defaultValue = "10") int size, HttpServletRequest httpServletRequest
    )

    {

        //---------------------new code-------------------------------------------

        String username = httpServletRequest.getRemoteUser();

        //----------------puis je recupére le medecin--------------------------------

        Medecin medecin = metier.getMedecinByUser(username);

        //----------------Puis récupérer le nombre total de facture --------------

        int nombreFacture=metier.totalFacture(medecin,"En Cours");
        int nombrePage;
        //----------------Nombre de Pages
        if (nombreFacture % size == 0)
        {
            nombrePage = nombreFacture / size;
            System.out.println("Nombre de Page: "+nombrePage);
        }
        else
        {
            nombrePage = (nombreFacture / size)+1;
            System.out.println("Nombre de Page: "+nombrePage);
        }

        int pages [] = new int[nombrePage];
        for(int j =0; j<nombrePage;j++)
        {
            pages[j]=j;
        }
        //--------------the next method is better-----------------------------------

        Page<Facture> factures = metier.facturesByMedecin(medecin, page, size, "En Cours");



        model.addAttribute("nombrePage", nombrePage);

        model.addAttribute("pages",pages);

        model.addAttribute("page", page);

        model.addAttribute("factures", factures);

        model.addAttribute("size",size);

        model.addAttribute("motCle", mc);



        return "m_facturesEnAttente";
    }

    @RequestMapping(value = "/medecin/fse/recycler", method = RequestMethod.GET)

    public String recycler(Model model,
                                 @RequestParam(name = "motCle", defaultValue = "") String mc,
                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "size", defaultValue = "10") int size, HttpServletRequest httpServletRequest
    )

    {

        //---------------------new code-------------------------------------------

        String username = httpServletRequest.getRemoteUser();

        //----------------puis je recupére le medecin--------------------------------

        Medecin medecin = metier.getMedecinByUser(username);

        //----------------Puis récupérer le nombre total de facture --------------

        int nombreFacture=metier.totalFacture(medecin,"Rejet");
        int nombrePage;
        //----------------Nombre de Pages
        if (nombreFacture % size == 0)
        {
            nombrePage = nombreFacture / size;
            System.out.println("Nombre de Page: "+nombrePage);
        }
        else
        {
            nombrePage = (nombreFacture / size)+1;
            System.out.println("Nombre de Page: "+nombrePage);
        }

        int pages [] = new int[nombrePage];
        for(int j =0; j<nombrePage;j++)
        {
            pages[j]=j;
        }
        //--------------the next method is better-----------------------------------

        Page<Facture> factures = metier.facturesByMedecin(medecin, page, size, "rejet");



        model.addAttribute("nombrePage", nombrePage);

        model.addAttribute("pages",pages);

        model.addAttribute("page", page);

        model.addAttribute("factures", factures);

        model.addAttribute("size",size);

        model.addAttribute("motCle", mc);



        return "m_facturesRecycler";
    }

    @RequestMapping(value = "/medecin/fse/historique", method = RequestMethod.GET)

    public String allFacture(Model model,
                                 @RequestParam(name = "motCle", defaultValue = "") String mc,
                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "size", defaultValue = "10") int size, HttpServletRequest httpServletRequest
    )

    {

        //---------------------new code-------------------------------------------

        String username = httpServletRequest.getRemoteUser();

        //----------------puis je recupére le medecin--------------------------------

        Medecin medecin = metier.getMedecinByUser(username);

        //----------------Puis récupérer le nombre total de facture --------------

        int nombreFacture=metier.totalHistorique(medecin);
        int nombrePage;
        //----------------Nombre de Pages
        if (nombreFacture % size == 0)
        {
            nombrePage = nombreFacture / size;
            System.out.println("Nombre de Page: "+nombrePage);
        }
        else
        {
            nombrePage = (nombreFacture / size)+1;
            System.out.println("Nombre de Page: "+nombrePage);
        }

        int pages [] = new int[nombrePage];
        for(int j =0; j<nombrePage;j++)
        {
            pages[j]=j;
        }
        //--------------the next method is better-----------------------------------

        Page<Facture> factures = metier.historiqueByMedecin(medecin, page, size);



        model.addAttribute("nombrePage", nombrePage);

        model.addAttribute("pages",pages);

        model.addAttribute("page", page);

        model.addAttribute("factures", factures);

        model.addAttribute("size",size);

        model.addAttribute("motCle", mc);



        return "m_facturesHistorique";
    }


    //-----------------------les factures valier-------------------------------------

    @RequestMapping(value = "/facturesValider", method = RequestMethod.GET)

    public String facturesValider(Model model,
                                  @RequestParam(name = "motCle", defaultValue = "") String mc,
                                  @RequestParam(name = "page", defaultValue = "0") int page,
                                  @RequestParam(name = "size", defaultValue = "5") int size)

    {

        //Page<Traitement> traitements = metier.pagesTraitement(page, size);

        //Page<Facture> factures = metier.pagesFacture(page, size);

        Page<Facture> factures = metier.facturesByEtat("Valider", page, size);


        int nbPages = factures.getTotalPages();

        int [] pages = new int[nbPages];

        for (int i=0; i<nbPages; i++)
        {
            pages[i]=i;
        }

        model.addAttribute("pages", pages);

        model.addAttribute("pageCourante", page);

        model.addAttribute("factures", factures);


        model.addAttribute("motCle", mc);



        return "facturesValider";
    }

    //----------------------les factures rejeter-------------------------------------------

    @RequestMapping(value = "/facturesRejetes", method = RequestMethod.GET)

    public String facturesRejetes(Model model,
                                  @RequestParam(name = "motCle", defaultValue = "") String mc,
                                  @RequestParam(name = "page", defaultValue = "0") int page,
                                  @RequestParam(name = "size", defaultValue = "5") int size)

    {

        //Page<Traitemen
        //
        // t> traitements = metier.pagesTraitement(page, size);

        //Page<Facture> factures = metier.pagesFacture(page, size);

        Page<Facture> factures = metier.facturesByEtat("Rejeter", page, size);


        int nbPages = factures.getTotalPages();

        int [] pages = new int[nbPages];

        for (int i=0; i<nbPages; i++)
        {
            pages[i]=i;
        }

        model.addAttribute("pages", pages);

        model.addAttribute("pageCourante", page);

        model.addAttribute("factures", factures);


        model.addAttribute("motCle", mc);





        return "facturesRejetes";
    }






//-----------------------------creer facture----------------------------------------------

    @RequestMapping(value = "/creer", method = RequestMethod.GET)

    public String creerFacture(@RequestParam(name = "id") Long id)

    {

        System.out.println("------------------------------");

        System.out.println(id);

        System.out.println("--------------------------------");

        Traitement traitement = metier.getTraitement(id);

        metier.ajouterFacture(traitement);

        return "redirect:/factures";
    }

    //------------------------valider facture-----------------------------------




    //----------------factures Par Medecin----------------------------------------

    @RequestMapping(value = "/facturesParMedecin", method = RequestMethod.GET)
    public String factures(Model model, @RequestParam(name = "id") Long id, @RequestParam(name = "motCle", defaultValue = "") String mc,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "10") int size, HttpServletRequest httpServletRequest)
    {

        //------------on recupere l'assurance dans le parametre----------------

        String username = httpServletRequest.getRemoteUser();

        //------------on recupere l'assurance---------------------

        Assurance assurance = metier.giveAssuranceByUser(username);


        //-------------Assurance b = metier.getAssurance("AXA ASSURANCE");


        System.out.println("----------------------");

        System.out.println(assurance.getEmail());

        System.out.println("--------------------");

        System.out.println(username);

        //-------permet d'afficher les factures concernant un medecin--------------

        Medecin medecin = metier.getMedcin(id);



        //------------old version------------------------
        //Page<Facture> factures = metier.facturesParMedecin(medecin, page, size);

        //------------new version--------------------------------

        Page<Facture> factures = metier.facturesParMedecinAssurance(medecin, assurance, page, size);


        int nbPages = factures.getTotalPages();

        int [] pages = new int[nbPages];

        for (int i=0; i<nbPages; i++)
        {
            pages[i]=i;
        }

        model.addAttribute("pages", pages);

        model.addAttribute("pageCourante", page);

        model.addAttribute("factures", factures);


        model.addAttribute("motCle", mc);



        return "facturesParMedecin";




    }

    //---------------------------------------------------

    @RequestMapping(value = "/pdf", method = RequestMethod.GET)
    public  void pdf(HttpServletResponse response) {
        // ... PDF generation like in FlyingSaucerTest.java...
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ITextRenderer renderer = null;
        try {
            renderer.createPDF(outputStream);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment;filename=my-test-pdf.pdf");
        try {
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //-----------------------vcreer facture new version---------------------------------

    @RequestMapping(value = "/addFacture", method = RequestMethod.GET)

    public String addFacture(@RequestParam(name = "id") Long id)

    {

        System.out.println("------------------------------");

        System.out.println(id);

        System.out.println("--------------------------------");

        Traitement traitement = metier.getTraitement(id);

        metier.ajouterFacture(traitement);

        return "redirect:/lesfactures";
    }

    //-------------------------valider facture-------------------------------
    @RequestMapping(value = "/validerFacture", method = RequestMethod.GET)

    public String validerFacture(@RequestParam(name = "id") Long id)

    {

        System.out.println("------------------------------");

        System.out.println(id);

        System.out.println("--------------------------------");

        //Traitement traitement = metier.getTraitement(id);



//        Facture facture = metier.getFacture(id);
////
////        System.out.println("-------------------");
////
////        System.out.println(facture.getEtat());
////
////        System.out.println(facture.getDate());


        metier.validerFacture(id);

        //metier.ajouterFacture(traitement);

        return "redirect:/dossiermedecins";
    }




    //----------------------------------------------------------------------------------



    //-------------------------page accueil assurance-----------------------------------

    @GetMapping("/assurance")

    public String assurance()
    {
        return "a_accueil";
    }


    @GetMapping("/assurance/dossier/pharmacie")
    public String pharmacie()
    {
        return "a_dossierPharmacie";
    }

}
