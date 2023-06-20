package dev.glory.hibernate.booleanconverters.model;


import static org.assertj.core.api.Assertions.assertThat;

import jakarta.persistence.EntityManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class HibernateBooleanConverterTest {

    @Autowired
    private EntityManager em;

    private String id;

    @BeforeEach
    void setUp() {
        Question question = Question.builder()
                .correctAnswer(true)
                .shouldBeAsked(true)
                .isEasy(true)
                .wasAskedBefore(true)
                .build();

        em.persist(question);
        em.flush();

        this.id = question.getId();
    }

    @AfterEach
    void tearDown() {
        em.createQuery("delete from Question").executeUpdate();
        em.clear();
    }

    @Test
    void yes_no_converter_test() throws Exception {
        // given
        String correctAnswerQuery = "SELECT CORRECT_ANSWER FROM QUESTION WHERE ID = :id";

        // when
        String dbCorrectAnswer = em.createNativeQuery(correctAnswerQuery, String.class)
                .setParameter("id", id)
                .getSingleResult()
                .toString();

        // then
        assertThat(dbCorrectAnswer).isEqualTo("Y");
    }

    @Test
    void true_false_converter_test() throws Exception {
        // given
        String shouldBeAskedQuery = "SELECT SHOULD_BE_ASKED FROM QUESTION WHERE ID = :id";

        // when
        String dbShouldBeAsked = em.createNativeQuery(shouldBeAskedQuery, String.class)
                .setParameter("id", id)
                .getSingleResult()
                .toString();

        // then
        assertThat(dbShouldBeAsked).isEqualTo("T");
    }

    @Test
    void numeric_converter_test() throws Exception {
        // given
        String isEasyQuery = "SELECT IS_EASY FROM QUESTION WHERE ID = :id";

        // when
        String dbIsEasy = em.createNativeQuery(isEasyQuery, String.class)
                .setParameter("id", id)
                .getSingleResult()
                .toString();

        // then
        assertThat(dbIsEasy).isEqualTo("1");
    }
}