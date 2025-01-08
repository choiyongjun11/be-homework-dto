package com.springboot.coffee;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter

public class CoffeePatchDto {
    private long coffeeId;

   // @NotNull
    //@Pattern(regexp = "^([ㄱ-ㅎ|가-힣]+)(\\s?[ㄱ-ㅎ|가-힣])+$", message = "한글만 입력이 가능합니다")
    @NotBlank
    @Pattern(regexp = "^[가-힣]+$", message = "공백 없이 한글로만 입력이 가능합니다.")
    private String korName;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]+(\\s?[a-zA-Z])+$", message = "영문만 입력이 가능합니다")
    private String engName;

    @Min(value = 100) @Max(value = 50000)
    private int price;

}
