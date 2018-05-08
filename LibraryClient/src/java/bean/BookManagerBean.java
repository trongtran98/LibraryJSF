/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Sach;
import java.io.InputStream;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import model.SachFacade;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Trong Tran
 */
public class BookManagerBean {

    @EJB
    private SachFacade sachFacade;


    /**
     * Creates a new instance of BookManagerBean
     */
    public BookManagerBean() {

    }

    private Sach book;
    private List<Sach> listBooks;
    private StreamedContent file;
    String keyword = "";
    
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public StreamedContent getFile() {
        InputStream iStream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/files/" + book.getTenfile());
        file = new DefaultStreamedContent(iStream, "application/pdf", book.getTenfile());
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }

    public Sach getBook() {
        return book;
    }

    public void setBook(Sach book) {
        this.book = book;
    }

    public void setListBooks(List<Sach> listBooks) {
        this.listBooks = listBooks;
    }

    public List<Sach> getListBooks() {
        listBooks = sachFacade.getBooks(keyword);
        return listBooks;
    }

}
