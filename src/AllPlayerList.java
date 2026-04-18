import java.util.ArrayList;

public class AllPlayerList<E extends Player> {
    private ArrayList<E> players = new ArrayList<>();

    public void setPlayersList() {
        ArrayList<E> strikers = (ArrayList<E>) Striker.getStrikers();
        players.addAll(strikers);
        ArrayList<E> midfielders = (ArrayList<E>) Midfielder.getMidfielders();
        players.addAll(midfielders);
        ArrayList<E> defenders = (ArrayList<E>) Defender.getDefenders();
        players.addAll(defenders);
        ArrayList<E> goalkeepers = (ArrayList<E>) Goalkeeper.getGoalkeepers();
        players.addAll(goalkeepers);
    }

    public ArrayList<E> getPlayersList(){
        return players;
    }
}
