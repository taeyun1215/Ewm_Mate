package mate.adapter.in.web.matePost;

import lombok.RequiredArgsConstructor;
import mate.adapter.in.request.SearchRequireMatePostRequest;
import mate.adapter.out.response.SearchRequireMatePostResponse;
import mate.application.port.in.query.SearchMatePostQuery;
import mate.domain.MatePost;
import mate.global.annotation.LoginUser;
import mate.global.utils.ReturnObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/matePost")
public class MatePostSearchController {

    private final SearchMatePostQuery searchMatePostQuery;

    @PostMapping("/search")
    public ResponseEntity<ReturnObject> searchMatePost(
            @LoginUser User user,
            @RequestBody SearchRequireMatePostRequest searchRequireMatePostRequest
    ) {
        List<MatePost> matePosts = searchMatePostQuery.searchMatePostList(searchRequireMatePostRequest, user);

        SearchRequireMatePostResponse response = SearchRequireMatePostResponse.from(matePosts);

        ReturnObject returnObject = ReturnObject.builder()
                .success(true)
                .data(response)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(returnObject);
    }

}
