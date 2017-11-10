import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MockSecurityService} from './mock.security.service';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [],
  providers : [
    MockSecurityService,
  ]
})
export class MocksModule { }
