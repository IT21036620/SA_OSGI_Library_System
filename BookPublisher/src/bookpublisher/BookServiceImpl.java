package bookpublisher;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



public class BookServiceImpl implements BookService {
//	private Connection connection = null;
//	private Statement statement = null;
//	private Database database;
//	private ResultSet resultSet;
	private static Scanner scan;
	private ArrayList<String[]> list;
	private HashMap<String, String> bookAvailability;
	
	private static final String FILE_NAME = "C:\\Users\\miyur\\eclipse-workspace_02\\BookPublisher\\src\\bookpublisher\\book_data.txt";
	private static final String path = System.getProperty("user.dir") + "\\book_data.txt";
	
	private List<Book> bookList = new ArrayList<>();
	
	public BookServiceImpl() {
		
		scan = new Scanner(System.in);
		list = new ArrayList<String[]>();
		bookAvailability = new HashMap<String, String>();
//		this.bookList =this.getBooksbyFile();
		
		String book1[] = { "abc", "john", "Education", "isbn-1","1" };
		String book2[] = { "Sri lanka", "silva", "History", "isbn-2","1" };
		String book3[] = { "X+2", "newton", "MAthematics", "isbn-3","1" };
		
		list.add(book1);
		list.add(book2);
		list.add(book3);
		
//		bookAvailability.put("abc",1);
//		bookAvailability.put("Sri lanka",1);
//		bookAvailability.put("X+2",1);
	}
	
	
	@Override
	public void insertBookDetails() {
		String bookName, authorName,  genre, isbnNumber;
		String availability;
		
		System.out.println("\n------- Insert New Book To System --------\n");
		System.out.print("Enter books's name: ");
		bookName = scan.nextLine();
		System.out.print("Enter author's name: ");
		authorName = scan.nextLine();
		System.out.print("Enter genre: ");
		genre = scan.nextLine();
		System.out.print("Enter ISBN number: ");
		isbnNumber = scan.nextLine();
		
//		System.out.print("Enter availability: ");
		availability = "available";
//		scan.nextLine();
	
		String tempBook[] = {bookName,authorName, genre, isbnNumber, availability};
		Book newBook = new Book(bookName,authorName,genre,isbnNumber,availability);
		
		try(BufferedWriter writer  = new BufferedWriter(new FileWriter(FILE_NAME,true));) {
			
			writer.write("\n" + newBook.getBookName()+","+ newBook.getAuthorName()+","+ newBook.getGenre()+","+ newBook.getIsbnNUmber()
			+"," + newBook.getAvailability());
			
			System.out.println(newBook.getBookName());
			System.out.println(newBook.getAvailability());
			
			
			this.bookAvailability.put(bookName.toLowerCase(), availability);
			
			System.out.println("\nNew Book added successfully....\n");
			writer.close();
			
		}catch(IOException e){
			System.out.println("Writing error: " + e.getMessage());
			
		}
		
		
//		this.list.add(tempBook);
//		this.bookAvailability.put(bookName.toLowerCase(), availability);
		
		
//		Book book = new Book(bookName, authorName, isbnNumber, isbnNumber, availability);
		
		
	}
	
	

	public List<Book> getBookListByClass() {
		return bookList;
	}


	@Override
	public void getAvailableBooks() {
		// TODO Auto-generated method stub
		int count = 0;
		List<Book> bookListtoAvailabale = this.getBooksbyFile();
		
		for(Book book: bookListtoAvailabale) {
			if(book.getAvailability().equals("available")) {
				System.out.println(count + ". " + book.getBookName());
				count++;
				
			}
		}
		
//		for(int i=0; i<list.size(); i++) {
//			if(Integer.valueOf(list.get(i)[4]) == 1 ) {
//				System.out.println(count + ". " + list.get(i)[0]);
//				count++;
//			}
//		}
		
	}

	@Override
	public void getAllBooks() {
		// TODO Auto-generated method stub
		int count = 0;
		List<Book> bookListtoAvailabale = this.getBooksbyFile();
		
		for(Book book: bookListtoAvailabale) {
			
				System.out.println(count +1+ ". " + book.getBookName());
				count++;
				
		}
		
	}

