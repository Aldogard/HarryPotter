import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { HarrypotterComponent } from './overview/harrypotter.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { DetailsComponent } from './details/details.component';
import { DeleteWizardComponent } from './delete-wizard/delete-wizard.component';
import { UpdateWizardComponent } from './update-wizard/update-wizard.component';
import { CreateWizardComponent } from './create-wizard/create-wizard.component';
import { PrologueComponent } from './prologue/prologue.component';
import { CreditsComponent } from './credits/credits.component';
import { HomeComponent } from './home/home.component';
import { SearchComponent } from './search/search.component';
import { SearchConnectionComponent } from './search-connection/search-connection.component';
import { BattleComponent } from './battle/battle.component';
import { OverviewSpellComponent } from './overview-spell/spells.component';
import { OverviewPotionComponent } from './overview-potion/potions.component';
import { DetailsPotionComponent } from './details-potion/details-potion.component';
import { DetailsSpellComponent } from './details-spell/details-spell.component';
import { RulesComponent } from './rules/rules.component';
import { RanksComponent } from './ranks/ranks.component';
import { DetailsAnimalComponent } from './details-animal/details-animal.component';
import { OverviewAnimalComponent } from './overview-animal/overview-animal.component';

@NgModule({
  declarations: [
    AppComponent,
    HarrypotterComponent,
    DetailsComponent,
    DeleteWizardComponent,
    UpdateWizardComponent,
    CreateWizardComponent,
    PrologueComponent,
    CreditsComponent,
    HomeComponent,
    SearchComponent,
    SearchConnectionComponent,
    BattleComponent,
    OverviewSpellComponent,
    OverviewPotionComponent,
    DetailsPotionComponent,
    DetailsSpellComponent,
    RulesComponent,
    RanksComponent,
    DetailsAnimalComponent,
    OverviewAnimalComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    AppRoutingModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
