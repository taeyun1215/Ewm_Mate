package mate.adapter.out.response;

import lombok.Builder;
import lombok.Getter;
import mate.domain.MatePost;

import java.util.List;

@Getter
@Builder
public class SearchRequireMatePostResponse {

    private List<MatePost> matePosts;

    public static SearchRequireMatePostResponse from(List<MatePost> matePosts) {
        return SearchRequireMatePostResponse.builder()
                .matePosts(matePosts)
                .build();
    }

}
