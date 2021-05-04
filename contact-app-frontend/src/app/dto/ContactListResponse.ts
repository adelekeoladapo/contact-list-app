import {Contact} from './Contact';

export class ContactListResponse {
    page: number;
    limit: number;
    total: number;
    data: Contact[];
}

