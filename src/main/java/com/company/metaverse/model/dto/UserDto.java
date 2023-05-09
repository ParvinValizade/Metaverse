package com.company.metaverse.model.dto;


import java.time.LocalDate;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String firstName;

    private String lastName;

    private String patronymic;

    private String pin;

    private int age;

    private String email;

    private LocalDate birthDate;

    private String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserDto)) {
            return false;
        }
        UserDto userDto = (UserDto) o;
        return getAge() == userDto.getAge() && Objects.equals(getFirstName(), userDto.getFirstName()) &&
                Objects.equals(getLastName(), userDto.getLastName()) &&
                Objects.equals(getPatronymic(), userDto.getPatronymic()) &&
                Objects.equals(getPin(), userDto.getPin()) &&
                Objects.equals(getEmail(), userDto.getEmail()) &&
                Objects.equals(getAddress(), userDto.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getPatronymic(), getPin(), getAge(), getEmail(),
                getAddress());
    }
}
