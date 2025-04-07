import java.util.Comparator;

// Add another comparator for team names and player names
public class NameCompare implements Comparator<Player> {

        // Compare Player 1 and Player 2
        public int compare(Player player1, Player player2) {

            // Compare team names first
            int teamNameCompare = player1.getTeamName().compareTo(player2.getTeamName());

            // If team names are equal
            if (teamNameCompare == 0) {

                // Compare player names together
                return player1.getPlayerName().compareTo(player2.getPlayerName());
            }
            return teamNameCompare;
        }
    }
