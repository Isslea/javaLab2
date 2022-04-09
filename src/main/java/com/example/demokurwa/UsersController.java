package com.example.demokurwa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UsersController {
    //http://localhost:8080/users?pageSize=20&pageNumber=1
    /*@RequestMapping("/users")
    @ResponseBody
    public Object getUsers (@RequestParam Integer pageNumber, @RequestParam Integer pageSize)
    {
        return pageNumber + " " + pageSize;
    }
    //http://localhost:8080/users?pageSize=20&pageNumber=1
    @RequestMapping("/users")
    @ResponseBody
    public Object getUsers (@RequestParam Integer pageNumber, @RequestParam Integer pageSize)
    {
        List<UserEntity> users = new ArrayList<>();

        users.add(new UserEntity(1L, "John"));
        users.add(new UserEntity(2L, "Matt"));
        users.add(new UserEntity(3L, "Chris"));

        return users;
    }*/
    private Map<Integer, UserEntity> userEntityMap = new HashMap<>(){{
        put(1,new UserEntity(1L,"John"));
        put(2,new UserEntity(2L,"Matt"));
        put(3,new UserEntity(3L,"Chris"));
    }};

    //http://localhost:8080/users
    @RequestMapping("/users")
    @ResponseBody
    public Object allUsers() {return userEntityMap;}

    //http://localhost:8080/users/3/get
    @RequestMapping("/users/{id}/get")
    @ResponseBody
    public Object takeUser(@PathVariable int id)
    {
        return userEntityMap.get(id);
    }

    //http://localhost:8080/user/add?id=4&name=Klaudia
    @RequestMapping("/user/add")
    @ResponseBody
    public Object addUser(@RequestParam Long id, @RequestParam String name)
    {
        int showId = userEntityMap.size() + 1;
        userEntityMap.put(showId,new UserEntity(id,name));
        return userEntityMap.get(showId);
    }

    //http://localhost:8080/users/3/remove
    @RequestMapping("/users/{id}/remove")
    @ResponseBody
    public Object removeUser(@PathVariable int id)
    {
        return userEntityMap.remove(id);
    }
}
