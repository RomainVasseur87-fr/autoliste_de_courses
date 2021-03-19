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
public class UtilisateurRoleTestBoot {

	@Autowired
	private IUtilisateurDao utilisateurDao;
	
	@Autowired
	private IUtilisateurRoleDao utilisateurRoleDao;
	
	@Test
	public void utilisateurRoleDaoFindByRole() {
		int sizeStart = utilisateurRoleDao.findByRole(Role.ADMIN).size();
		System.out.println("sizeStart " + sizeStart);
		Utilisateur utilisateur1 = new Utilisateur("user201", "user201", true);
		utilisateur1 = utilisateurDao.save(utilisateur1);
		UtilisateurRole utilisateur1Role = new UtilisateurRole(utilisateur1, Role.ADMIN);
		utilisateur1Role = utilisateurRoleDao.save(utilisateur1Role);
		int sizeEnd = utilisateurRoleDao.findByRole(Role.ADMIN).size();
		System.out.println("sizeEnd " + sizeEnd);
		Assertions.assertEquals(1, sizeEnd - sizeStart);
	}
	
}
