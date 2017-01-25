package com.book.web;

import com.book.AmazonProperties;
import com.book.Reader;
import com.book.domain.Book;
import com.book.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
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


    private ReadingListRepository readingListRepository;
    private AmazonProperties amazonProperties;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository,
                                 AmazonProperties amazonProperties) {
        this.readingListRepository = readingListRepository;
        this.amazonProperties = amazonProperties; //AmazonProperties 주입
    }


    @RequestMapping(method = RequestMethod.GET)
    public String readersBooks(Reader reader,Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if(readingList != null) {
            model.addAttribute("books",readingList);
            model.addAttribute("reader",reader);
            model.addAttribute("amazonID",amazonProperties.getAssociateId()); //제휴 ID를 모델에 추가
        }

        return "readingList";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String andToReadingList(Reader reader, Book book) {

        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/";
    }
}
