import { HpSpell } from "./hp-spell";
import { HpComment } from "./hp-comment";
import { HpCondition } from "./hp-condition";
import { HpPotion } from "./hp-potion";
import { HpAnimal } from "./hp-animal";
import { HpSaw } from "./hp-saw";
import { HpHint } from "./hp-hint";

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
