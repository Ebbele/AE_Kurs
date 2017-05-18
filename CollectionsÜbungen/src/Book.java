import java.lang.Comparable;
public class Book implements Comparable<Book> {
	private String author, title, issue;
	public String getAuthor() {
		return author; // Der schreiberling
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	
	public Book(String author, String title, String issue){
		setAuthor(author);
		setTitle(title);
		setIssue(issue);
	}
	@Override
	public int compareTo(Book book) {
		return this.author.compareTo(book.getAuthor());
	}

}
