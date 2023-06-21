package mate.adapter.out.persistence.matePost;

import lombok.RequiredArgsConstructor;
import mate.application.port.out.matePost.*;
import mate.domain.MatePost;
import mate.global.annotation.PersistenceAdapter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter
public class MatePostPersistenceAdapter
        implements SaveMatePostPort {

    private final MatePostJpaRepo matePostJpaRepo;
    private final MatePostPersistenceMapper matePostPersistenceMapper;

    @Override
    public void saveMatePost(MatePost matePost) {
        matePostJpaRepo.save(matePostPersistenceMapper.mapToJpaEntity(matePost));
    }


}
