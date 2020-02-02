package com.demo.prime.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.demo.prime.domain.Rss;

@Named
@ViewScoped
public class RssBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Rss> rssList = new ArrayList<>();

	private Rss entity;
	private Rss entityEdit;
	
	@PostConstruct
	public void init() {
		entity = new Rss();
		entityEdit = new Rss();
	}
	
	public RssBean() {
			rssList.addAll(Arrays.asList(
					new Rss(1L, "UOL", "Geral", true),
					new Rss(1L, "UOL", "Games", true),
					new Rss(1L, "G1", "Geral", true),
					new Rss(1L, "G1", "Entretenimento", true),
					new Rss(1L, "G1", "Esporte", true)));
	}
	
	public void save() {
		System.out.println("Save : " + entityEdit.getName());
		
		if (!rssList.contains(entityEdit)) {
			rssList.add(entityEdit);
		}
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Rss salvo com sucesso!"));
		
		newEntity();
	}
	
	public void clear() {
		newEntity();
		System.out.println("clear()");
	}
	
	public List<Rss> getRssList() {
		return rssList;
	}
	
	public void newEntity() {
		entityEdit = new Rss();
		entity = new Rss();
	}

	public Rss getEntityEdit() {
		return entityEdit;
	}

	public void setEntityEdit(Rss entityEdit) {
		this.entityEdit = entityEdit;
	}

	public Rss getEntity() {
		return entity;
	}

	public void setEntity(Rss entity) {
		this.entity = entity;
	}
	
}
