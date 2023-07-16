package dev.glory.designpattern.createpattern.builder;

public class DefaultTourBuilder implements TourPlanBuilder {

    private String title;
    private String description;
    private String region;
    private String duration;
    private String price;

    @Override
    public TourPlanBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public TourPlanBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public TourPlanBuilder setRegion(String region) {
        this.region = region;
        return this;
    }

    @Override
    public TourPlanBuilder setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    @Override
    public TourPlanBuilder setPrice(String price) {
        this.price = price;
        return this;
    }

    @Override
    public TourPlan build() {
        return new TourPlan(title, description, region, duration, price);
    }
}
