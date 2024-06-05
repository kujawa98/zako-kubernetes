package pl.qcu.zakokubernetes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.qcu.zakokubernetes.controller.dto.BookmarkDto;
import pl.qcu.zakokubernetes.controller.dto.BookmarksDto;
import pl.qcu.zakokubernetes.controller.mapper.BookmarkMapper;
import pl.qcu.zakokubernetes.model.BookmarkRepository;

import static pl.qcu.zakokubernetes.controller.mapper.BookmarkMapper.toDto;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;

    @Transactional(readOnly = true)
    public BookmarksDto getBookmarks(Integer page) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 2, Sort.Direction.DESC, "createdAt");
        Page<BookmarkDto> bookmarks = bookmarkRepository.findBookmarks(pageable);
        return new BookmarksDto(bookmarks);
    }

    @Transactional(readOnly = true)
    public BookmarksDto searchBookmarks(String query, Integer page) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 2, Sort.Direction.DESC, "createdAt");
        Page<BookmarkDto> bookmarks = bookmarkRepository.findByTitleContainsIgnoreCase(query, pageable);
        return new BookmarksDto(bookmarks);
    }
}
