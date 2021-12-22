import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SpellsComponent } from './spells/spells.component';
import { BattleComponent } from './battle/battle.component';
import { CreateWizardComponent } from './create-wizard/create-wizard.component';
import { CreditsComponent } from './credits/credits.component';
import { DeleteWizardComponent } from './delete-wizard/delete-wizard.component';
import { DetailsSpellComponent } from './details-spell/details-spell.component';
import { DetailsPotionComponent } from './details-potion/details-potion.component';
import { DetailsComponent } from './details/details.component';
import { FightComponent } from './fight/fight.component';
import { HomeComponent } from './home/home.component';
import { HarrypotterComponent } from './overview/harrypotter.component';
import { PotionsComponent } from './potions/potions.component';
import { RulesComponent } from './rules/rules.component';
import { SearchComponent } from './search/search.component';
import { UpdateWizardComponent } from './update-wizard/update-wizard.component';
import { RanksComponent } from './ranks/ranks.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: 'spelldetail', redirectTo: 'overview', pathMatch: 'full'},
  { path: 'potiondetail', redirectTo: 'overview', pathMatch: 'full'},
  { path: 'overview', component: HarrypotterComponent },
  { path: 'detail', component: DetailsComponent },
  { path: 'delete', component: DeleteWizardComponent },
  { path: 'create', component: CreateWizardComponent },
  { path: 'update', component: UpdateWizardComponent },
  { path: 'fight', component: FightComponent},
  { path: 'credits', component: CreditsComponent},
  { path: 'home', component: HomeComponent},
  { path: 'result', component: SearchComponent},
  { path: 'battle', component: BattleComponent},
  { path: 'spells', component: SpellsComponent},
  { path: 'potions', component: PotionsComponent},
  { path: 'spelldetail/:id', component: DetailsSpellComponent},
  { path: 'potiondetail/:id', component: DetailsPotionComponent},
  { path: 'rules', component: RulesComponent},
  { path: 'ranks', component: RanksComponent},

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }