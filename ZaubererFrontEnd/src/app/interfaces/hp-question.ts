import { HpAnswer } from "./hp-answer";

export interface HpQuestion {
    id: number,
    question: string,
    answers: HpAnswer[],
}
