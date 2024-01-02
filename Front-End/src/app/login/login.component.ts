// login.component.ts

import { Component } from '@angular/core';
import { Router } from '@angular/router'; // Import Router

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = 'admin';
  password: string = 'admin';

  constructor(private router: Router) {} // Inject Router in the constructor

  login() {
    const validUsername = 'admin';
    const validPassword = 'admin';

    if (this.username === validUsername && this.password === validPassword) {
      alert('Login successful!');
      this.router.navigate(['/products']); // Navigate to the 'products' route
    } else {
      alert('Invalid credentials. Please try again.');
    }
  }
}
