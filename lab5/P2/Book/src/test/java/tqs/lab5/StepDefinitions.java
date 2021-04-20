package tqs.lab5;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ParameterType;
import java.time.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.String;
import java.text.SimpleDateFormat;
import java.io.*;

public class StepDefinitions {
    Library library = new Library();
    List<Book> result = new ArrayList<>();

    @Given("a book called {string} which author is {string}, published at {int}-{int}-{int}")
    public void a_book_called_which_author_is_published_at(String string, String string2, Integer int1, Integer int2, Integer int3) throws Exception {
        Book b = new Book(string, string2, new SimpleDateFormat("dd/MM/yyyy").parse(int3 + "/" + int2 + "/" + int1));
        library.addBook(b);
    }

    @Given("another book called {string} which author is {string}, published at {int}-{int}-{int}")
    public void another_book_called_which_author_is_published_at(String string, String string2, Integer int1, Integer int2, Integer int3) throws Exception {
        Book b = new Book(string, string2, new SimpleDateFormat("dd/MM/yyyy").parse(int3 + "/" + int2 + "/" + int1));
        library.addBook(b);
    }
    @When("the customer searches for book which author is {string}")
    public void the_customer_searches_for_book_which_author_is(String string) {
        result = library.findBooks(string);
    }
    @Then("{int} books should have been found")
    public void books_should_have_been_found(Integer int1) {
        assertThat(result.size(), equalTo(int1));
    }
    @Then("Book {int} should have the title {string}")
    public void book_should_have_the_title(Integer int1, String string) {
        assertThat(result.get(int1 - 1).getTitle(), equalTo(string));
    }
    @When("the customer searches for books published between {int} and {int}")
    public void the_customer_searches_for_books_published_between_and(Integer int1, Integer int2) throws Exception {
        result = library.findBooks( new SimpleDateFormat("dd/MM/yyyy").parse("01/01/" + int1), new SimpleDateFormat("dd/MM/yyyy").parse("01/01/" + int2));
    }

    /* Acabei por não usar, mas fica aqui ao exemplo de utilização


    @ParameterType("([0-9]{4})-([0-9]{2})-([0-9]{2})")
    public LocalDateTime iso8601Date(String year, String month, String day){
        return LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), 0,0,0);
    }

    @When("the customer searches for books published between {iso8601Date} and {iso8601Date}")
    public void the_customer_searches_for_books_published_between_and(final LocalDateTime from, final LocalDateTime to) throws Exception {
        result = library.findBooks(from, to);
    }
    */
}

class Book {
    private final String title;
    private final String author;
    private final Date published;

    public Book(String title, String author, Date published){
        this.title=title;
        this.author=author;
        this.published=published;
    }
    // constructors, getter, setter ommitted

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Date getPublished() {
        return published;
    }


}

class Library {
    private final List<Book> store = new ArrayList<>();

    public void addBook(final Book book) {
        store.add(book);
    }

    public List<Book> findBooks(final Date from, final Date to) {
        Calendar end = Calendar.getInstance();
        end.setTime(to);
        end.roll(Calendar.YEAR, 1);

        return store.stream().filter(book -> {
            return from.before(book.getPublished()) && end.getTime().after(book.getPublished());
        }).sorted(Comparator.comparing(Book::getPublished)).collect(Collectors.toList());
    }

    public List<Book> findBooks(final String author) {
        return store.stream().filter(book -> {
            return book.getAuthor().equals(author);
        }).sorted(Comparator.comparing(Book::getPublished).reversed()).collect(Collectors.toList());
    }
}
