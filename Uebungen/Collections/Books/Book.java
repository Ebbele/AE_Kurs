package Books;

public class Book implements Comparable<Book> {
	private String author;
	private String title;
	private int issue;

	public Book(String author, String title, int issue) {
		setAuthor(author);
		setTitle(title);
		setIssue(issue);
	}

	public String getAuthor() {
		return author;
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

	public int getIssue() {
		return issue;
	}

	public void setIssue(int issue) {
		this.issue = issue;
	}

	@SuppressWarnings("null")
	@Override
	public int compareTo(Book o) {
		if ((null == o) && (o.getClass() != getClass())) {
			return -1;
		}

		int i = author.compareTo(o.getAuthor());

		if (i != 0) {
			return i;
		} else {
			i = title.compareTo(o.getTitle());
			if (i != 0) {
				return i;
			} else {
				i = issue - o.issue;
				return i;
			}
		}
	}
	public int hashCode(){
		return (author.length() + issue ) % 7;
	}
	
	@Override
	public boolean equals(Object obj) {
		if( null == obj || obj.getClass() != getClass()){
			return false;
		}else{
			Book b = (Book)obj;
			if( b.getAuthor().equals(author) && b.getTitle().equals(title) && b.getIssue() == issue)
				return true;
		}
		return false;
		
	}
}
