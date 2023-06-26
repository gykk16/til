package dev.glory.path;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DesktopPathTest {

    private static final String DESKTOP_PATH = "C:\\Users\\PC\\Desktop";

    @DisplayName("get_desktop_dir_using_system_property")
    @Test
    void get_desktop_dir_using_system_property() throws Exception {
        // given

        // when
        String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";

        // then
        assertThat(desktopPath).isEqualTo(DESKTOP_PATH);
    }

    @DisplayName("get_desktop_dir_using_file_system_view")
    @Test
    void get_desktop_dir_using_file_system_view() throws Exception {
        // given
        FileSystemView view = FileSystemView.getFileSystemView();

        // when
        File homeDirectory = view.getHomeDirectory();
        String absolutePath = homeDirectory.getAbsolutePath();
        String path = homeDirectory.getPath();

        // then
        assertThat(path).isEqualTo(DESKTOP_PATH);
        System.out.println("==> path = " + path);
        System.out.println("==> absolutePath = " + absolutePath);
    }
}
