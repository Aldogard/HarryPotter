import { HpAnimal } from "../interfaces/hp-animal";
import { HpComment } from "../interfaces/hp-comment";
import { HpCondition } from "../interfaces/hp-condition";
import { HpHint } from "../interfaces/hp-hint";
import { HpPotion } from "../interfaces/hp-potion";
import { HpSaw } from "../interfaces/hp-saw";
import { HpSpell } from "../interfaces/hp-spell";

export interface HpMagicalBeing {
    id: number,
    name: string,
    healthPoints: number,
    faktor: number,
    energy: number,
    species: string,
    stunnedProtection: number,
    confundedProtection: number,
    protego: boolean,
    fiendfyre: boolean,
    additionalFactor: number,
    internEnergy: number,
    klasse: string,
    internHealthPoints: number,
    halfLife: boolean,
    ptCounter: number,
    victories: number,
    description: string,
    rank: string,
    conditions: HpCondition[],
    spells: HpSpell[],
    potions: HpPotion[],
    animals: HpAnimal[],
    comments: HpComment[],
    strengthAndWeaknesses: HpSaw[],
    hints: HpHint[],
    rating: number,
    amount: number,
    victoriesChess: number,
    intelligence: number,


}
