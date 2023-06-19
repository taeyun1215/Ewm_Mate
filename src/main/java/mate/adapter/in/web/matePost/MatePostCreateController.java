package mate.adapter.in.web.matePost;

import lombok.RequiredArgsConstructor;
import mate.adapter.in.request.CreateMatePostRequest;
import mate.application.port.in.usecase.CreateMatePostUseCase;
import mate.global.annotation.LoginUser;
import mate.global.utils.ReturnObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/matePost")
public class MatePostCreateController {

    private final CreateMatePostUseCase createMatePostUseCase;

    @PostMapping("/create")
    public ResponseEntity<ReturnObject> createMatePost(
            @LoginUser User user,
            @RequestBody CreateMatePostRequest createMatePostRequest
    ) {
        createMatePostUseCase.createMatePost(createMatePostRequest, user);

        ReturnObject returnObject = ReturnObject.builder()
                .success(true)
                .data("생성이 완료 되었습니다.")
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(returnObject);
    }
}