	@Override
	public void searchBookDetails(String keyword) {
		// TODO Auto-generated method stub
		int count = 0;
		List<Book> bookListtoAvailabale = this.getBooksbyFile();
		
		for(Book book: bookListtoAvailabale) {
			if(book.getBookName().contains(keyword) || book.getAuthorName().contains(keyword) 
					|| book.getGenre().contains(keyword) || book.getIsbnNUmber().contains(keyword)) {
				System.out.println(count + ". " + book.getBookName()
				+" "+book.getAuthorName() + " "+ book.getGenre()+" " + book.getAvailability()) ;
				count++;
				
			}
		}
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i)[0].contains(keyword) ||  list.get(i)[1].contains(keyword)) {
				System.out.println(count + ". " + list.get(i)[0]);
				count++;
			}
		}
		
		
	}

	@Override
	public boolean getAvailability(String name) {
		// TODO Auto-generated method stub
		if(this.bookAvailability.containsKey(name) && this.bookAvailability.get(name)=="available") {
			return true;		
		}
		
		return false;
	}

	@Override
	public void changeAvailability(String name) {
		// TODO Auto-generated method stub
		if(this.bookAvailability.containsKey(name) && this.bookAvailability.get(name)=="available") {
			this.bookAvailability.put(name, "not available");		
		}
		else if(this.bookAvailability.containsKey(name) && this.bookAvailability.get(name)=="not available") {
			this.bookAvailability.put(name, "available");
			
		}
		
		
	}
	
	public String changeString(String name) {
		if(name.equals("available")) {
			return "not available";
		}
		else {
			return "available";
		}
	}
	
	public void editBookDetails(String name, String command) {
//		File oldfile = new File(FILE_NAME);
//		File newfile = new File("C:\\Users\\miyur\\eclipse-workspace_02\\BookPublisher\\src\\bookpublisher\\temp.txt");
		List<Book> bookListtoUpdate = this.getBooksbyFile();
//		String bName = ""; String bAuthor = ""; String bGenre = ""; String bisbn = "";
//		String bAvail = "";
//		boolean result;
		Scanner scan2 = new Scanner(System.in);
		
		String tbName = ""; String tbAuthor = ""; String tbGenre = ""; String tbisbn = "";
		
		try(BufferedWriter writer  = new BufferedWriter(new FileWriter(FILE_NAME,false));) {
			
			for(Book book: bookListtoUpdate) {
				
				if(book.getBookName().equals(name)) {
					System.out.println("Enter new name: ");
					tbName = scan2.nextLine();
					System.out.println("Enter new author name: ");
					tbAuthor = scan2.nextLine();
					System.out.println("Enter new genre name: ");
					tbGenre = scan2.nextLine();
					System.out.println("Enter new isbn number: ");
					tbisbn = scan2.nextLine();
					
					if(command.equals("CHANGE-AVAIL-ORDER")) {
						book.setAvailability(changeString(book.getAvailability()));
					}
					
					writer.write(tbName+","+ tbAuthor+","+ tbGenre+","+ tbisbn
					+"," + book.getAvailability()+"\n" );
					
										
				}
				else {
				
				writer.write(book.getBookName()+","+ book.getAuthorName()+","+ book.getGenre()+","+ book.getIsbnNUmber()
				+"," + book.getAvailability() + "\n" );
				}
			}
			
			
			
//			System.out.println(newBook.getBookName());
//			System.out.println(newBook.getAvailability());
			
			
//			this.bookAvailability.put(bookName.toLowerCase(), availability);
			
			System.out.println("\nBook updated successfully....\n");
			writer.close();
			
		}catch(IOException e){
			System.out.println("Writing error: " + e.getMessage());
			
		}
		

//		try {
//			result = newfile.createNewFile();
//			if(result) {
//				
//				try {
//				FileWriter fw = new FileWriter("temp.txt",true);
//				BufferedWriter bw = new BufferedWriter(fw);
//				PrintWriter pw = new PrintWriter(bw);
//				
//				scan = new Scanner(new File(FILE_NAME));
//				scan.useDelimiter("[,\n]");
//				
//				while(scan.hasNext()) {
//					bName = scan.next();
//					System.out.println(bName);
//					bAuthor = scan.next();
//					bGenre = scan.next();
//					bisbn = scan.next();
//					bAvail = scan.next();
//					System.out.println(bAuthor);
//					if(bName.equals(name)) {
//						System.out.println("Enter new name: ");
//						tbName = scan2.nextLine();
//						System.out.println("Enter new author name: ");
//						tbAuthor = scan2.nextLine();
//						System.out.println("Enter new genre name: ");
//						tbGenre = scan2.nextLine();
//						System.out.println("Enter new isbn number: ");
//						tbisbn = scan2.nextLine();
//						
//						pw.println(tbName+","+tbAuthor+","+tbGenre+","+tbisbn+","+bAvail);
//						
//					}
//					else {
//						pw.println(bName+","+bAuthor+","+bGenre+","+bisbn+","+bAvail);
//					}
//					
//				}
//				
//				scan.close();
//				scan2.close();
//				pw.flush();
//				pw.close();
//				oldfile.delete();
//				File dump = new File(FILE_NAME);
//				newfile.renameTo(dump);
//				
//				}catch(Exception e) {
//					System.out.println("file edit: " + e.getMessage());
//				}
//				
//				
//				
//			}
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("can't create file" + e.getMessage());
//		}
//		
	}




	@SuppressWarnings("finally")
	@Override
	public List<Book> getBooksbyFile() {
		// TODO Auto-generated method stub
		List<Book> bookList = new ArrayList<>();
		
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(FILE_NAME)))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
            	
                String[] parts = line.split(",");
//                int id = Integer.parseInt(parts[0]);
                String name = parts[0];
                String author = parts[1];
                String genre = parts[2];
                String isbn = parts[3];
                String availability = parts[4];
                Book book = new Book(name, author,genre,isbn, availability);
                
//                System.out.println(book.getBookName());
                bookList.add(book);
            }
        } catch (IOException e) {
            System.err.println("Error reading book data from file: " + e.getMessage());
        }finally {
        	return bookList;
        }     
		
	}
	
	
	

}
