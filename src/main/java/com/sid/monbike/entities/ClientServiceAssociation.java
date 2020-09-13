package com.sid.monbike.entities;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity(name = ClientServiceAssociation.TABLE_NAME)
public class ClientServiceAssociation implements Serializable {

	private static final long serialVersionUID = 1905822041950851207L;

	public static final String TABLE_NAME = "CLIENT_SERVICE_ASSOCIATION";

	@EmbeddedId
	private ClientServiceAssocPK id;

	public ClientServiceAssocPK getId() {
		return id;
	}

	public void setId(ClientServiceAssocPK id) {
		this.id = id;
	}


}
