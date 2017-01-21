package com.book.web;

import com.book.domain.Book;
import com.book.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by tinoll on 2017. 1. 21..
 */
@Controller
@RequestMapping("/")
public class ReadingListController {

    private static final String reader = "craig";

    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String readersBooks(Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if(readingList != null) {
            model.addAttribute("books",readingList);
        }

        return "readingList";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String andToReadingList(Book book) {

        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/";
    }
}
