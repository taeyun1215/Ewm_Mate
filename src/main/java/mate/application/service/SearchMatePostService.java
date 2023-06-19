package mate.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mate.adapter.in.request.SearchRequireMatePostRequest;
import mate.application.port.in.query.SearchMatePostQuery;
import mate.application.port.out.matePost.SearchMatePostPort;
import mate.domain.MatePost;
import mate.global.annotation.UseCase;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@UseCase
@RequiredArgsConstructor
@Transactional
public class SearchMatePostService implements SearchMatePostQuery {

    private final SearchMatePostPort searchMatePostPort;

    @Override
    public List<MatePost> searchMatePostList(SearchRequireMatePostRequest searchRequireMatePostRequest, User user) {
        MatePost matePost = searchRequireMatePostRequest.toEntity();
        List<MatePost> matePosts = searchMatePostPort.searchAll(matePost, user);

        return matePosts;
    }

}
