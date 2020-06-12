import java.util.ArrayList;
import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public boolean function (User user, List<String> allUsers) {
        if (user!=null) { //1
            if (user.getUsername()!=null && user.getEmail()!=null && !allUsers.contains(user.getUsername())) {//2
                boolean atChar = false, dotChar = false;//3
                for (int i=0;i<user.getEmail().length();i++) {//4.1, 4.2, 4.3
                    if (user.getEmail().charAt(i)=='@')//5
                        atChar = true;//6
                    if (atChar && user.getEmail().charAt(i)=='.') {//7
                        dotChar = true;//8
                    }
                }
                if (atChar && dotChar) {//9
                    return true;//10
                }
            }
        }
        return false;//11
    }
}

