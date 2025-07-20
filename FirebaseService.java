// File: FirebaseService.java

public class FirebaseService {
    // ... Rest of your code and singleton logic ...

    public boolean signUpWithEmailAndPassword(String email, String password) {
        try {
            URL url = new URL("https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=" + API_KEY);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);

            String payload = String.format(
               "{\"email\":\"%s\",\"password\":\"%s\",\"returnSecureToken\":true}", email, password);

            try(OutputStream os = conn.getOutputStream()) {
                os.write(payload.getBytes(StandardCharsets.UTF_8));
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) return true;

            printFirebaseError(conn);
            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean signInWithEmailAndPassword(String email, String password) {
        try {
            URL url = new URL("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=" + API_KEY);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);

            String payload = String.format(
               "{\"email\":\"%s\",\"password\":\"%s\",\"returnSecureToken\":true}", email, password);

            try(OutputStream os = conn.getOutputStream()) {
                os.write(payload.getBytes(StandardCharsets.UTF_8));
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) return true;

            printFirebaseError(conn);
            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Helper to print error response, you can further improve this to parse JSON and extract "message"
    private void printFirebaseError(HttpURLConnection conn) {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getErrorStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) response.append(line);
            System.out.println("Firebase Auth error response: " + response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
