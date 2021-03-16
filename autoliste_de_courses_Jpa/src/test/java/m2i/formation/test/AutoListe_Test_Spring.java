package m2i.formation.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import m2i.formation.dao.IAdresseDao;
import m2i.formation.dao.IArticleDao;
import m2i.formation.dao.ICategorieDao;
import m2i.formation.dao.ICommandeDao;
import m2i.formation.dao.IDroitDao;
import m2i.formation.dao.IMagasinDao;
import m2i.formation.dao.IPanierDao;
import m2i.formation.dao.IProcessDao;
import m2i.formation.dao.IProduitDao;
import m2i.formation.dao.IRecetteDao;
import m2i.formation.dao.IThemeDao;
import m2i.formation.dao.ITypeDao;
import m2i.formation.dao.IUtilisateurDao;
import m2i.formation.model.Utilisateur;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/application-context.xml")
public class AutoListe_Test_Spring {

	@Autowired
	IAdresseDao adresseDao;
	@Autowired
	IArticleDao articleDao;
	@Autowired
	ICategorieDao categorieDao;
	@Autowired
	ICommandeDao commandeDao;
	@Autowired
	IDroitDao droitDao;
	@Autowired
	IMagasinDao magasinDao;
	@Autowired
	IPanierDao panierDao;
	@Autowired
	IProcessDao processDao;
	@Autowired
	IProduitDao produitDao;
	@Autowired
	IRecetteDao recetteDao;
	@Autowired
	IThemeDao themeDao;
	@Autowired
	ITypeDao typeDao;
	@Autowired
	IUtilisateurDao utilisateurDao;
	
	@Test
	public void utilisateurDaoCreate() {
		Utilisateur christopheUtilisateur = new Utilisateur("Varlet", "Christophe", "cva@gmail.com");
		Utilisateur romainUtilisateur = new Utilisateur("Vasseur", "Romain", "rva@gmail.com");
		Utilisateur mohamedUtilisateur = new Utilisateur("Djadane", "Mohamed", "mdj@gmail.com");
		utilisateurDao.save(christopheUtilisateur);
		utilisateurDao.save(romainUtilisateur);
		utilisateurDao.save(mohamedUtilisateur);
	}
}