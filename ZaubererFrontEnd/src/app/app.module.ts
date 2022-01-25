import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { OverviewComponent } from './overview/overview.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { DetailsComponent } from './details/details.component';
import { DeleteComponent } from './delete/delete.component';
import { UpdateComponent } from './update/update.component';
import { CreateComponent } from './create/create.component';
import { PrologueComponent } from './prologue/prologue.component';
import { CreditsComponent } from './credits/credits.component';
import { HomeComponent } from './home/home.component';
import { ResultComponent } from './result/result.component';
import { SearchComponent } from './search/search.component';
import { BattleComponent } from './battle/battle.component';
import { OverviewSpellComponent } from './overview-spell/spells.component';
import { OverviewPotionComponent } from './overview-potion/potions.component';
import { DetailsPotionComponent } from './details-potion/details-potion.component';
import { DetailsSpellComponent } from './details-spell/details-spell.component';
import { RulesComponent } from './rules/rules.component';
import { RanksComponent } from './ranks/ranks.component';
import { DetailsAnimalComponent } from './details-animal/details-animal.component';
import { OverviewAnimalComponent } from './overview-animal/overview-animal.component';
import { CompareComponent } from './compare/compare.component';
import { ChessComponent } from './chess/chess.component';
import { TrainingComponent } from './training/training.component';
import { PreparationComponent } from './preparation/preparation.component';
import { InformationComponent } from './information/information.component';
import { SelectionComponent } from './selection/selection.component';

@NgModule({
  declarations: [
    AppComponent,
    OverviewComponent,
    DetailsComponent,
    DeleteComponent,
    UpdateComponent,
    CreateComponent,
    PrologueComponent,
    CreditsComponent,
    HomeComponent,
    ResultComponent,
    SearchComponent,
    BattleComponent,
    OverviewSpellComponent,
    OverviewPotionComponent,
    DetailsPotionComponent,
    DetailsSpellComponent,
    RulesComponent,
    RanksComponent,
    DetailsAnimalComponent,
    OverviewAnimalComponent,
    CompareComponent,
    ChessComponent,
    TrainingComponent,
    PreparationComponent,
    InformationComponent,
    SelectionComponent,
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
