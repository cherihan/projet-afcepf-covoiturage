package fr.afcepf.atod21.coVoiturage.servicesImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.atod21.coVoiturage.business.dto.TrajetDto;
import fr.afcepf.atod21.coVoiturage.dao.IDaoUtilisateur;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;
import fr.afcepf.atod21.coVoiturage.ria.IInscriptionTrajetServiceSoap;
import fr.afcepf.atod21.coVoiturage.ria.InscriptionTrajetServiceSoapService;
import fr.afcepf.atod21.coVoiturage.services.IOrchestrateurSoap;

@WebService(endpointInterface = "fr.afcepf.atod21.coVoiturage.services.IOrchestrateurSoap")
public class OrchestrateurSoap implements IOrchestrateurSoap {

    @Autowired
    private IDaoUtilisateur daoUtilisateur;
    
    @Override
    @WebMethod
    public List<TrajetDto> rechercherTrajetSOAP(Date paramDateDepart,
            String paramVilleDepart, String paramVilleArrivee) {
        RechercheTrajetServiceSoap rechercheTrajetWS = new RechercheTrajetServiceSoap();
        return rechercheTrajetWS.rechercherTrajetSOAP(paramDateDepart,
                paramVilleDepart, paramVilleArrivee);
    }

    @Override
    @WebMethod
    public List<TrajetDto> rechercherTrajetParVilleDepartSOAP(
            Date paramDateDepart, String paramVilleDepart) {
        RechercheTrajetServiceSoap rechercheTrajetWS = new RechercheTrajetServiceSoap();
        return rechercheTrajetWS.rechercherTrajetParVilleDepartSOAP(
                paramDateDepart, paramVilleDepart);
    }

    @SuppressWarnings("finally")
    @Override
    @WebMethod
    public int authentifierClient(int applicationId) throws FileNotFoundException, Exception, IOException, Throwable {
        
        int applicationNumberOfUsers=0;
        Properties clientsProperties = new Properties();
        Properties connectedUsersProperties = new Properties();
        System.out.println("============================================Avant clientInput");
        
        FileInputStream clientInput = new FileInputStream("C:/Users/Stagiaire/workspace/CoVoiturage_Application/CoVoiturage_web/src/main/resources/clientsApplication.properties");
        
        System.out.println("===================================================avant connected");
        
        FileInputStream connectedUsersInput = new FileInputStream("C:/Users/Stagiaire/workspace/CoVoiturage_Application/CoVoiturage_web/src/main/resources/connectedClients.properties");
        System.out.println("==============================================================================================Avant le try");
        try {
            clientsProperties.load(clientInput);
            if (clientsProperties.getProperty(Integer.toString(applicationId)) != null) {
                applicationNumberOfUsers = Integer.parseInt(clientsProperties.getProperty(Integer.toString(applicationId)));
                connectedUsersProperties.load(connectedUsersInput);
                if (connectedUsersProperties.get(Integer.toString(applicationId)) != connectedUsersProperties.getProperty(Integer.toString(applicationId))){
                    connectedUsersProperties.setProperty(Integer.toString(applicationId), Integer.toString(applicationNumberOfUsers + 1));
                }
                System.out.println("apres le try"+applicationNumberOfUsers);
                return (applicationNumberOfUsers + 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            clientInput.close();
            return (applicationNumberOfUsers + 1); 
        }
    }
    
    @SuppressWarnings("finally")
    @WebMethod
    public boolean entryMethod(int idApplication, int IdUser, int IdTrajet) throws FileNotFoundException, Exception, IOException, Throwable {
        int numberOfUser;
        Properties properties = new Properties();
        Utilisateur user = daoUtilisateur.getUserById(IdUser);
        boolean resultat = false;
        
        FileInputStream input = new FileInputStream("C:/Users/Stagiaire/workspace/CoVoiturage_Application/CoVoiturage_web/src/main/resources/connectedClients.properties");

        InscriptionTrajetServiceSoapService service=new InscriptionTrajetServiceSoapService();
        IInscriptionTrajetServiceSoap inscriptionWS=service.getInscriptionTrajetServiceSoapPort();
        
        try {
            System.out.println("================================================== dans try");
            properties.load(input);
            if (properties.getProperty(Integer.toString(idApplication)).equals(Integer.toString(IdUser))) {
                System.out.println("================================================== dans if");
                
      
             
                System.out.println("idTrajet : " + IdTrajet + "idUser : " + IdUser);
                
                
                resultat = inscriptionWS.sInscrireTrajetDto(IdTrajet, IdUser);
                return resultat;
            }
            else {
                System.out.println("================================================== dans else");
                ConnexionServiceSoap connexionWS = new ConnexionServiceSoap();
                if (connexionWS.seConnecterSOAP(user.getEmail(), user.getPassword()) != null){
                    resultat = inscriptionWS.sInscrireTrajetDto(IdTrajet, IdUser);
                    return resultat;
                }
                else{
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            input.close();
            return resultat;

        }
    }
    }