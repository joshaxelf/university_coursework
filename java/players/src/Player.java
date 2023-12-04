import java.util.Comparator;

// Create a class called Player, representing player with name, team and score
public class Player implements Comparable<Player> {

    // Use private variables as part of encapsulation
    private String playerName;
    private String teamName;
    private int playerScore;

    // Getter methods to get player details
    public String getPlayerName() {
        return playerName;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    // Setter methods to update our Player obj details
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    // Comparator interface to sort Players using compareTo
    public int compareTo(Player otherPlayer) {

        // Compare to other players based on score from high to low
        return Integer.compare(otherPlayer.getPlayerScore(), this.playerScore);
    }

}