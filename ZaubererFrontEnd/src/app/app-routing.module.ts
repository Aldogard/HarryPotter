import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OverviewSpellComponent } from './overview-spell/spells.component';
import { BattleComponent } from './battle/battle.component';
import { CreateWizardComponent } from './create-wizard/create-wizard.component';
import { CreditsComponent } from './credits/credits.component';
import { DeleteWizardComponent } from './delete-wizard/delete-wizard.component';
import { DetailsSpellComponent } from './details-spell/details-spell.component';
import { DetailsPotionComponent } from './details-potion/details-potion.component';
import { DetailsComponent } from './details/details.component';
import { PrologueComponent } from './prologue/prologue.component';
import { HomeComponent } from './home/home.component';
import { HarrypotterComponent } from './overview/harrypotter.component';
import { OverviewPotionComponent } from './overview-potion/potions.component';
import { RulesComponent } from './rules/rules.component';
import { ResultComponent } from './result/result.component';
import { UpdateWizardComponent } from './update-wizard/update-wizard.component';
import { RanksComponent } from './ranks/ranks.component';
import { OverviewAnimalComponent } from './overview-animal/overview-animal.component';
import { DetailsAnimalComponent } from './details-animal/details-animal.component';
import { CompareComponent } from './compare/compare.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: 'spelldetail', redirectTo: 'overview', pathMatch: 'full'},
  { path: 'potiondetail', redirectTo: 'overview', pathMatch: 'full'},
  { path: 'animaldetail', redirectTo: 'overview', pathMatch: 'full'},
  { path: 'overview', component: HarrypotterComponent },
  { path: 'detail', component: DetailsComponent },
  { path: 'delete', component: DeleteWizardComponent },
  { path: 'create', component: CreateWizardComponent },
  { path: 'update', component: UpdateWizardComponent },
  { path: 'prologue', component: PrologueComponent},
  { path: 'credits', component: CreditsComponent},
  { path: 'home', component: HomeComponent},
  { path: 'result', component: ResultComponent},
  { path: 'battle', component: BattleComponent},
  { path: 'spells', component: OverviewSpellComponent},
  { path: 'potions', component: OverviewPotionComponent},
  { path: 'spelldetail/:id', component: DetailsSpellComponent},
  { path: 'potiondetail/:id', component: DetailsPotionComponent},
  { path: 'animaldetail/:id', component: DetailsAnimalComponent},
  { path: 'rules', component: RulesComponent},
  { path: 'ranks', component: RanksComponent},
  { path: 'animals', component: OverviewAnimalComponent},
  { path: 'compare', component: CompareComponent},

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }