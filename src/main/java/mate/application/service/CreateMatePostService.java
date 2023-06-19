package mate.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mate.adapter.in.request.CreateMatePostRequest;
import mate.application.port.in.usecase.CreateMatePostUseCase;
import mate.application.port.out.matePost.SaveMatePostPort;
import mate.domain.MatePost;
import mate.global.annotation.UseCase;

import javax.transaction.Transactional;

@Slf4j
@UseCase
@RequiredArgsConstructor
@Transactional
public class CreateMatePostService implements CreateMatePostUseCase {

    private final SaveMatePostPort saveMatePostPort;

    @Override
    public void createMatePost(CreateMatePostRequest createMatePostRequest, User user) {
        MatePost matepost = createMatePostRequest.toEntity(user);
        saveMatePostPort.saveMatePost(matepost, user);
    }

}
