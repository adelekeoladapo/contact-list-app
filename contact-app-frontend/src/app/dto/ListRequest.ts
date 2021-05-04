export class ListRequest {
    page: number;
    limit: number;
    sortField: string;
    sortOrder: string;
    filter: string;

    constructor(page: number, limit: number, sortField: string, sortOrder: string, filter: string) {
        this.page = page;
        this.limit = limit;
        this.sortField = sortField;
        this.sortOrder = sortOrder;
        this.filter = filter;
    }


}
