package dev.glory.designpattern.createpattern.singleton;

public class Settings {

    private Settings() {
    }

    // 내부 클래스를 사용하여 클래스 로딩 시점에 인스턴스 생성
    private static class SettingsHolder {
        private static final Settings INSTANCE = new Settings();
    }

    public static Settings getInstance() {
        return SettingsHolder.INSTANCE;
    }
}
