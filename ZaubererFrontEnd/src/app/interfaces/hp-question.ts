import { Answer } from "./hp-answer";

export interface Question {
    id: number,
    question: string,
    answers: Answer[],
}
