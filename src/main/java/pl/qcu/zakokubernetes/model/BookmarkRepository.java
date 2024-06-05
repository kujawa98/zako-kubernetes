package pl.qcu.zakokubernetes.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.qcu.zakokubernetes.controller.dto.BookmarkDto;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    @Query("select new pl.qcu.zakokubernetes.controller.dto.BookmarkDto(b.id,b.title,b.url,b.createdAt) from Bookmark b")
    Page<BookmarkDto> findBookmarks(Pageable pageable);

    @Query("""
            select new pl.qcu.zakokubernetes.controller.dto.BookmarkDto(b.id,b.title,b.url,b.createdAt) from Bookmark b
            where lower(b.title) like lower(concat('%', :query,'%') )
            """)
    Page<BookmarkDto> searchBookmarks(String query, Pageable pageable);

    Page<BookmarkDto> findByTitleContainsIgnoreCase(String title, Pageable pageable);

}
