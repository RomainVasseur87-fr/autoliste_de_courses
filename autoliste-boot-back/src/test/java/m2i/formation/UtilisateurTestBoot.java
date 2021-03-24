package m2i.formation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import m2i.formation.dao.IUtilisateurDao;
import m2i.formation.dao.IUtilisateurRoleDao;
import m2i.formation.model.Role;
import m2i.formation.model.Utilisateur;
import m2i.formation.model.UtilisateurRole;

@SpringBootTest
public class UtilisateurTestBoot {
	
	@Autowired
	private IUtilisateurDao utilisateurDao;
	
	@Autowired
	private IUtilisateurRoleDao utilisateurRoleDao;

	
	@Test
	public void utilisateurDaoFindByUsername() {
		int sizeStart = utilisateurDao.findByUsername("user91").size();
		System.out.println("sizeStart Username " + sizeStart);
		Utilisateur utilisateur1 = new Utilisateur("user91", "user91", true);
		utilisateur1 = utilisateurDao.save(utilisateur1);
		UtilisateurRole utilisateur1Role = new UtilisateurRole(utilisateur1, Role.ADMIN);
		utilisateur1Role = utilisateurRoleDao.save(utilisateur1Role);
		Utilisateur utilisateur2 = new Utilisateur("user92", "user92", false);
		utilisateur2 = utilisateurDao.save(utilisateur2);
		UtilisateurRole utilisateur2Role = new UtilisateurRole(utilisateur2, Role.USER);
		utilisateur2Role = utilisateurRoleDao.save(utilisateur2Role);
		Utilisateur utilisateur3 = new Utilisateur("user93", "user93", false);
		utilisateur3 = utilisateurDao.save(utilisateur3);
		UtilisateurRole utilisateur3Role = new UtilisateurRole(utilisateur3, Role.GUEST);
		utilisateur3Role = utilisateurRoleDao.save(utilisateur3Role);
		int sizeEnd = utilisateurDao.findByUsername("user91").size();
		System.out.println("sizeEnd Username " + sizeEnd);
		Assertions.assertEquals(1, sizeEnd - sizeStart);
	}
	
	@Test
	public void utilisateurDaoFindByEnable() {
		int sizeStart = utilisateurDao.findByEnable(true).size();
		System.out.println("sizeStart " + sizeStart);
		Utilisateur utilisateur3 = new Utilisateur("user94", "user94", true);
		utilisateur3 = utilisateurDao.save(utilisateur3);
		int sizeEnd = utilisateurDao.findByEnable(true).size();
		System.out.println("sizeEnd " + sizeEnd);
		Assertions.assertEquals(1, sizeEnd - sizeStart);
	}
}
