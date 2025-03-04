import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { UploadResult } from '../model/upload-result';
import { lastValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FileuploadService {

  constructor(private httpClient: HttpClient) { }

  upload(form: any, image: Blob){
    const formData = new FormData();
    formData.set('comments', form['comments']);
    formData.set('file', image);
    return lastValueFrom(this.httpClient.post<UploadResult>('/api/post', formData));
  }

  getImage(postId: string){
    return lastValueFrom(this.httpClient.get<UploadResult>(`/api/get-image/${postId}`));
  }

}
