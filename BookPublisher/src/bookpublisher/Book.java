package bookpublisher;

public class Book {
	
//	private Integer bookId;
	private String bookName;
	private String authorName;
	private String genre;
	private String isbnNUmber;
	private String availability;
	
	
	public Book() {}


	public Book( String bookName, String authorName, String genre, String isbnNUmber,
			String availability) {

//		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.genre = genre;
		this.isbnNUmber = isbnNUmber;
		this.availability = availability;
	}


//	public Integer getBookId() {
//		return bookId;
//	}
//
//
//	public void setBookId(Integer bookId) {
//		this.bookId = bookId;
//	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getAuthorName() {
		return authorName;
	}


	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getIsbnNUmber() {
		return isbnNUmber;
	}


	public void setIsbnNUmber(String isbnNUmber) {
		this.isbnNUmber = isbnNUmber;
	}


	public String getAvailability() {
		return availability;
	}


	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	
	
	
	
	
	

}
