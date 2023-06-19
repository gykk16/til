package dev.glory.java14.record;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    void getter_test() throws Exception {
        // given
        String name = "홍길동";
        int age = 20;

        // when
        Person person = new Person(name, age);

        // then
        assertThat(person.name()).isEqualTo(name);
        assertThat(person.age()).isEqualTo(age);
    }

    @Test
    void equals_test() throws Exception {
        // given
        String name = "홍길동";
        int age = 20;

        // when
        Person person1 = new Person(name, age);
        Person person2 = new Person(name, age);
        Person person3 = new Person("홍홍홍", age);

        // then
        assertThat(person1)
                .isEqualTo(person2)
                .isNotEqualTo(person3);
    }

    @Test
    void hashcode_test() throws Exception {
        // given
        String name = "홍길동";
        int age = 20;

        // when
        Person person1 = new Person(name, age);
        Person person2 = new Person(name, age);
        Person person3 = new Person("홍홍홍", age);

        // then
        assertThat(person1)
                .hasSameHashCodeAs(person2)
                .doesNotHaveSameHashCodeAs(person3);
    }

    @Test
    void toString_test() throws Exception {
        // given
        String name = "홍길동";
        int age = 20;

        // when
        Person person = new Person(name, age);

        // then
        System.out.println("==> person = " + person);
        assertThat(person).hasToString("Person[name=" + name + ", age=" + age + "]");
    }

    @Test
    void constructor_validator_test() throws Exception {
        // given

        // when
        assertThatThrownBy(() -> new Person(null, 20))
                // then
                .isInstanceOf(NullPointerException.class);

        // when
        assertThatThrownBy(() -> new Person("name", null))
                // then
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void constructor_default_test() throws Exception {
        // given
        String name = "홍길동";

        // when
        Person person = new Person(name);

        // then
        assertThat(person.name()).isEqualTo(name);
        assertThat(person.age()).isEqualTo(10);
    }

    @Test
    void static_method_test() throws Exception {
        // given
        int age = 20;

        // when
        Person unnamed = Person.unnamed(age);

        // then
        assertThat(unnamed.name()).isEqualTo("Unnamed");
        assertThat(unnamed.age()).isEqualTo(age);
    }
}