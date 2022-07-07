package org.javacream.books.warehouse.api;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BOOKS")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String isbn;

    @Column(name = "BOOK_TITLE")
    private String title;

    private double price;

    @Transient
    private boolean available;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (available != other.available)
            return false;
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        } else if (!isbn.equals(other.isbn))
            return false;
        if (Double.doubleToLongBits(price) != Double
                .doubleToLongBits(other.price))
            return false;
        if (title == null) {
			return other.title == null;
        } else return title.equals(other.title);
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (available ? 1231 : 1237);
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return (new StringBuffer("BookValue: isbn=").append(isbn).append(
                        ", title=").append(title).append(", price=").append(price)
                .append(
                        ", available=").append(available)).toString();
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }


}
