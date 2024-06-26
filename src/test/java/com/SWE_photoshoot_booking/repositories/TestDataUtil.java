package com.SWE_photoshoot_booking.repositories;

import com.SWE_photoshoot_booking.domain.dto.UserDto;
import com.SWE_photoshoot_booking.domain.entities.UserEntity;

import java.util.UUID;

public final class TestDataUtil {
    private TestDataUtil() {
    }

    public static UserEntity createTestUserA() {
        return UserEntity.builder()
                .userID(UUID.randomUUID())
                .name("Jack")
                .surname("Sparrow")
                .email("jack.sparrow@example.com")
                .password("12345678")
                .telephone("+393980878782").build();
    }

    public static UserEntity createTestUserB() {
        return com.SWE_photoshoot_booking.domain.entities.UserEntity.builder()
                .userID(UUID.randomUUID())
                .name("Alessandro")
                .surname("Capialbi")
                .email("capialbi.alessandro@example.com")
                .password("75899898")
                .telephone("+3937745898744").build();
    }

    public static UserEntity createTestUserC() {
        return com.SWE_photoshoot_booking.domain.entities.UserEntity.builder()
                .userID(UUID.randomUUID())
                .name("Bob")
                .surname("King")
                .email("bob.king@example.com")
                .password("34567875")
                .telephone("+13980878782").build();
    }

    public static UserDto createTestUserDtoA() {
        return UserDto.builder()
                .userID(UUID.randomUUID())
                .name("Jack")
                .surname("Sparrow")
                .email("jack.sparrow@gmail.com")
                .password("12345678")
                .telephone("+393980878782").build();
    }
}
