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
        implements SaveMatePostPort, SearchMatePostPort {

    private final MatePostJpaRepo matePostJpaRepo;
    private final MatePostPersistenceMapper matePostPersistenceMapper;

    @Override
    public void saveMatePost(MatePost matePost) {
        matePostJpaRepo.save(matePostPersistenceMapper.mapToJpaEntity(matePost));
    }

    @Override
    public List<MatePost> searchAll(MatePost matePost) {
        List<MatePostJpaEntity> matePostJpaEntities = matePostJpaRepo.searchAll(matePostPersistenceMapper.mapToJpaEntity(matePost));
        return matePostPersistenceMapper.mapToDomainEntities(matePostJpaEntities);
    }
}
