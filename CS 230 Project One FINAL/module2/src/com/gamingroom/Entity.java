package com.gamingroom;
/**
* Entity class
* placeholder
**/

public class Entity {

    // Unique ID

    protected long id;
    
    // Name of entity

    protected String name;

    protected Entity() {};

    //useful constructor

    public Entity(long id, String name) {

        this();
        this.id = id;
        this.name = name;

    }

    // accessors and mutators~~~


    //accessors
    public long getId() {return id;}

    public String getName() {return name;}

    // no mutators ~~~


    //to string method
    public String toString() {

        return "Entity [id=" + id + ", name= " + name + "]";
        
    }


}