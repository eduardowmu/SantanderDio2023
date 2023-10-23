package dio.me.edu.mapper;

import dio.me.edu.dto.UserDTO;
import dio.me.edu.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {
    @Mapping(target = "id", expression = "java(userDTO.getId())")
    @Mapping(target = "name", expression = "java(userDTO.getName())")
    @Mapping(target = "account", expression = "java(userDTO.getAccount())")
    @Mapping(target = "card", expression = "java(userDTO.getCard())")
    @Mapping(target = "news", expression = "java(userDTO.getNews())")
    @Mapping(target = "featureList", expression = "java(userDTO.getFeatureList())")
    User toUser(UserDTO userDTO);

    @Mapping(target = "id", expression = "java(user.getId())")
    @Mapping(target = "name", expression = "java(user.getName())")
    @Mapping(target = "account", expression = "java(user.getAccount())")
    @Mapping(target = "card", expression = "java(user.getCard())")
    @Mapping(target = "news", expression = "java(user.getNews())")
    @Mapping(target = "featureList", expression = "java(user.getFeatureList())")
    UserDTO toUserDTO(User user);
}