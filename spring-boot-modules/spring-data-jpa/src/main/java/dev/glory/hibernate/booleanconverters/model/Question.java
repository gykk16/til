package dev.glory.hibernate.booleanconverters.model;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.type.NumericBooleanConverter;
import org.hibernate.type.TrueFalseConverter;
import org.hibernate.type.YesNoConverter;

/**
 * <a href="https://www.baeldung.com/java-hibernate-6-boolean-converters">Boolean Converters in Hibernate 6</a>
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    /**
     * Mapping Y and N
     */
    @Convert(converter = YesNoConverter.class)
    private Boolean correctAnswer;

    /**
     * Mapping T and F
     */
    @Convert(converter = TrueFalseConverter.class)
    private Boolean shouldBeAsked;

    /**
     * Mapping 0 and 1
     */
    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isEasy;

    private Boolean wasAskedBefore;


    @Builder
    public Question(Boolean correctAnswer, Boolean shouldBeAsked, Boolean isEasy, Boolean wasAskedBefore) {
        this.correctAnswer = correctAnswer;
        this.shouldBeAsked = shouldBeAsked;
        this.isEasy = isEasy;
        this.wasAskedBefore = wasAskedBefore;
    }
}
