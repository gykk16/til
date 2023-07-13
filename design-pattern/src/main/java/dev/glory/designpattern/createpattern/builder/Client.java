package dev.glory.designpattern.createpattern.builder;

public class Client {

    public static void main(String[] args) {

        DefaultTourBuilder tourBuilder = new DefaultTourBuilder();
        TourPlan tourPlan = tourBuilder.setTitle("title")
                .setDescription("description")
                .setRegion("region")
                .setDuration("duration")
                .setPrice("price")
                .build();


    }

}
