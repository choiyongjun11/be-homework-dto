package com.springboot.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/coffees")
@Validated
public class CoffeeController {

    // 1. DTO 클래스 및 유효성 검증을 적용하세요.

    @PostMapping
    public ResponseEntity postCoffee(@Valid @RequestBody CoffeePostDto coffeePostDto ) {
        return new ResponseEntity<>(coffeePostDto, HttpStatus.CREATED);

    }

    // 2. DTO 클래스 및 유효성 검증을 적용하세요.
    // 특정 ID 값에 대해서 어떠한 행위가 이루어 질 때도 유효성 검증을 적용해야 한다.
    // 특정 ID 를 조회 할 때 ID: -123 음수가 들어가면 안되기 떄문이다.
    // 즉 PathVariable에는 @Min 애너테이션을 사용하여 양수만 허용할 수 있도록 만들어줘야 한다.

    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@PathVariable("coffee-id") @Min(1) long coffeeId,
                                    @Valid @RequestBody CoffeePatchDto coffeePatchDto) {

        coffeePatchDto.setCoffeeId(coffeeId);
        return new ResponseEntity<>(coffeePatchDto, HttpStatus.OK);

    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") @Min(1) long coffeeId) {
        System.out.println("# coffeeId: " + coffeeId);
        // not implementation
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees() {
        System.out.println("# get Coffees");
        // not implementation
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id") @Min(1) long coffeeId) {
        // No need business logic
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
