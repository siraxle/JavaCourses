package ru.java.courses.sport.team.myfootball;

import java.util.ArrayList;

public class FootballTeam {
  private ArrayList<FootballPlayer> footballPlayers = new ArrayList<>();
  private String teamName;
  private Coach coach;
  static int score;
  final int MAX_TEAM_SIZE = 20;

  public FootballTeam(String teamName) {
    if (teamName.isEmpty() || teamName.equals("")) {
      throw new IllegalArgumentException("Не может быть тренера без имени");
    }
    this.teamName = teamName;
  }

  public ArrayList<FootballPlayer> getPlayers() {
    return footballPlayers;
  }

  public void setPlayers(ArrayList<FootballPlayer> footballPlayers) {
    this.footballPlayers = footballPlayers;
  }

  public String getName() {
    return this.teamName;
  }

  public void setName(String teamName) {
    if (teamName.isEmpty() || teamName.equals("")) {
      throw new IllegalArgumentException("Не может быть тренера без имени");
    }
    this.teamName = teamName;
  }

  public Coach getCoach() {
    return coach;
  }

  public void setCoach(Coach coach) {
    this.coach = coach;
  }

  public void addPlayer(FootballPlayer footballPlayer) {
    addPlayers(footballPlayer);
  }

  public void addPlayers(FootballPlayer... footballPlayers) {
    if (this.footballPlayers.size() >= 20) {
      throw new IllegalArgumentException("В команде не может быть более 20 игроков");
    }
    for (int i = 0; i < footballPlayers.length; i++) {
      if (this.footballPlayers.size() < 11) {
        footballPlayers[i].isActive = true;
      } else footballPlayers[i].isActive = false;
      this.footballPlayers.add(footballPlayers[i]);
    }
  }

  public void removePlayer(FootballPlayer footballPlayer) {
    for (FootballPlayer fp : this.footballPlayers) {
      if (fp.equals(footballPlayer)) {
        fp.isActive = false;
        fp.isRemoved = true;
        this.footballPlayers.remove(fp);
      }
    }
  }

  public void setScore(int score) {
    FootballTeam.score = score;
  }

  public int getScore() {
    return score;
  }

  public int getPlayersCount() {
    return footballPlayers.size();
  }

  public int getMaxPlayersCount() {
    try {
      if (getPlayersCount() > 20) {
        throw new IllegalArgumentException("Не может быть более " + MAX_TEAM_SIZE + " игроков в команде");
      }
    } catch (IllegalArgumentException ex) {
    }

    return getPlayersCount();
  }

}
