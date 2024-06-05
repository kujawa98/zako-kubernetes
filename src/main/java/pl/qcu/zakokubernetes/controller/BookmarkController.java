package pl.qcu.zakokubernetes.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.qcu.zakokubernetes.controller.dto.BookmarkDto;
import pl.qcu.zakokubernetes.controller.dto.BookmarksDto;
import pl.qcu.zakokubernetes.controller.request.CreateBookmarkRequest;
import pl.qcu.zakokubernetes.service.BookmarkService;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {
    private final BookmarkService bookmarkService;

    @GetMapping
    public BookmarksDto getBookmarks(@RequestParam(name = "page",defaultValue = "1") Integer page,
                                     @RequestParam(name = "query",defaultValue = "") String query) {
        if (query == null || query.trim().isEmpty()) {
            return bookmarkService.getBookmarks(page);
        }
        return bookmarkService.searchBookmarks(query,page);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookmarkDto addBookmark(@RequestBody @Valid CreateBookmarkRequest createBookmarkRequest) {
        return bookmarkService.createBookmark(createBookmarkRequest);
    }


}
