package flex.dev.SpringWebApp.bootstrap;

import flex.dev.SpringWebApp.domain.Author;
import flex.dev.SpringWebApp.domain.Book;
import flex.dev.SpringWebApp.domain.Publisher;
import flex.dev.SpringWebApp.repositories.AuthorRepository;
import flex.dev.SpringWebApp.repositories.BookRepository;
import flex.dev.SpringWebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.SchemaOutputResolver;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("Flex Limited");
        publisher.setCity("Nairobi");
        publisher.setState("Nrb");

        publisherRepository.save(publisher);
        System.out.println("Publisher count is: "+publisherRepository.count());
        Author eric = new Author("Eric", "Evance");
        Book ddd = new Book("Domain Driven Designs", "12345");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book j2ee = new Book("J2EE Java Developers", "1232455");
        rod.getBooks().add(j2ee);
        j2ee.getAuthors().add(rod);

        j2ee.setPublisher(publisher);
        publisher.getBooks().add(j2ee);

        authorRepository.save(rod);
        bookRepository.save(j2ee);

        System.out.println("Started at Bootstrap");
        System.out.println("The number of books: "+bookRepository.count());
        System.out.println("Publisher number of books: "+publisher.getBooks().size());


    }
}
