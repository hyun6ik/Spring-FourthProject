package hellojpa.domain.testdomain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter
@RequiredArgsConstructor
public class Address {
    private String city;
    private String street;
    private String zipcode;


}
