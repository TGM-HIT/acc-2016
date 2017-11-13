/**
 * @author Markus Reichl
 * @version 07.11.12016
 */

public class GetSet {
    public static void main(String[] args) {
        User u = new User("peter", "password");
        int checks = 0;

        if (!u.setPassword("")) checks++;
        if (!u.setPassword("0")) checks++;
        if (!u.setPassword("abcdefgh")) checks++;
        if (!u.setPassword("ABCDEFGH")) checks++;
        if (!u.setPassword("password")) checks++;
        if (u.setPassword("abcdEFGH")) checks++;

        if (!u.setUsername("")) checks++;
        if (!u.setUsername("0")) checks++;
        if (!u.setUsername("peter")) checks++;
        if (u.setUsername("hannes")) checks++;

        System.out.println(checks + " / 10");
    }
}
