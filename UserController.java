import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@requestMapping("/api/users")
public class UserController {
    private List<User> dataUser = new ArrayList<>();
    
    @PostMapping
    public ResponseEntity<UserRequest> createUser(
            @RequestBody UserRequest request) {
        User user = new User(
            request.getName(),
            request.getEmail(),
            request.getPassword()
        );
        dataUser.add(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(request);
    }

    @postMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        String password = requestBody.get("password");

        // validasi dengan data yang sudah ada
        for (User existingUser : dataUser) {
            if (existingUser.login(email, password)) {
                Map<String, Object> response = new HashMap<>();
                response.put("success", true);
                response.put("message", "Login successful");
                return ResponseEntity.ok(response);
            }
        }   
    }
}
