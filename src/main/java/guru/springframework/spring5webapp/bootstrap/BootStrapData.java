package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository ;
    private  final BookRepository bookRepository ;
    private  final PublisherRepository publisherRepository ;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric","Evans");
        Book book = new Book("Design Driven Developement","12341234");
        eric.getBooks().add(book);
        book.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(book);


        Author rob = new Author("Rob","Johnson");
        Book noEJB = new Book("J2EE Developement without EJB","12341234");
        rob.getBooks().add(noEJB);
        noEJB.getAuthors().add(rob);
        authorRepository.save(rob);
        bookRepository.save(noEJB);


        Publisher publisher = new Publisher("Onno Rokom","Dhaka");
        publisher.getAuthors().add(eric);
        publisher.getAuthors().add(rob);
        publisherRepository.save(publisher);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: "+bookRepository.count());
        System.out.println("Number of publisher: "+publisherRepository.count());


    }
}
