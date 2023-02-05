import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> { // public class '<T>' indicates that the class will
    // accept a type parameter. without the 'extends player' in the type angle brackets, this will accept any object
    // type which is bad because we don't want to be able oe add strings and such onto our teams
    //The 'implements Comparable' is implementing an inbuilt Java interface with a method 'compareTo' which we must
    // override. Indicating 'Comparable<Team<T>>' states that we can only compare teams of the same type
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;


    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {
        if (members.contains(player)) {
            System.out.println(player.getName() + " is already on this team");
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " picked for team " + this.name);
            return true;
        }
    } // accepts only correct type as defined when constructing a team object

    public int numPlayers() {
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore) { // T indicates here that you can only
        // compare score of same Team subclass type.

        String message;

        if(ourScore > theirScore) {
            won++;
            message = " beat ";
        } else if(ourScore == theirScore) {
            tied++;
            message = " drew with ";

        } else {
            lost++;
            message = " lost to ";
        }
        played++;
        if(opponent != null) {
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore); // I believe this is recursion since it calls
            // the same method its in but gives the opponent perspective of scoring
        }
    }

    public int ranking() {
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if(this.ranking() > team.ranking()) {
            return -1;
        } else if(this.ranking() < team.ranking()) {
            return 1;
        } else {
            return 0;
        }
    }
}
