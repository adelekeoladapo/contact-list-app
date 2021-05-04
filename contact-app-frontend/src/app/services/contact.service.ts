import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ContactListResponse} from '../dto/ContactListResponse';
import {environment} from '../../environments/environment';
import {ListRequest} from '../dto/ListRequest';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  baseUrl: string = environment.baseUrl + 'api/v1/contacts';

  constructor(private http: HttpClient) { }

  public getContactList(listRequest: ListRequest): Observable<ContactListResponse> {
      const params = new HttpParams()
        .set('page', listRequest.page + '')
        .set('limit', listRequest.limit + '')
        .set('sort-field', listRequest.sortField)
        .set('sort-order', listRequest.sortOrder)
        .set('filter', listRequest.filter);
      return this.http.get<ContactListResponse>(this.baseUrl, {params});
  }

}
