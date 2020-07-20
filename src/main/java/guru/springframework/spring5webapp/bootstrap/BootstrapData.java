/**
 * 
 */
package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

/**
 * @author Kedar
 *
 */
@Component
public class BootstrapData implements CommandLineRunner {

	private final AuthorRepository authorRepo;
	private final BookRepository bookRepo;
	private final PublisherRepository publisherRepo;
	
	/**
	 * @param authorRepo
	 * @param bookRepo
	 */
	public BootstrapData(AuthorRepository authorRepo, BookRepository bookRepo, PublisherRepository publisherRepo) {
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
		this.publisherRepo = publisherRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Publisher addWesley = new Publisher("Addison Wesley", "13th st", "Boston", "Massachusettes", 50005);
		publisherRepo.save(addWesley);
		
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "D3445267");
		
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		ddd.setPublisher(addWesley);
		
		addWesley.getBooks().add(ddd);
				
		authorRepo.save(eric);
		bookRepo.save(ddd);
		publisherRepo.save(addWesley);
				
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "EJ544678");
		
		rod.getBooks().add(noEJB);		
		noEJB.getAuthors().add(rod);
		noEJB.setPublisher(addWesley);
		
		addWesley.getBooks().add(noEJB);
		
		authorRepo.save(rod);
		bookRepo.save(noEJB);
		publisherRepo.save(addWesley);
		
		System.out.println("Started in Bootstrap");
		System.out.println("Number of books : "+bookRepo.count());
		System.out.println("Number of publishers : "+addWesley.getBooks().size());
	}
}
