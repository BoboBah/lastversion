package sn.alien.sseapp.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sn.alien.sseapp.classses.Medecin;
import sn.alien.sseapp.classses.User;

@org.springframework.stereotype.Controller
public class Controller {



    //-----------controlleur index----------------------------

    @RequestMapping(value = "/index", method =  RequestMethod.GET)
    public String index()
    {

        return "index";
    }

    //-----------------------controller medecin------------------

    @RequestMapping("medecin")
    public String accueilMedecin(){
        return "m_accueil";
    }

    @RequestMapping("medecin/fse/standard")
    public String ficheStandard(){
        return "m_ficheStandard";
    }


    @RequestMapping("medecin/fse/recycler")
    public String listeRecycler(Model model){
        String titre="";
        model.addAttribute("SSE-Médecin Recycler",titre);
        return "m_liste";
    }



    @RequestMapping(value = "medecin/parametre/profil", method = RequestMethod.GET)

    public String profil()
    {

        return "m_profil";
    }

    //-----------------------------------------------------------------

    @RequestMapping(value = "facturation/facture", method = RequestMethod.GET)

    public String facturation()
    {

        return "facture";
    }



    //--------------------controlleur login--------------------------

    @RequestMapping(value = "/authentification/assurance", method= RequestMethod.GET)
    public String loginAssurance()
    {
        return "login-assurance";
    }

    @RequestMapping(value = "/authentification/medecin", method= RequestMethod.GET)
    public String loginMedecin()
    {
        return "login-medecin";
    }

    @RequestMapping(value = "/authentification/patient", method= RequestMethod.GET)
    public String loginPatient()
    {
        return "login-patient";
    }

   /* @RequestMapping(value = "/inscription/medecin", method= RequestMethod.GET)
    public String inscriptionMedecin(Model model)


    {
         model.addAttribute("medecin", new Medecin());

         model.addAttribute("user", new User());

        return "register-medecin";
    }*/

    @RequestMapping(value = "/inscription/patient", method= RequestMethod.GET)
    public String inscriptionPatient()
    {
        return "register-patient";
    }

    @RequestMapping(value = "/recover/assurance", method= RequestMethod.GET)
    public String recoverAssurance() { return "recover-assurance"; }

    @RequestMapping(value = "/recover/medecin", method= RequestMethod.GET)
    public String recoverMedecin() { return "recover-medecin"; }

    @RequestMapping(value = "/recover/patient", method= RequestMethod.GET)
    public String recoverPatient() { return "recover-patient"; }







}
