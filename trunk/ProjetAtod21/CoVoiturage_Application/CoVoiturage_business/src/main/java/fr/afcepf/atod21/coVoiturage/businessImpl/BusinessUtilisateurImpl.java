package fr.afcepf.atod21.coVoiturage.businessImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod21.coVoiturage.business.IBusinessUtilisateur;
import fr.afcepf.atod21.coVoiturage.dao.IDaoUtilisateur;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

@Service
@Transactional
public class BusinessUtilisateurImpl implements IBusinessUtilisateur {

	@Autowired
	private IDaoUtilisateur daoUtilisateur;

	@Override
	public void afficher() {
		daoUtilisateur.afficher();
	}

	@Override
	public void sInscrireTrajet(Trajet trajet, Utilisateur user) {

		daoUtilisateur.sInscrireTrajet(trajet, user);

	}

	@Override
	public void seDesinscrireTrajet(Integer idTrajet, Integer idUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public void annulerInscriptionTrajet(Integer idTrajet, Integer idUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public Utilisateur seConnecter(String email, String password) {
		return daoUtilisateur.seConnecter(email, password);
	}

	@Override
	public void seDeconnecter(Utilisateur utilisateur) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changerPassword(Utilisateur utilisateur) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Trajet> rechercherTrajet(Date dateDepart, String villeDepart, String villeArrivee) {

		return daoUtilisateur.rechercherTrajet(dateDepart, villeDepart, villeArrivee);
	}

	@Override
	public List<Trajet> rechercherTrajetParVilleDepart(Date dateDepart, String villeDepart) {

		return daoUtilisateur.rechercherTrajetParVilleDepart(dateDepart, villeDepart);
	}

	@Override
	public Integer creerCompte(Utilisateur user) {
		return daoUtilisateur.creerCompte(user);
	}

	@Override
	public Utilisateur getUserById(Integer idUser) {

		return daoUtilisateur.getUserById(idUser);
	}

}
