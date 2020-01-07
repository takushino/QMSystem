export class Question {
    constructor(
        public QUESTION_ID = 0,
        public question = '',
        public correct = '',
        public wrong1 = '',
        public wrong2 = '',
        public wrong3 = '',
        public explanation = '',
        public userid = 0
    ) { }
}
