
# Best practices

With great power comes great responsibility

Remember what optionals were designed to solve -> littering your code with null checks!

1) DO NOT USE `.get()`, use the alternative which is recommended by the creators themselves! `.orElseThrow()`, dangerous to call without `ifPresent()` check as will throw an exception, using `.orElseThrow` will at least tell the user it will throw an exception if not present.
2) Do not use Optionals as method parameters, use as return types instead

```
Instead of the below: 

public void getUser(long uid,Optional<Type> userType);

use Overload:

public void getUser(long uid) {
    getUser(uid,null);
}
public void getUser(long uid,UserType userType) {
    //doing something
}
```


3) Do not use in POJO properties -> causes problems in serialization to JSON and other types
```

public class User {
    private int age;
    private String name;
    private Optional<String> address;      <---- DO NOT DO THIS
}
```
4) Do not use for your dependencies -> you want your app to crash if the dependency is null as you have a problem! The below will never crash.

```

public class CommonService {
    private Optional<UserService> userService; <----- DO NOT DO THIS
    
    public User getUser(String name) {
        return userService.ifPresent(u -> u.findByName(name));
    }
}
```
5. Do not use `Optional.ofNullable(null)` instead use the in built `Optional.empty()`, safe guarding against null 


More examples (above was taken from this page as well): https://www.javai.net/post/202209/optional-use/ 