package m2i.formation.test;

import java.text.SimpleDateFormat;

import org.springframework.context.support.ClassPathXmlApplicationContext;
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

public class AutoListeMain {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		IAdresseDao adresseDao = context.getBean(IAdresseDao.class);
		IArticleDao articleDao = context.getBean(IArticleDao.class);
		ICategorieDao categorieDao = context.getBean(ICategorieDao.class);
		ICommandeDao commandeDao = context.getBean(ICommandeDao.class);
		IDroitDao droitDao = context.getBean(IDroitDao.class);
		IMagasinDao magasinDao = context.getBean(IMagasinDao.class);
		IPanierDao panierDao = context.getBean(IPanierDao.class);
		IProcessDao processDao = context.getBean(IProcessDao.class);
		IProduitDao produitDao = context.getBean(IProduitDao.class);
		IRecetteDao recetteDao = context.getBean(IRecetteDao.class);
		IThemeDao themeDao = context.getBean(IThemeDao.class);
		ITypeDao typeDao = context.getBean(ITypeDao.class);
		IUtilisateurDao utilisateurDao = context.getBean(IUtilisateurDao.class);

		Utilisateur christopheUtilisateur = new Utilisateur("Varlet", "Christophe", "cva@gmail.com");
		Utilisateur romainUtilisateur = new Utilisateur("Vasseur", "Romain", "rva@gmail.com");
		Utilisateur mohamedUtilisateur = new Utilisateur("Djadane", "Mohamed", "mdj@gmail.com");

		utilisateurDao.save(christopheUtilisateur);
		utilisateurDao.save(romainUtilisateur);
		utilisateurDao.save(mohamedUtilisateur);
		
		context.close();
	}
	
}