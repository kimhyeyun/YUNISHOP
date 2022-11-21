package com.example.yunishop.web.dto;

import com.example.yunishop.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@NoArgsConstructor
public class MemberFormDto {

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String name;
    @NotEmpty(message = "아이디는 필수 입력 값입니다.")
    private String memberId;
    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min = 8, max = 16, message = "비밀번호는 8자 이상, 16자 이하로 입력해주세요.")
    private String password;
    @NotEmpty(message = "주소는 필수 입력 값입니다.")
    private int postCode;
    private String address;
    private String additionalAddress;

    public MemberFormDto(String memberId, String password, int postCode, String address, String additionalAddress) {
        this.memberId = memberId;
        this.password = password;
        this.postCode = postCode;
        this.address = address;
        this.additionalAddress = additionalAddress;
    }

    @Builder
    public Member toEntity() {
        return Member.builder()
                .name(name)
                .memberId(memberId)
                .password(password)
                .postCode(postCode)
                .address(address)
                .addtionalAddress(additionalAddress)
                .build();
    }
}
