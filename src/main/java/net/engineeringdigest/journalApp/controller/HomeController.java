package net.engineeringdigest.journalApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    
    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<String> home() {
        String html = "<!DOCTYPE html>" +
                "<html><head><title>Journal App Documentation</title>" +
                "<style>body{font-family:Arial,sans-serif;margin:40px;background:#f5f5f5}" +
                ".container{max-width:900px;margin:0 auto;background:white;padding:30px;border-radius:8px;box-shadow:0 2px 10px rgba(0,0,0,0.1)}" +
                "h1{color:#333;border-bottom:3px solid #28a745;padding-bottom:10px}" +
                "h2{color:#495057;margin-top:30px}" +
                ".api-section{margin:20px 0;padding:20px;background:#f8f9fa;border-left:4px solid #28a745;border-radius:5px}" +
                ".endpoint{background:#e9ecef;padding:12px;margin:8px 0;border-radius:4px;font-family:monospace;border-left:3px solid #6c757d}" +
                ".method{display:inline-block;padding:4px 8px;border-radius:3px;color:white;font-weight:bold;margin-right:10px}" +
                ".get{background:#28a745}.post{background:#007bff}.put{background:#ffc107;color:#000}.delete{background:#dc3545}" +
                ".auth-required{color:#dc3545;font-size:12px;font-weight:bold}" +
                "code{background:#f1f3f4;padding:2px 4px;border-radius:3px;font-family:monospace}" +
                "</style></head><body>" +
                "<div class='container'>" +
                "<h1>📖 Journal App API Documentation</h1>" +
                "<p>A secure personal journal application with JWT authentication. Manage your journal entries with full CRUD operations.</p>" +
                
                "<div class='api-section'>" +
                "<h2>🔐 Authentication Endpoints</h2>" +
                "<p>Public endpoints for user registration and authentication:</p>" +
                "<div class='endpoint'><span class='method post'>POST</span>/public/signup<br>" +
                "<small>Create a new user account. Body: {\"userName\": \"string\", \"email\": \"string\", \"password\": \"string\"}</small></div>" +
                "<div class='endpoint'><span class='method post'>POST</span>/public/login<br>" +
                "<small>Login and receive JWT token. Body: {\"userName\": \"string\", \"password\": \"string\"}</small></div>" +
                "<div class='endpoint'><span class='method get'>GET</span>/public/health-check<br>" +
                "<small>Public health check endpoint</small></div>" +
                "</div>" +
                
                "<div class='api-section'>" +
                "<h2>📝 Journal Entry Management</h2>" +
                "<p class='auth-required'>⚠️ All endpoints require JWT authentication</p>" +
                "<div class='endpoint'><span class='method get'>GET</span>/journal/v2 <span class='auth-required'>🔒</span><br>" +
                "<small>Get all journal entries for authenticated user</small></div>" +
                "<div class='endpoint'><span class='method post'>POST</span>/journal/v2 <span class='auth-required'>🔒</span><br>" +
                "<small>Create new journal entry. Body: {\"title\": \"string\", \"content\": \"string\"}</small></div>" +
                "<div class='endpoint'><span class='method get'>GET</span>/journal/v2/id/{id} <span class='auth-required'>🔒</span><br>" +
                "<small>Get specific journal entry by ID</small></div>" +
                "<div class='endpoint'><span class='method put'>PUT</span>/journal/v2/id/{id} <span class='auth-required'>🔒</span><br>" +
                "<small>Update journal entry. Body: {\"title\": \"string\", \"content\": \"string\"}</small></div>" +
                "<div class='endpoint'><span class='method delete'>DELETE</span>/journal/v2/id/{id} <span class='auth-required'>🔒</span><br>" +
                "<small>Delete journal entry by ID</small></div>" +
                "</div>" +
                
                "<div class='api-section'>" +
                "<h2>👤 User Management</h2>" +
                "<p class='auth-required'>⚠️ All endpoints require JWT authentication</p>" +
                "<div class='endpoint'><span class='method get'>GET</span>/user <span class='auth-required'>🔒</span><br>" +
                "<small>Get current user profile information</small></div>" +
                "<div class='endpoint'><span class='method put'>PUT</span>/user <span class='auth-required'>🔒</span><br>" +
                "<small>Update user profile</small></div>" +
                "<div class='endpoint'><span class='method delete'>DELETE</span>/user <span class='auth-required'>🔒</span><br>" +
                "<small>Delete user account and all associated data</small></div>" +
                "</div>" +
                
                "<div class='api-section'>" +
                "<h2>🏥 System Health</h2>" +
                "<div class='endpoint'><span class='method get'>GET</span>/health-check<br>" +
                "<small>Check application health status</small></div>" +
                "</div>" +
                
                "<div class='api-section'>" +
                "<h2>🔧 How to Use</h2>" +
                "<p><strong>Step 1:</strong> Create an account using <code>POST /public/signup</code></p>" +
                "<p><strong>Step 2:</strong> Login using <code>POST /public/login</code> to get your JWT token</p>" +
                "<p><strong>Step 3:</strong> Include the token in all authenticated requests:</p>" +
                "<code>Authorization: Bearer YOUR_JWT_TOKEN</code>" +
                "<p><strong>Step 4:</strong> Start managing your journal entries!</p>" +
                "</div>" +
                
                "<div class='api-section'>" +
                "<h2>📋 Example Usage</h2>" +
                "<p><strong>Create Account:</strong></p>" +
                "<code>curl -X POST https://journalapp-stff.onrender.com/public/signup -H \"Content-Type: application/json\" -d '{\"userName\":\"john\",\"email\":\"john@example.com\",\"password\":\"password123\"}'</code>" +
                "<p><strong>Login:</strong></p>" +
                "<code>curl -X POST https://journalapp-stff.onrender.com/public/login -H \"Content-Type: application/json\" -d '{\"userName\":\"john\",\"password\":\"password123\"}'</code>" +
                "</div>" +
                
                "</div></body></html>";
        
        return ResponseEntity.ok().header("Content-Type", "text/html").body(html);
    }
}