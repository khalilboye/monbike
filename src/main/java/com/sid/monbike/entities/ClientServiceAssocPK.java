package com.sid.monbike.entities;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ClientServiceAssocPK implements Serializable {

	private static final long serialVersionUID = 1945822041950251207L;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_CLIENT")
	private Client client;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_SERVICE")
	private Service service;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}






}
