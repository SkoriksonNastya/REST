package ru.netology.rest.repository;

import org.springframework.stereotype.Repository;
import java.util.*;


@Repository
public class UserRepository {

    private final Map<User, List<Authorities>> USER_LIST;
    private final List<Authorities> AUTHORITIES_LIST;

    public UserRepository(){
        USER_LIST = new HashMap<>();
        AUTHORITIES_LIST = new ArrayList<>();

        User user1 = new User("Kristina","ljh10FF");
        User user2 = new User("Vladiimir", "bq91Oel");
        User user3 = new User("Daria", "qPPfx18hQQ");

        USER_LIST.put(user1, Arrays.asList(Authorities.values()));
        USER_LIST.put(user2, Arrays.asList(Authorities.READ,Authorities.WRITE));
        USER_LIST.put(user3, Arrays.asList(Authorities.READ));
    }

    public List<Authorities> getUserAuthorities(String userName, String userPassword){
        for (Map.Entry<User,List<Authorities>> entry : USER_LIST.entrySet()){
            if (entry.getKey().getUserName().equals(userName) && entry.getKey().getUserPassword().equals(userPassword)){
                return entry.getValue();
            }
        }
        return AUTHORITIES_LIST;
    }
}
