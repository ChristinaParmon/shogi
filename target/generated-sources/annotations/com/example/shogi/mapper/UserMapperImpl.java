package com.example.shogi.mapper;

import com.example.shogi.dto.UserDto;
import com.example.shogi.models.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-27T14:38:37+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        if ( dto.getId() != null ) {
            user.setId( Long.parseLong( dto.getId() ) );
        }
        user.setPassword( dto.getPassword() );
        user.setUsername( dto.getUsername() );
        user.setEmail( dto.getEmail() );
        user.setPhone( dto.getPhone() );
        user.setRole( dto.getRole() );

        return user;
    }

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        if ( user.getId() != null ) {
            userDto.setId( String.valueOf( user.getId() ) );
        }
        userDto.setUsername( user.getUsername() );
        userDto.setEmail( user.getEmail() );
        userDto.setPhone( user.getPhone() );
        userDto.setRole( user.getRole() );
        userDto.setPassword( user.getPassword() );

        return userDto.build();
    }

    @Override
    public List<User> toEntities(List<UserDto> userDtos) {
        if ( userDtos == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userDtos.size() );
        for ( UserDto userDto : userDtos ) {
            list.add( toEntity( userDto ) );
        }

        return list;
    }

    @Override
    public List<UserDto> toDtos(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( users.size() );
        for ( User user : users ) {
            list.add( toDto( user ) );
        }

        return list;
    }
}
