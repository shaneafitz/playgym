package controllers;
import models.Assessment;
import models.Member;
import play.db.jpa.Model;

public class GymUtility extends Model {
    public GymUtility() {
    }
    public static double calculateBMI(Member member, Assessment assessment) {
        double currentBMI;
        if (member.assessmentList.size() == 0) {
            currentBMI = Math.round(member.getStartingweight() / ((member.getHeight()/100) * (member.getHeight()/100)));
        } else  {
            currentBMI = Math.round(assessment.getWeight() / ((member.getHeight()/100) * (member.getHeight()/100)));
        }
        return currentBMI;
    }

    public static String determineBMICategory(double bmiCategory) {
        if (bmiCategory < 16) {
            return "SEVERELY UNDERWEIGHT";
        }
        if (bmiCategory >= 16 && bmiCategory < 18.5) {
            return "UNDERWEIGHT";
        }
        if (bmiCategory >= 18.5 && bmiCategory < 25.0) {
            return "NORMAL";
        }
        if (bmiCategory >= 25.0 && bmiCategory < 30.0) {
            return "OVERWEIGHT";
        }
        if (bmiCategory >= 30.0 && bmiCategory < 35.0) {
            return "MODERATELY OBESE";
        }
        if (bmiCategory >= 35.0) {
            return "SEVERELY OBESE";
        }
        return null;
    }

}