package m2i.formation.model;

import com.fasterxml.jackson.annotation.JsonView;


public enum Role {
	@JsonView(IViews.IViewRoleDetail.class)
	ADMIN,USER,GUEST
}
