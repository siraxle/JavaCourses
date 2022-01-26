package ru.java.courses.sport.team.myfootball;

import java.util.Objects;

public class Coach extends Athlete {
  private int experience;
  private String coachName;

  public Coach(String coachName) {
    isEmptyCoachName(coachName);
    this.coachName = coachName;
  }

  public int getExperience() {
    return experience;
  }

  public void setExperience(int experience) {
    this.experience = experience;
  }

  public void setName(String coachName) {
    isEmptyCoachName(coachName);
    this.coachName = coachName;
  }

  public String getName() {
    return this.coachName;
  }

  protected static boolean isEmptyCoachName(String coachName) {
    if (coachName.isEmpty() || coachName.equals("")) {
      throw new IllegalArgumentException("Не может быть тренера без имени");
    }
    return false;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Coach coach = (Coach) o;
    return experience == coach.experience && coachName.equals(coach.coachName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(experience, coachName);
  }
}
