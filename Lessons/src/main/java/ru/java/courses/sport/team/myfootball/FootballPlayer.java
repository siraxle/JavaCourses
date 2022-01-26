package ru.java.courses.sport.team.myfootball;

import java.util.Objects;

public class FootballPlayer extends Athlete {
  private String name;
  private int goals;
  private PlayerRole role;
  boolean isActive;
  boolean isRemoved = false;

  public FootballPlayer(String playerName, PlayerRole playerRole) {
    isEmptyName(playerName);
    isEmptyRole(playerRole);
    this.name = playerName;
    this.role = playerRole;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    isEmptyName(name);
    this.name = name;
  }

  public int getGoals() {
    return goals;
  }

  public void setGoals(int goals) {
    this.goals = goals;
  }

  public PlayerRole getRole() {
    return role;
  }

  public void setRole(PlayerRole role) {
    if (role == null) {
      throw new IllegalArgumentException("Не может быть игрока без роли");
    }
    this.role = role;
  }

  public void score() {
    try {
      if (isActive && !isRemoved) {
        goals++;
        FootballTeam.score++;
      } else throw new IllegalArgumentException("Игрок в запасе и игрок вне игры не может забивать голы");
    } catch (IllegalArgumentException exception) {
    }
  }

  public void setActive(boolean isActive) {
    this.isActive = isActive;
  }

  protected static boolean isEmptyName(String playerName) {
    if (playerName.isEmpty() || playerName.equals("")) {
      throw new IllegalArgumentException("Не может быть игрока без имени");
    }
    return false;
  }

  protected static boolean isEmptyRole(PlayerRole playerRole) {
    if (playerRole == null || playerRole.equals("")) {
      throw new IllegalArgumentException("Не может быть игрока без роли");
    }
    return false;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    FootballPlayer that = (FootballPlayer) o;
    return goals == that.goals && isActive == that.isActive && isRemoved == that.isRemoved && name.equals(that.name) && role == that.role;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, goals, role, isActive, isRemoved);
  }
}
