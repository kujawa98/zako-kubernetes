package pl.qcu.zakokubernetes.controller.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import pl.qcu.zakokubernetes.model.Bookmark;

import java.util.List;

@Setter
@Getter
public class BookmarksDto {
    private List<BookmarkDto> bookmarks;
    private long totalElements;
    private int totalPages;
    private int currentPage;
    private boolean isFirst;
    private boolean isLast;
    private boolean hasNext;
    private boolean hasPrevious;

    public BookmarksDto(Page<BookmarkDto> bookmarkPage) {
        this.bookmarks = bookmarkPage.getContent();
        this.totalElements = bookmarkPage.getTotalElements();
        this.totalPages = bookmarkPage.getTotalPages();
        this.currentPage = bookmarkPage.getNumber()+1;
        this.isFirst = bookmarkPage.isFirst();
        this.isLast = bookmarkPage.isLast();
        this.hasNext = bookmarkPage.hasNext();
        this.hasPrevious = bookmarkPage.hasPrevious();
    }
}
