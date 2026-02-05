package functionalinterface;

//Marker interface (no methods)
interface BackupSerializable {
}


class UserData implements BackupSerializable {

    private String username;
    private String email;

    public UserData(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String toString() {
        return "UserData [username=" + username + ", email=" + email + "]";
    }
}


class SessionData {

    private String sessionId;

    public SessionData(String sessionId) {
        this.sessionId = sessionId;
    }

    public String toString() {
        return "SessionData [sessionId=" + sessionId + "]";
    }
}


class BackupService {

    public static void backup(Object obj) {

        if (obj instanceof BackupSerializable) {
            System.out.println("Backing up object: " + obj);
        } else {
            System.out.println("Backup not allowed for: " + obj);
        }
    }
}


public class BackupSystem {

    public static void main(String[] args) {

        UserData user = new UserData("aditya", "aditya@example.com");
        SessionData session = new SessionData("SESSION123");

        BackupService.backup(user);
        BackupService.backup(session);
    }
}

