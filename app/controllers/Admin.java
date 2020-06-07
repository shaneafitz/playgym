package controllers;

import java.util.List;

import models.Assessment;
import play.mvc.Controller;

public class Admin extends Controller
{
    public static void index() {
        List<Assessment> assessments = Assessment.findAll();
        render ("admin.html", assessments);
    }
}