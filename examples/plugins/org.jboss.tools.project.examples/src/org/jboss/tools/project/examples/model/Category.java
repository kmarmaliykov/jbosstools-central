/*************************************************************************************
 * Copyright (c) 2008-2011 Red Hat, Inc. and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     JBoss by Red Hat - Initial implementation.
 ************************************************************************************/
package org.jboss.tools.project.examples.model;

import java.util.ArrayList;
import java.util.List;

import org.jboss.tools.project.examples.Messages;

/**
 * @author snjeza
 * 
 */
public class Category implements ProjectModelElement, Comparable<Category> {

	private String name;
	private List<Project> projects = new ArrayList<Project>();
	private IProjectExampleSite site;
	public static Category OTHER = new Category(Messages.Category_Other);

	public Category(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public String getDescription() {
		return getName();
	}

	public String getShortDescription() {
		return getName();
	}

	public IProjectExampleSite getSite() {
		return site;
	}

	@Override
	public void setSite(IProjectExampleSite site) {
		this.site = site;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((site == null) ? 0 : site.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (site == null) {
			if (other.site != null)
				return false;
		} else if (!site.equals(other.site))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getName();
	}

  @Override
  public int compareTo(Category o) {
    if (o == null) {
      return 1;
    }
    //TODO use priorities
    String otherName = o.getName();
    if (name == otherName) {
      return 0;
    }
    if (name == null) {
      return -1;
    }
    if (otherName == null) {
      return 1;
    }
    return name.compareTo(otherName);
  }
}
