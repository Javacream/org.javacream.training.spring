package org.javacream.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.javacream.books.warehouse.api.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JpaDemo {
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired JpaDemo2 demo2;
	@Transactional(propagation=Propagation.REQUIRED)
	public void doDemo() {
		final String ISBN = "ISBN";
		Book book = new Book();
		book.setIsbn(ISBN);
		book.setTitle("Title");
		book.setPrice(19.99);
		//CRUD-Operations
		//Create -> persist
		entityManager.persist(book);
		book.setTitle("CHANGED");
		System.out.println(book.getTitle());
		//<READ -> find
		Book searchResult1 = entityManager.find(Book.class, ISBN);
		Book searchResult2 = entityManager.createQuery("select b from Book as b", Book.class).getResultList().get(0);
		List<String> titleList = (List<String>) entityManager.createQuery("select b.title from Book as b").getResultList();
		System.out.println(titleList);
		searchResult1.setPrice(99.99);
		searchResult2.setTitle("CHANGED AGAIN");
		System.out.println(book.getPrice());
		System.out.println("IDENTITY: " + (book == searchResult1));
		//entityManager.flush();
		//entityManager.detach(book);
		demo2.doSomething();		
		System.out.println("***************" + book.getPrice());
		entityManager.detach(book);
		book.setPrice(0.99);
		//UPDATE -> merge
		Book attachedBook = entityManager.merge(book);
		attachedBook.setTitle("CHANGED AGAIN AND AGAIN");
		entityManager.clear();
		//DELETE -> remove
		Book toDelete = entityManager.getReference(Book.class, ISBN);
		entityManager.remove(toDelete);
		
		
	}//commit: entityManager synchronisiert sich mit der Datenbank

}
