package dev.glory.designpattern.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Constructor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SettingsTest {

    @DisplayName("싱글톤 테스트")
    @Test
    void singleton_test() throws Exception {
        // given
        Settings instance1 = Settings.getInstance();
        Settings instance2 = Settings.getInstance();

        // when


        // then
        assertThat(instance1).isEqualTo(instance2);
    }

    @DisplayName("Reflection 을 활용한 실글톤 깨기")
    @Test
    void broke_singleton() throws Exception {
        // given
        Settings instance1 = Settings.getInstance();

        // when
        Constructor<Settings> constructor = Settings.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Settings instance2 = constructor.newInstance();

        // then
        assertThat(instance1).isNotEqualTo(instance2);
    }



}