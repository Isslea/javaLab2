package com.example.demokurwa;

public class UserEntity {
    private Long id;
    private String name;

    public UserEntity(Long id, String name){
        this.id = id;
        this.name = name;
    }
     public Long getId(){
        return id;
     }
     public void setId(){
        this.id = id;
     }

     public String getName(){
         return name;
     }
     public void setName(){
         this.name = name;
     }
}
