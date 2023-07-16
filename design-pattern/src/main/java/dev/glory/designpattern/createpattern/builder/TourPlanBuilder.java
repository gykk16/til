package dev.glory.designpattern.createpattern.builder;

/*
 * 빌더 패턴
 * 체이닝을 사용하기 위해 Builder 를 리턴하고
 * 최종적으로 build() 메서드를 호출하여 인스턴스를 생성하는 방식
 */
public interface TourPlanBuilder {

    TourPlanBuilder setTitle(String title);

    TourPlanBuilder setDescription(String description);

    TourPlanBuilder setRegion(String region);

    TourPlanBuilder setDuration(String duration);

    TourPlanBuilder setPrice(String price);

    TourPlan build();
}
