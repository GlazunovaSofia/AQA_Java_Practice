package user;

import utils.PropertyReader;

public class UserFactory {
    public static User withAdminPermission(){
        return new User(PropertyReader.getProperty("sausedemo.user"),
                PropertyReader.getProperty("sausedemo.password"));
    }

    public static User withLockedPermission(){
        return new User(PropertyReader.getProperty("sausedemo.lockedUser"),
                PropertyReader.getProperty("sausedemo.password"));
    }

    public static User withIncorrectLogin(){
        return new User(PropertyReader.getProperty("sausedemo.incorrectUser"),
                PropertyReader.getProperty("sausedemo.password"));
    }

    public static User withIncorrectPassword(){
        return new User(PropertyReader.getProperty("sausedemo.user"),
                PropertyReader.getProperty("sausedemo.incorrectPassword"));
    }

    public static User withEmptyLogin(){
        return new User("",
                PropertyReader.getProperty("sausedemo.password"));
    }

    public static User withEmptyPassword(){
        return new User(PropertyReader.getProperty("sausedemo.user"),
                "");
    }

    public static User withEmptyLoginAndPassword(){
        return new User("",
                "");
    }

    public static User withLoginWithUpperCase(){
        return new User(PropertyReader.getProperty("sausedemo.userWithUpperCase"),
                PropertyReader.getProperty("sausedemo.password"));
    }
}
