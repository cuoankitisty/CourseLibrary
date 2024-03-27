package com.pluralsight.courseinfo.cli;

import com.pluralsight.courseinfo.cli.service.CourseRetrievalService;
import com.pluralsight.courseinfo.cli.service.PluralsightCourse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CourseRetriever {

    private static final Logger LOG = LoggerFactory.getLogger(CourseRetriever.class);

    public static void main(String[] args) {
        LOG.info("Course Retriever Started");

        if(args.length==0){
            LOG.warn("Please provide an author name as first argument.");
        }

        //top-level try/catch block
        try{
            retrieveCourses(args[0]);
        }catch (Exception e){
            LOG.error("Unexpected error" ,e);
            System.out.println("Unexpected error");
        }
    }

    private static void retrieveCourses(String authorId) {
        LOG.info("Retrieving courses for author '{}'" ,authorId);
        CourseRetrievalService courseRetrievalService = new CourseRetrievalService();

        String coursesToStore = courseRetrievalService.getCoursesFor("sander-mak");
        LOG.info("Retrieved the following courses {}" , coursesToStore);
    }
}
