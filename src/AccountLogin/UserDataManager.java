package AccountLogin;

import java.io.File;

public class UserDataManager {
    // Create or return an existing file
    public static File createFile() {
        File file = new File("user.txt");
        if (file.exists()) {
            System.exit(0);
        }
        return file;
    }
}
