package com.quid.designPattern.builder;

import com.quid.designPattern.builder.TourPlan.DefaultTourPlanBuilder;
import com.quid.designPattern.builder.TourPlan.TourPlan;
import org.junit.jupiter.api.Test;

public class App {


    @Test
    public void builder() {
        TourDirector tourDirector = new DefaultTourDirector(new DefaultTourPlanBuilder());

        TourPlan tourPlan = tourDirector.myTrip();
        TourPlan busanTour = tourDirector.busanTrip();

        System.out.println(tourPlan);
        System.out.println(busanTour);
    }
}
