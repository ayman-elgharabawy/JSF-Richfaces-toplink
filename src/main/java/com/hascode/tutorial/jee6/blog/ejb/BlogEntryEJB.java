package com.hascode.tutorial.jee6.blog.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hascode.tutorial.jee6.blog.entity.BlogEntry;

@Stateless
public class BlogEntryEJB {
	@PersistenceContext(unitName = "defaultPersistenceUnit")
	private EntityManager	em;

	public BlogEntry saveBlogEntry(BlogEntry blogEntry) {
		em.persist(blogEntry);
		return blogEntry;
	}

	public List<BlogEntry> findBlogEntries() {
		final Query query = em.createQuery("SELECT b FROM BlogEntry b ORDER BY b.created DESC");
		List<BlogEntry> entries = query.getResultList();
		if (entries == null) {
			entries = new ArrayList<BlogEntry>();
		}
		return entries;
	}

	public void deleteBlogEntry(BlogEntry blogEntry) {
		blogEntry = em.merge(blogEntry);
		em.remove(blogEntry);
	}
}
