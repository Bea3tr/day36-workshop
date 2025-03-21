import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UploadComponent } from './components/upload.component';
import { ViewImageComponent } from './components/view-image.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { MaterialModule } from './material.module';
import { ReactiveFormsModule } from '@angular/forms';
import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { DirectUploadComponent } from './components/direct-upload.component';

@NgModule({
  declarations: [ AppComponent, UploadComponent, ViewImageComponent, DirectUploadComponent ],
  imports: [ BrowserModule, AppRoutingModule, MaterialModule, ReactiveFormsModule ],
  providers: [ provideAnimationsAsync(), provideHttpClient(withInterceptorsFromDi()) ],
  bootstrap: [ AppComponent ]
})
export class AppModule {}