package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // our intent is to make this a spring mvc controller
public class BookController {
    private final BookRepository bookRepository; // this will be automatically instantiated because we have the controller annotation (dep injection)

    // just testing
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books") // this method will be executed when /books is called and this method is going to provide a model filled with books from our repo
    public String getBooks(Model model) // model is what is going to get returned to the view
    {
        model.addAttribute("books", bookRepository.findAll());
        return "books/list";
    }
}
