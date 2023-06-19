package mate.adapter.in.web.matePost;

import lombok.RequiredArgsConstructor;
import mate.application.port.in.usecase.JoinMateUseCase;
import mate.global.annotation.LoginUser;
import mate.global.utils.ReturnObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/matePost")
public class MatePostJoinController {

    private final JoinMateUseCase joinMateUseCase;

    @GetMapping("/join/{matePostId}")
    public ResponseEntity<ReturnObject> joinMate(
            @LoginUser User user,
            @PathVariable("matePostId") Long matePostId
    ) {
        joinMateUseCase.joinMate(matePostId, user);

        ReturnObject returnObject = ReturnObject.builder()
                .success(true)
                .data("운동에 조인하셨습니다.")
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(returnObject);
    }


}
