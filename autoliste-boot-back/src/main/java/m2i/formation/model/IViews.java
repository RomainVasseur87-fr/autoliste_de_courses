package m2i.formation.model;

public interface IViews {
	public static interface IViewBasic {}
	
	public static interface IViewDetail {}
		
	public static interface IViewUtilisateur extends IViewBasic {}
	
	public static interface IViewUtilisateurDetail extends IViewUtilisateur {}
	
}
