package hellojpa.domain.testdomain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@Getter @Setter
@RequiredArgsConstructor
public class Period {
    private LocalDateTime startDate;
    private LocalDateTime endDate;


}
