package m2i.formation.model;

public interface IViews {
	public static interface IViewBasic {}
	
	public static interface IViewDetail {}
		
	public static interface IViewUtilisateur extends IViewBasic {}
	
	public static interface IViewRole extends IViewBasic {}
	
	public static interface IViewAdresse extends IViewBasic {}
	
	public static interface IViewRoleDetail extends IViewRole, IViewDetail {}
	
	public static interface IViewAdresseDetail extends IViewAdresse, IViewDetail {}
	
	public static interface IViewUtilisateurDetail extends IViewUtilisateur, IViewDetail, IViewRoleDetail, IViewAdresseDetail {}
	
}
