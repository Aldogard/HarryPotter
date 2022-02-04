import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OverviewSpellComponent } from './overview-spell/spells.component';
import { BattleComponent } from './battle/battle.component';
import { CreateComponent } from './create/create.component';
import { CreditsComponent } from './credits/credits.component';
import { DeleteComponent } from './delete/delete.component';
import { DetailsSpellComponent } from './details-spell/details-spell.component';
import { DetailsPotionComponent } from './details-potion/details-potion.component';
import { DetailsComponent } from './details/details.component';
import { PrologueComponent } from './prologue/prologue.component';
import { HomeComponent } from './home/home.component';
import { OverviewComponent } from './overview/overview.component';
import { OverviewPotionComponent } from './overview-potion/potions.component';
import { RulesComponent } from './rules/rules.component';
import { ResultComponent } from './result/result.component';
import { UpdateComponent } from './update/update.component';
import { RanksComponent } from './ranks/ranks.component';
import { OverviewAnimalComponent } from './overview-animal/overview-animal.component';
import { DetailsAnimalComponent } from './details-animal/details-animal.component';
import { CompareComponent } from './compare/compare.component';
import { ChessComponent } from './chess/chess.component';
import { TrainingComponent } from './training/training.component';
import { PreparationComponent } from './preparation/preparation.component';
import { InformationComponent } from './information/information.component';
import { SelectionComponent } from './selection/selection.component';
import { DetailsMeleeComponent } from './details-melee/details-melee.component';
import { OverviewMeleeComponent } from './overview-melee/overview-melee.component';
import { WarmupComponent } from './warmup/warmup.component';
import { QuizComponent } from './quiz/quiz.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'spelldetail', redirectTo: 'overview', pathMatch: 'full' },
  { path: 'potiondetail', redirectTo: 'overview', pathMatch: 'full' },
  { path: 'animaldetail', redirectTo: 'overview', pathMatch: 'full' },
  { path: 'meleedetail', redirectTo: 'overview', pathMatch: 'full' },
  { path: 'overview', component: OverviewComponent },
  { path: 'detail', component: DetailsComponent },
  { path: 'delete', component: DeleteComponent },
  { path: 'create', component: CreateComponent },
  { path: 'update', component: UpdateComponent },
  { path: 'prologue', component: PrologueComponent },
  // { path: 'credits', component: CreditsComponent},
  { path: 'home', component: HomeComponent },
  { path: 'result', component: ResultComponent },
  { path: 'battle', component: BattleComponent },
  { path: 'spells', component: OverviewSpellComponent },
  { path: 'potions', component: OverviewPotionComponent },
  { path: 'spelldetail/:id', component: DetailsSpellComponent },
  { path: 'potiondetail/:id', component: DetailsPotionComponent },
  { path: 'animaldetail/:id', component: DetailsAnimalComponent },
  { path: 'meleedetail/:id', component: DetailsMeleeComponent },
  { path: 'rules', component: RulesComponent },
  { path: 'ranks', component: RanksComponent },
  { path: 'animals', component: OverviewAnimalComponent },
  { path: 'melees', component: OverviewMeleeComponent },
  { path: 'compare', component: CompareComponent },
  { path: 'chess', component: ChessComponent },
  { path: 'training', component: TrainingComponent },
  { path: 'preparation', component: PreparationComponent },
  { path: 'information', component: InformationComponent },
  { path: 'selection', component: SelectionComponent },
  { path: 'warmup', component: WarmupComponent },
  { path: 'quiz', component: QuizComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
