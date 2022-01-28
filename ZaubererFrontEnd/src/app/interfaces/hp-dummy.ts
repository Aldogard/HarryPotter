import { HpAnimal } from "./hp-animal";
import { HpComment } from "./hp-comment";
import { HpCondition } from "./hp-condition";
import { HpHint } from "./hp-hint";
import { HpMelee } from "./hp-melee";
import { HpPotion } from "./hp-potion";
import { HpSaw } from "./hp-saw";
import { HpSpell } from "./hp-spell";

export interface HpDummy {
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
    melees: HpMelee[],
    hints: HpHint[],
    rating: number,
    amount: number,
    victoriesChess: number,
    intelligence: number,
}
