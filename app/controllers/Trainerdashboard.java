package controllers;

import java.util.List;

import models.Assessment;
import models.Member;
import models.Trainer;
import play.Logger;
import play.mvc.Controller;

public class Trainerdashboard extends Controller {
    public static void index(Long id) {
        Logger.info("Rendering Trainer Dashboard");
        List<Member> memberlists = Member.findAll();
        render("trainerdashboard.html", memberlists);
    }
    public static void memberIndex(Long id) {
        Logger.info("Rendering Trainer view of Member");
        Member member = Member.findById(id);
        List<Assessment> assessmentList = member.assessmentList;
        double bmi = 0;
        String bmiCategory = "Undefined";
        if (assessmentList.size() != 0) {
            bmi = GymUtility.calculateBMI(member, assessmentList.get(0));
        }
        if (assessmentList.size() != 0) {
            bmiCategory = GymUtility.determineBMICategory(bmi);
        }
        render ("trainerview.html", member, assessmentList,bmi,bmiCategory);
    }


}

