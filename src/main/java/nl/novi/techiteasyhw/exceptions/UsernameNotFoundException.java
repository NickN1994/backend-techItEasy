package nl.novi.techiteasyhw.exceptions;

public class UsernameNotFoundException {

    private static final long serialVersionUID = 1L;

    public UsernameNotFoundException(String username) {
        super("Cannot find user " + username);
    }

}
