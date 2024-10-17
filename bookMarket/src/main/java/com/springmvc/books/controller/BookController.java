package com.springmvc.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.books.service.BookService;
import com.springmvc.domain.Book;

@Controller // 클래스 레벨에 붙임 
@RequestMapping(value ="/book/")   //http://도메인/book/insert     http://도메인/books/book/insert
//@RestController ==>데이터만 넘겨줌
public class BookController {
	@Autowired //변수나 메서드에 붙임(생성자레벨,필드레벨,파라메터에도 붙일 수 있음)
	BookService bookService;
	
	//view 페이지에서 <%@ taglib %> spring form을 사용한다면 form에 입력된 데이터와 매칭되는 자바 vo 클래스를 지정해 줘야한다 
	@GetMapping("/addBook")
	public String addBook(Book book, Model model) {
		model.addAttribute("addTitle","신규책 등록");
		return "addBook1";
	}
	
	
	@PostMapping("/addBook") //getmapping postmapping 중 필요한 걸로 (http://도메인/books/book/insert에 입력한 자료(request body영역을 통해)를 넘겨주면서 요청해야 한다)
	public String insert(Book book){	//데이터만 전달 하고자 할때는 void , 그외 페이지를 반환하고 싶을 때는 String 이나 vo 객체
		bookService.insertBookService(book);
		/*
		if(book == null) { //아무것도 넘겨받지 않았다면
			return "/"; //home.jsp 로 가라
		}
		
	    Book book1 = new Book("ISBN1234", "C# 교과서", 30000,"박용준");
        book1.setDescription(
                "C# 교과서』는 생애 첫 프로그래밍 언어로 C#을 시작하는 독자를 대상으로 한다. 특히 응용 프로그래머를 위한 C# 입문서로, C#을 사용하여 게임(유니티), 웹, 모바일, IoT 등을 개발할 때 필요한 C# 기초 문법을 익히고 기본기를 탄탄하게 다지는 것이 목적이다.");
        book1.setPublisher("길벗");
        book1.setCategory("IT전문서");
        book1.setUnitsInStock(1000);
        book1.setReleaseDate("2020/05/29");
        bookService.insertBookService(book1);
        
        Book book2 = new Book("ISBN1235", "Node.js 교과서", 36000,"조현영");
        book2.setDescription(
                "이 책은 프런트부터 서버, 데이터베이스, 배포까지 아우르는 광범위한 내용을 다룬다. 군더더기 없는 직관적인 설명으로 기본 개념을 확실히 이해하고, 노드의 기능과 생태계를 사용해보면서 실제로 동작하는 서버를 만들어보자. 예제와 코드는 최신 문법을 사용했고 실무에 참고하거나 당장 적용할 수 있다.");
        book2.setPublisher("길벗");
        book2.setCategory("IT전문서");
        book2.setUnitsInStock(1000);
        book2.setReleaseDate("2020/07/25");
        bookService.insertBookService(book2);
        
        Book book3 = new Book("ISBN1236", "어도비 XD CC 2020", 25000,"김두한");
        book3.setDescription(
                "어도비 XD 프로그램을 통해 UI/UX 디자인을 배우고자 하는 예비 디자이너의 눈높이에 맞게 기본적인 도구를 활용한 아이콘 디자인과 웹&앱 페이지 디자인, UI 디자인, 앱 디자인에 애니메이션과 인터랙션을 적용한 프로토타이핑을 학습합니다.");
        book3.setPublisher("길벗");
        book3.setCategory("IT활용서");
        book3.setUnitsInStock(1000);
        book3.setReleaseDate("2019/05/29");
		bookService.insertBookService(book3);
		
		return "welcome"; // ==> /src/main/webapp/WEB-INF/views/book 경로 밑에 result.jsp 를 의미한다. */
		return "redirect:/book/all";
	} 
	
	/* 예전 스프링 버전에서는 model과 view정보를 담고있는 클래스를 이용했다
	@GetMapping(value="/all")
	public ModelAndView getAllBookList() {
		ModelAndView mav = new ModelAndView();
		//DB에 저장된 자료(전체 책 목록)를 
		List<Book> bookList = bookService.getAllBookList();
		//view 페이지에 속성을 통해 넘겨준다.(Request영역에 자료를 담아둠)
		mav.addObject("bookList",bookList);
		//view 지정	
		mav.setViewName("books")
		return mav;
	}
	*/
	
	@GetMapping(value="/all")
	public String getAllBookList(Model model) {
		//DB에 저장된 자료(전체 책 목록)를 
		List<Book> bookList = bookService.getAllBookList();
		//List<Book> bookList = bookService.getAllBookList(new Book());
		//view 페이지에 속성을 통해 넘겨준다.(Request영역에 자료를 담아둠)
		model.addAttribute("bookList",bookList);
		//view 지정	
		return "books";
	} 
	
	@GetMapping(value = "/getBook/{bookId}")
	public String getBook(@PathVariable String bookId,Model model) {
		System.out.println(bookId);
		List<Book> bookList = bookService.getBookOne(bookId);
		model.addAttribute("bookList",bookList);
		return "books";
	}
	
	@GetMapping(value = "/getBook/{category}/pub/{publisher}")
	public String getBook(@PathVariable String category,
						@PathVariable String publisher,
						Model model) {
		System.out.println("======>"+category+"   "+publisher);
		//Book book =  new Book(); 
		//book.setCategory(category);
		//book.setPublisher(publisher);
		//List<Book> bookList = bookService.getAllBookList(book);
		return "books";
	}
	
	
	//http://localhost/books/book/test?id=yyyy&pw=asdf
	//http://localhost/books/book/test?aa=yyyy&pw=asdf
	@GetMapping("/test")
	public String getTest(@RequestParam("aa") String id, String pw) {
		System.out.println(id);
		System.out.println(pw);
		return "home";
	}
}
