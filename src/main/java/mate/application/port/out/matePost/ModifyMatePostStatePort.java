package mate.application.port.out.matePost;

import mate.domain.MatePost;

public interface ModifyMatePostStatePort {

    void modifyMatePost(MatePost matePost, User user);

}
