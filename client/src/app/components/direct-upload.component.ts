import { Component, ElementRef, OnInit, ResourceStreamItem, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { FileuploadService } from '../services/fileupload.service';

@Component({
  selector: 'app-upload',
  standalone: false,
  templateUrl: './direct-upload.component.html',
  styleUrl: './direct-upload.component.css'
})
export class DirectUploadComponent implements OnInit {

  @ViewChild('file') 
  imageFile!: ElementRef

  form!: FormGroup;

  constructor(private router:Router, private fb:FormBuilder, private fileuploadService:FileuploadService) {}

  ngOnInit(): void {
    this.createForm();
  }

  upload(){
    console.info('Uploading file...')
    const formData = new FormData()
    formData.set('comments', this.form.value['comments']);
    console.info('File:', this.imageFile.nativeElement.files[0])
    if(this.imageFile.nativeElement.files[0]){
      formData.set('file', this.imageFile.nativeElement.files[0]);
    } else {
      formData.set('file', new Blob(), '');
    }
    
    formData.set('file', this.imageFile.nativeElement.files[0]);
    this.fileuploadService.directUpload(formData)
  }

  createForm(){
    this.form = this.fb.group({
      comments: this.fb.control<string>('')
    });
  }
}
