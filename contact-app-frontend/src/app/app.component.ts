import {Component, OnInit} from '@angular/core';
import {ContactService} from './services/contact.service';
import {Contact} from './dto/Contact';
import {ListRequest} from './dto/ListRequest';
import {ContactListResponse} from './dto/ContactListResponse';
import {DomSanitizer} from '@angular/platform-browser';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
    contactList: Contact[];
    listRequest: ListRequest;
    listResponse: ContactListResponse;
    n = 1;

    constructor(public contactService: ContactService, public domainSanitizer: DomSanitizer) {
       this.listRequest = new ListRequest(1, 5, 'name', 'ASC', '');
    }

    ngOnInit(): void {
      this.initContactList(this.listRequest);
    }

    initContactList(listRequest: ListRequest): void {
        this.contactService.getContactList(listRequest).subscribe(data => {
            this.listResponse = data;
        });
    }

    goNext(): void {
        this.listRequest.page++;
        this.initContactList(this.listRequest);
    }

    goPrevious(): void {
        this.listRequest.page--;
        this.initContactList(this.listRequest);
    }

    getTotalNumberOfPages(): number {
        return Math.ceil(this.listResponse?.total / this.listResponse?.limit);
    }



}
