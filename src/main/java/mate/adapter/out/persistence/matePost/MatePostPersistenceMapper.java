package mate.adapter.out.persistence.matePost;

import mate.domain.MatePost;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MatePostPersistenceMapper {

    public MatePost mapToDomainEntity(MatePostJpaEntity matePostJpaEntity) {
//        List<Long> mateIds = matePostJpaEntity.getMates().stream()
//                .map(MateJpaEntity::getId)
//                .collect(Collectors.toList());

        return MatePost.builder()
                .matePostId(matePostJpaEntity.getId())
                .title(matePostJpaEntity.getTitle())
                .content(matePostJpaEntity.getContent())
                .gym(matePostJpaEntity.getGym())
                .writer(matePostJpaEntity.getWriter())
                .view(matePostJpaEntity.getView())
                .startTime(matePostJpaEntity.getStartTime())
                .endTime(matePostJpaEntity.getEndTime())
                .userId(matePostJpaEntity.getUserId())
                .mateIds(matePostJpaEntity.getMateIds())
                .build();
    }

    public List<MatePost> mapToDomainEntities(List<MatePostJpaEntity> matePostJpaEntities) {
        List<MatePost> matePosts = new ArrayList<>();
        for (MatePostJpaEntity matePostJpaEntity : matePostJpaEntities) {
            matePosts.add(mapToDomainEntity(matePostJpaEntity));
        }
        return matePosts;
    }

    public MatePostJpaEntity mapToJpaEntity(MatePost matePost) {
        return matePost.toJpaEntity();
    }

}
