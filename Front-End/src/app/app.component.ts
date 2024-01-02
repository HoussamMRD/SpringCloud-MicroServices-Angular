// app.component.ts

import { Component } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private router: Router, private activatedRoute: ActivatedRoute) {}

  showNavbarAndSidebar(): boolean {
    // Check if the current route is the login page
    return !this.router.url.includes('/login');
  }
}
