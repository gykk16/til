package dev.glory.utils.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordValidatorUtilTest {

    private final String username = "testuser";

    @Test
    void valid_password() {
        // given
        String pass1 = "manager1!@#";
        String pass2 = "mynewrandom!@#$0";

        // when
        boolean valid1 = PasswordValidatorUtil.isValid(username, pass1);
        boolean valid2 = PasswordValidatorUtil.isValid(username, pass2);

        // then
        assertThat(valid1).isTrue();
        assertThat(valid2).isTrue();
    }

    @Test
    void short_long_password() throws Exception {
        // given
        String shortPass = "manage#1";
        String longPass = "manag13579!#%&(manag13579!#%&(manag13579!#%&(manag13579!#%&(";

        // when
        assertThatThrownBy(() -> PasswordValidatorUtil.isValid(username, shortPass))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("9자리 이상 36자리 이하로 입력해주세요.");

        // when
        assertThatThrownBy(() -> PasswordValidatorUtil.isValid(username, longPass))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("9자리 이상 36자리 이하로 입력해주세요.");
    }

    @Test
    void no_three_class_password() throws Exception {
        // given
        String pass1 = "manager14690";
        String pass2 = "manager!#$%^&*";

        // when
        assertThatThrownBy(() -> PasswordValidatorUtil.isValid(username, pass1))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("영문, 숫자, 특수문자 중 3종류 이상을 조합하여 입력해주세요.");

        // when
        assertThatThrownBy(() -> PasswordValidatorUtil.isValid(username, pass2))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("영문, 숫자, 특수문자 중 3종류 이상을 조합하여 입력해주세요.");
    }

    @Test
    void three_consecutive_char_password() throws Exception {
        // given
        String pass1 = "manager!111";
        String pass2 = "alphaqqq#109";

        // when
        assertThatThrownBy(() -> PasswordValidatorUtil.isValid(username, pass1))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연속된 문자 또는 숫자 3개 이상 연속 사용 불가합니다.");

        // when
        assertThatThrownBy(() -> PasswordValidatorUtil.isValid(username, pass2))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연속된 문자 또는 숫자 3개 이상 연속 사용 불가합니다.");
    }

    @Test
    void invalid_word_password() throws Exception {
        // given
        String pass1 = "password3!@#";
        String pass2 = "qlqjs!@#96";
        String pass3 = "qwerty14$$man";

        // when
        assertThatThrownBy(() -> PasswordValidatorUtil.isValid(username, pass1))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사용 불가능한 문자열이 포함 되었습니다.");

        // when
        assertThatThrownBy(() -> PasswordValidatorUtil.isValid(username, pass2))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사용 불가능한 문자열이 포함 되었습니다.");

        // when
        assertThatThrownBy(() -> PasswordValidatorUtil.isValid(username, pass3))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사용 불가능한 문자열이 포함 되었습니다.");
    }

    @Test
    void contain_username_password() throws Exception {
        // given
        String password = "alaska!@#1" + username;

        // when
        assertThatThrownBy(() -> PasswordValidatorUtil.isValid(username, password))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("아이디와 동일한 문자열은 사용 불가합니다.");
    }

}