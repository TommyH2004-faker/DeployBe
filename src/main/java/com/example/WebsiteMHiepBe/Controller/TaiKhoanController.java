package com.example.WebsiteMHiepBe.Controller;


import com.example.WebsiteMHiepBe.entity.User;

import com.example.WebsiteMHiepBe.security.JwtRespone;
import com.example.WebsiteMHiepBe.security.LoginRequest;
import com.example.WebsiteMHiepBe.service.JWT.JwtService;
import com.example.WebsiteMHiepBe.service.user.UserServiceImpl;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@RequestMapping("/taikhoan")
public class TaiKhoanController {
    @Autowired
    private UserServiceImpl userServiceImp;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
     @GetMapping("/get-all-users")
    public ResponseEntity<?> getAllUser() {
        return userServiceImp.getAllUser();
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated @RequestBody User user) throws MessagingException {
        return userServiceImp.register(user);
    }

    @GetMapping("/active-account")
    public ResponseEntity<?> activeAccount(@RequestParam String email, @RequestParam String activationCode) {
        return userServiceImp.kichHoatTaiKhoan(email, activationCode);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate (@RequestBody LoginRequest loginRequest) {
        // Xử lý xác thực người dùng
        try{
            // authentication sẽ giúp ta lấy dữ liệu từ db để kiểm tra
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
            // Nếu xác thực thành công
            if (authentication.isAuthenticated()) {
                // Tạo token cho người dùng
                final String jwtToken = jwtService.generateToken(loginRequest.getUsername());
                return ResponseEntity.ok(new JwtRespone(jwtToken));
            }
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().body("Tên đăng nhập hoặc mật khẩu không đúng!");
        }
        return ResponseEntity.badRequest().body("Xác thực không thành công");
    }

    @PutMapping(path = "/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody JsonNode jsonNode) {
        try{
            return userServiceImp.forgotPassword(jsonNode);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody JsonNode jsonData) {
        System.out.println(jsonData);
        try{
            return userServiceImp.changePassword(jsonData);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/change-avatar")
    public ResponseEntity<?> changeAvatar(@RequestBody JsonNode jsonData) {
        try{
            return userServiceImp.changeAvatar(jsonData);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update-profile")
    public ResponseEntity<?> updateProfile(@RequestBody JsonNode jsonData) {
        try{
            return userServiceImp.updateProfile(jsonData);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(path = "/add-user")
    public ResponseEntity<?> save (@RequestBody JsonNode jsonData) {
        try{
            System.out.println("Du lieu nhan duoc la : "+jsonData.toString());
            return userServiceImp.save(jsonData, "add");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(path = "/update-user")
    public ResponseEntity<?> update(@RequestBody JsonNode jsonData) {
        try{
            return userServiceImp.save(jsonData, "update");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(path = "/delete-user/{idUser}")
    public ResponseEntity<?> delete(@PathVariable int idUser) {
        try{
            return userServiceImp.delete(idUser);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
