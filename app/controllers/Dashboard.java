package controllers;

import models.Assessment;
import play.Logger;
import play.mvc.Controller;

import java.util.List;

import models.Member;


public class Dashboard extends Controller {

    public static void addAssessment(float weight, float chest, float thigh, float upperArm, float waist, float hips) {
        Member member = Accounts.getLoggedInMember();
        Assessment assessment = new Assessment(weight, chest, thigh, upperArm, waist, hips);
        member.assessmentList.add(0,assessment);
        member.save();
        Logger.info("Adding Assessment");
        redirect("/dashboard");
    }

    public static void index() {
        Logger.info("Rendering Dashboard");
        Member member = Accounts.getLoggedInMember();
        List<Assessment> assessmentList = member.assessmentList;
        double bmi = 0;
        String bmiCategory = "Undefined";
        if (assessmentList.size() != 0) {
            bmi = GymUtility.calculateBMI(member, assessmentList.get(0));
        }
        if (assessmentList.size() != 0) {
            bmiCategory = GymUtility.determineBMICategory(bmi);
        }
        render("dashboard.html", member, assessmentList, bmi, bmiCategory);
    }

}
