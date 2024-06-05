package pl.qcu.zakokubernetes.controller.mapper;

import pl.qcu.zakokubernetes.controller.dto.BookmarkDto;
import pl.qcu.zakokubernetes.model.Bookmark;

public class BookmarkMapper {
    public static BookmarkDto toDto(Bookmark bookmark) {
        return new BookmarkDto(bookmark.getId(), bookmark.getTitle(), bookmark.getUrl(), bookmark.getCreatedAt());
    }
}
