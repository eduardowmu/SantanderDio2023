package dio.me.edu.dto;

import dio.me.edu.model.Account;
import dio.me.edu.model.Card;
import dio.me.edu.model.Feature;
import dio.me.edu.model.News;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.aspectj.bridge.IMessage;
import org.hibernate.annotations.NotFound;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class UserDTO implements Serializable {
    private Long id;
    private String name;
    private Account account;
    private Card card;
    private List<Feature> featureList;
    private List<News> news;
}