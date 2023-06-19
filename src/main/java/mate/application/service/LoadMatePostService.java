package mate.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mate.application.port.in.query.LoadMatePostQuery;
import mate.application.port.out.matePost.LoadMatePostPort;
import mate.domain.MatePost;
import mate.global.annotation.UseCase;

import javax.transaction.Transactional;

@Slf4j
@UseCase
@RequiredArgsConstructor
@Transactional
public class LoadMatePostService implements LoadMatePostQuery {

    private final LoadMatePostPort loadMatePostPort;

    @Override
    public MatePost loadMatePost(Long matePostId) {
        return loadMatePostPort.loadMatePost(matePostId);
    }

}
