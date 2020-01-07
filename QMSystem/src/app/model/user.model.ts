export class User {

    constructor(
        public username = '',
        public password = '',
        // tslint:disable-next-line: variable-name
        public user_role = 0,
        // tslint:disable-next-line: variable-name
        public user_id = 0
        ) { }
}