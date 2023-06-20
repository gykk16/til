package dev.glory.utils.validator;

import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class PasswordValidatorUtil {

    /*
    1. 9자리 이상 (최대 36자)
    2. 영문, 숫자, 특수문자 중 3종류 모두 조합
    3. 연속된 문자 또는 숫자 3개 이상 연속 사용 불가
    4. 기업명 사용 불가 (영문, 한글)
    5. 기타 정의된 문자열 사용 불가
     */

    private PasswordValidatorUtil() {
    }

    private static final Pattern     LENGTH_PATTERN        = Pattern.compile("^.{9,36}$");
    private static final Pattern     THREE_CLASSES_PATTERN = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+=-]).*$");
    private static final Set<String> INVALID_WORDS         = Set.of("password", "qlqjs", "qlalfqjsgh", "qwe", "asd", "zxc", "123", "456", "789");


    /**
     * 비밀번호 유효성 검사
     *
     * @param username 아이디
     * @param password 비밀번호
     * @return 유효성 검사 결과
     */
    public static boolean isValid(String username, String password) {
        String pass = password.strip().toLowerCase();

        if (!LENGTH_PATTERN.matcher(pass).matches()) {
            throw new IllegalArgumentException("9자리 이상 36자리 이하로 입력해주세요.");
        }

        if (!THREE_CLASSES_PATTERN.matcher(pass).matches()) {
            throw new IllegalArgumentException("영문, 숫자, 특수문자 중 3종류 이상을 조합하여 입력해주세요.");
        }

        if (hasThreeConsecutiveSameCharacters(pass)) {
            throw new IllegalArgumentException("연속된 문자 또는 숫자 3개 이상 연속 사용 불가합니다.");
        }

        if (INVALID_WORDS.stream().anyMatch(pass::contains)) {
            throw new IllegalArgumentException("사용 불가능한 문자열이 포함 되었습니다.");
        }

        if (pass.contains(username)) {
            throw new IllegalArgumentException("아이디와 동일한 문자열은 사용 불가합니다.");
        }

        return true;
    }

    /**
     * 연속된 문자 또는 숫자 3개 이상 연속 사용 여부
     *
     * @param str 검사할 문자열
     */
    private static boolean hasThreeConsecutiveSameCharacters(String str) {
        return IntStream.range(0, str.length() - 2)
                .anyMatch(i -> str.charAt(i) == str.charAt(i + 1) && str.charAt(i) == str.charAt(i + 2));
    }
}
