
package Model;

import java.util.Objects;

public class Blog {
    private int id;
    private String author;
    private String title;
    private String content;
    private String imageLink; 
    private String userId;
    public Blog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Blog(int id, String author, String title, String content, String imageLink, String userId) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.imageLink = imageLink;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Blog(int id, String author, String title, String content, String imageLink) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.imageLink = imageLink;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Blog other = (Blog) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.content, other.content)) {
            return false;
        }
        if (!Objects.equals(this.imageLink, other.imageLink)) {
            return false;
        }
        return true;
    }
 

    
    @Override
    public String toString() {
        return "Blog{" + "ID=" + id +",Author="+author + ",title"+ title+",content: "+ content+ ",imagelink= "+imageLink+ '}' ;
    }
    
    
}
