package com.example.harrypotter.service;

import com.example.harrypotter.entity.quiz.Answer;
import com.example.harrypotter.entity.quiz.Question;
import com.example.harrypotter.repo.quiz.AnswerRepo;
import com.example.harrypotter.repo.quiz.QuestionRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuizService {
    private QuestionRepo questionRepo;
    private AnswerRepo answerRepo;

    public List<Question> createAllQuestions(){
        createQuestionRonAndHermione();
        createTroll();
        createChristmasOP();
        createSorting();
        createRonDeathlyHallows();
        createOWLRon();
        createHarryAndRonFail();
        createAfterTheWedding();
        createRonAndHermioneWaiting();
        createSnakeInTheZoo();
        createEyesOfBasilisk();
        createRunespoorHead();
        createBasiliskDifference();
        createRonsEmotionalRange();
        createRonAndHermioneChildren();
        createBookFromFredAndGeorge();
        createGoodLuckKiss();
        createHermioneNearlyAsked();
        createSnapeCallingHermione();
        createHermioneTurningDown();
        createBeforeKissing();
        createApparation();
        createBecomingAnAnimagus();
        createVeelas();
        createAragogsWife();
        createBlastEndedSkrewtsCreatures();
        createAttributeBlastEndedSkrewts();
        createWhatDidHagridTryToRaise();
        createThestralEyes();
        createFillingInForHagrid();
        createThirdYearExam();
        createFeedingBlastEndedSkrewts();
        createNifflerCompetition();
        createHarryMagicalCreaturesExam();
        createFredRonChristmasDinner();
        createChristmasBroadcast();
        createMissingDuringChristmas();
        createMrsWeaslesyPresentForHarry();
        createKreachersPresent();
        createPercyStormingOut();
        createFleursDragon();
        createSmallestDragon();
        createChineseFireballEggs();
        createHagridFeedingNorbert();
        createColorsRomanianLonghorn();
        createHarryEatingAtHalloween();
        createFirstTriwizardChamp();

        System.out.println(questionRepo.findAll().size());
        return questionRepo.findAll();

    }

    public void createQuestionRonAndHermione(){
        Question question = new Question(
                "What did Ron call Hermione after Charms class that made her cry?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("A nightmare", true, question));
        answerRepo.save(new Answer("A try-hard", false, question));
        answerRepo.save(new Answer("An insufferable know-it-all", false, question));
        answerRepo.save(new Answer("A loser", false, question));
    }

    public void createTroll(){
        Question question = new Question(
                "On the night that Harry, Ron and Hermione took on a giant troll – how many house points did they collectively gain for their efforts?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Five", true, question));
        answerRepo.save(new Answer("Fifteen", false, question));
        answerRepo.save(new Answer("Forty-five", false, question));
        answerRepo.save(new Answer("Ten", false, question));
    }

    public void createChristmasOP(){
        Question question = new Question(
                "In Harry Potter and the Order of the Phoenix, what did Hermione get Harry and Ron for Christmas?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Sneakocopes", false, question));
        answerRepo.save(new Answer("Homework planners", true, question));
        answerRepo.save(new Answer("Copies of Hogwarts: A history", false, question));
        answerRepo.save(new Answer("Honeydukes chocolates", false, question));
    }

    public void createSorting(){
        Question question = new Question(
                "In the books, who was the first to get sorted into their house: Harry, Ron or Hermione?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Hermione", true, question));
        answerRepo.save(new Answer("Ron", false, question));
        answerRepo.save(new Answer("Harry", false, question));
    }
    public void createRonDeathlyHallows(){
        Question question = new Question(
                "When the trio were talking about the Deathly Hallows, which Hallow did Ron say he would like to have?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("The Elder Wand", true, question));
        answerRepo.save(new Answer("The Resurrection Stone", false, question));
        answerRepo.save(new Answer("The Invisibility Cloak", false, question));
    }
    public void createOWLRon(){
        Question question = new Question(
                "How many O.W.Ls did Ron get when he received his results?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Eight", false, question));
        answerRepo.save(new Answer("Ten", false, question));
        answerRepo.save(new Answer("Seven", true, question));
        answerRepo.save(new Answer("Nine", false, question));
    }
    public void createHarryAndRonFail(){
        Question question = new Question(
                "And which two subjects did both Harry and Ron get Fail Grades in?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Charms and Potions", false, question));
        answerRepo.save(new Answer("Care of Magical Creatures and Astronomy", false, question));
        answerRepo.save(new Answer("Divination and Potions", false, question));
        answerRepo.save(new Answer("History of Magic and Divination", true, question));
    }
    public void createAfterTheWedding(){
        Question question = new Question(
                "After escaping Bill and Fleur’s wedding, where in London does Hermione take Harry and Ron?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Tottenham Court Road", true, question));
        answerRepo.save(new Answer("Brick Lane", false, question));
        answerRepo.save(new Answer("Hampstead Heath", false, question));
        answerRepo.save(new Answer("Leicester Square", false, question));
    }
    public void createRonAndHermioneWaiting(){
        Question question = new Question(
                "In Harry Potter and the Prisoner of Azkaban, where were Hermione and Ron waiting for Harry, who had taken refuge in Diagon Alley?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("The Leaky Cauldron", false, question));
        answerRepo.save(new Answer("Flourish and Blott", false, question));
        answerRepo.save(new Answer("Madam Malkin's", false, question));
        answerRepo.save(new Answer("Florean Fortescues's Ice Cream Parlour", true, question));
    }
    public void createSnakeInTheZoo(){
        Question question = new Question(
                "When Harry spoke to the snake in the zoo in Philosopher’s Stone, where had it come from?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Rescued in Borneo", false, question));
        answerRepo.save(new Answer("Brought over from Brazil", false, question));
        answerRepo.save(new Answer("It was bred in the zoo", true, question));
        answerRepo.save(new Answer("It came from Peru", false, question));
    }
    public void createEyesOfBasilisk(){
        Question question = new Question(
                "What colour are a Basilisk’s eyes?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Orange", false, question));
        answerRepo.save(new Answer("Red", false, question));
        answerRepo.save(new Answer("Green", false, question));
        answerRepo.save(new Answer("Yellow", true, question));
    }
    public void createRunespoorHead(){
        Question question = new Question(
                "How many heads does a Runespoor have?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("One", false, question));
        answerRepo.save(new Answer("Three", true, question));
        answerRepo.save(new Answer("Four", false, question));
        answerRepo.save(new Answer("Two", false, question));
    }
    public void createBasiliskDifference(){
        Question question = new Question(
                "How do you tell the difference between and male and female Basilisk?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Females have a deep orange plumpe upon their heads", false, question));
        answerRepo.save(new Answer("Males have a scarlet plume upon their heads", true, question));
        answerRepo.save(new Answer("Males have three eyes", false, question));
        answerRepo.save(new Answer("Females are more blue than green", false, question));
    }
    public void createRonsEmotionalRange(){
        Question question = new Question(
                "What did Hermione compare Ron’s emotional range to?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("A mug", false, question));
        answerRepo.save(new Answer("A fork", false, question));
        answerRepo.save(new Answer("A teaspoon", true, question));
        answerRepo.save(new Answer("A plate", false, question));
    }
    public void createRonAndHermioneChildren(){
        Question question = new Question(
                "What are the names of Ron and Hermione’s children?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Molly and Harry", false, question));
        answerRepo.save(new Answer("Fred and Violet", false, question));
        answerRepo.save(new Answer("Rose and Hugo", true, question));
        answerRepo.save(new Answer("Arthur and Luna", false, question));
    }
    public void createBookFromFredAndGeorge(){
        Question question = new Question(
                "What book did the Weasley twins give to Ron which he used to try and win Hermione over?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Ten Ways to Woo Your Witch", true, question));
        answerRepo.save(new Answer("Witch Charming: A Gide for Those Who Struggle", false, question));
        answerRepo.save(new Answer("Twelve Fail-Safe Ways to Charm Witches", true, question));
        answerRepo.save(new Answer("How to Enchant an Enchantress", false, question));
    }
    public void createGoodLuckKiss(){
        Question question = new Question(
                "In Order of the Phoenix, which Quidditch team was Ron about to play when Hermione gave him a good luck kiss on the cheek?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Slytherin", true, question));
        answerRepo.save(new Answer("Hufflepuff", false, question));
        answerRepo.save(new Answer("Ravenclaw", false, question));
    }
    public void createHermioneNearlyAsked(){
        Question question = new Question(
                "What lesson were Ron and Hermione in when she nearly asked him to Slughorn’s party?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Care of Magical Creatures", false, question));
        answerRepo.save(new Answer("Transfiguration", false, question));
        answerRepo.save(new Answer("Herbology", true, question));
        answerRepo.save(new Answer("Defence Against the Dark Arts", false, question));
    }
    public void createSnapeCallingHermione(){
        Question question = new Question(
                "In Prisoner of Azkaban, what did Professor Snape call Hermione that caused Ron to defend her and end up in detention?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("A smart alec", false, question));
        answerRepo.save(new Answer("A blithering idiot", false, question));
        answerRepo.save(new Answer("A nosy swot", false, question));
        answerRepo.save(new Answer("An insufferable know-it-all", true, question));
    }
    public void createHermioneTurningDown(){
        Question question = new Question(
                "Who had Hermione turned down as a date to the Yule Ball before Ron clumsily asked her?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Neville Longbottom", true, question));
        answerRepo.save(new Answer("Dean Thomas", false, question));
        answerRepo.save(new Answer("George Weasley", false, question));
        answerRepo.save(new Answer("Seamus Finnigan", false, question));
    }
    public void createBeforeKissing(){
        Question question = new Question(
                "In the book version of Deathly Hallows, what was Hermione holding right before she kissed Ron?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("A broomstick", false, question));
        answerRepo.save(new Answer("A pile of books", false, question));
        answerRepo.save(new Answer("Ravenclaw's Diadem", false, question));
        answerRepo.save(new Answer("Basilisk fangs", true, question));
    }
    public void createApparation(){
        Question question = new Question(
                "When it comes to Apparition, what are the three Ds you should remember?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Direction, decision, dedication", false, question));
        answerRepo.save(new Answer("Destination, determination, deliberation", true, question));
        answerRepo.save(new Answer("Duration, disorientation, disintegration", false, question));
        answerRepo.save(new Answer("Designation, deformation, delineation", false, question));
    }
    public void createBecomingAnAnimagus(){
        Question question = new Question(
                "As part of the process to becoming an Animagus, what do you need to carry in your mouth for a month?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Unicorn Hair", false, question));
        answerRepo.save(new Answer("Billywig sting", false, question));
        answerRepo.save(new Answer("A mandrake leaf", true, question));
        answerRepo.save(new Answer("Gillyweed", false, question));
    }
    public void createVeelas(){
        Question question = new Question(
                "What skill were Veelas revealed to have during the Quidditch World Cup?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("The ability to become invisible", true, question));
        answerRepo.save(new Answer("The ability to conjure fireballs", false, question));
        answerRepo.save(new Answer("The ability to turn into different people", false, question));
        answerRepo.save(new Answer("The ability to float", false, question));
    }
    public void createAragogsWife(){
        Question question = new Question(
                "And what was the name of Aragogs’s wife?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Magog", false, question));
        answerRepo.save(new Answer("Mosag", true, question));
        answerRepo.save(new Answer("Ragno", false, question));
        answerRepo.save(new Answer("Ariadne", false, question));
    }
    public void createBlastEndedSkrewtsCreatures(){
        Question question = new Question(
                "Hagrid bred a Fire Crab with what creature to create the Blast-Ended Skrewts?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("A Quintaped", false, question));
        answerRepo.save(new Answer("A Chimaera", false, question));
        answerRepo.save(new Answer("A Graphorn", false, question));
        answerRepo.save(new Answer("A Manticore", true, question));
    }
    public void createAttributeBlastEndedSkrewts(){
        Question question = new Question(
                "And what horrifying physical attribute do female Blast-Ended Skrewts have?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Blood-sucking suckers", true, question));
        answerRepo.save(new Answer("A stinger", false, question));
        answerRepo.save(new Answer("Their hide is covered in razor sharp spikes", false, question));
        answerRepo.save(new Answer("Poison-tipped claws", false, question));
    }
    public void createWhatDidHagridTryToRaise(){
        Question question = new Question(
                "What dangerous creatures did Hagrid try to raise as a student underneath his dormitory bed?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Werewolf cubs", true, question));
        answerRepo.save(new Answer("Nundu young", false, question));
        answerRepo.save(new Answer("Errumpent calves", false, question));
        answerRepo.save(new Answer("Chupacabra babies", false, question));
    }
    public void createThestralEyes(){
        Question question = new Question(
                "This is a misunderstood herd of creatures that Hagrid cared for…what colour are a Thestral’s eyes?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Black", false, question));
        answerRepo.save(new Answer("Red", false, question));
        answerRepo.save(new Answer("Yellow", false, question));
        answerRepo.save(new Answer("White", true, question));
    }
    public void createFillingInForHagrid(){
        Question question = new Question(
                "When filling in for Hagrid in Goblet of Fire, what creature did Professor Grubbly-Plank show Harry’s class in the first lesson she led?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Mooncalf", false, question));
        answerRepo.save(new Answer("Unicorn", true, question));
        answerRepo.save(new Answer("Clabbert", false, question));
        answerRepo.save(new Answer("Abraxan", false, question));
    }
    public void createThirdYearExam(){
        Question question = new Question(
                "What did Harry, Ron and Hermione’s third-year Care of Magical Creatures exam involve?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Keeping a Flobberworm alive for an hour", true, question));
        answerRepo.save(new Answer("Being able to make a unicorn feed out of your hand", false, question));
        answerRepo.save(new Answer("Shepherding Blast-Ended Skrewts", false, question));
        answerRepo.save(new Answer("Demonstrating how to correctly approach a Hippogriff", false, question));
    }
    public void createFeedingBlastEndedSkrewts(){
        Question question = new Question(
                "When Harry’s class first met the Blast-Ended Skrewts, which of these was not something they tried to feed them?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Grass-snake", false, question));
        answerRepo.save(new Answer("Toad eyeballs", true, question));
        answerRepo.save(new Answer("Frog livers", false, question));
        answerRepo.save(new Answer("Ant eggs", false, question));
    }
    public void createNifflerCompetition(){
        Question question = new Question(
                "In Hagrid’s lesson about Nifflers, whose Niffler won the competition to find the most Leprechaun gold?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Ron Weasley", true, question));
        answerRepo.save(new Answer("Dean Thomas", false, question));
        answerRepo.save(new Answer("Seamus Finnigan", false, question));
        answerRepo.save(new Answer("Hermione Granger", false, question));
    }
    public void createHarryMagicalCreaturesExam(){
        Question question = new Question(
                "In Harry’s Care of Magical Creatures O.W.L., he had to demonstrate the correct handling of what creature?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Crup", false, question));
        answerRepo.save(new Answer("Bowtruckle", true, question));
        answerRepo.save(new Answer("Kneazle", false, question));
        answerRepo.save(new Answer("Billywig", false, question));
    }
    public void createFredRonChristmasDinner(){
        Question question = new Question(
                "In Half-Blood Prince, when peeling sprouts in preparation for Christmas dinner, what did Ron throw at Fred?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("A turkey", false, question));
        answerRepo.save(new Answer("A bowl of sprouts", false, question));
        answerRepo.save(new Answer("A wooden spoon", false, question));
        answerRepo.save(new Answer("A knife", true, question));
    }
    public void createChristmasBroadcast(){
        Question question = new Question(
                "In Half-Blood Prince on Christmas Eve, which singer was doing a Christmas broadcast that everyone at The Burrow was supposed to be listening to?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Cordelia Worcester", false, question));
        answerRepo.save(new Answer("Celine Warton", false, question));
        answerRepo.save(new Answer("Cherish Winterberry", false, question));
        answerRepo.save(new Answer("Celestina Warbeck", true, question));
    }
    public void createMissingDuringChristmas(){
        Question question = new Question(
                "In Half-Blood Prince, who was not a guest at The Burrow during the Christmas season?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Harry Potter", false, question));
        answerRepo.save(new Answer("Remus Lupin", false, question));
        answerRepo.save(new Answer("Fleur Delacour", false, question));
        answerRepo.save(new Answer("Hermione Granger", true, question));
    }
    public void createMrsWeaslesyPresentForHarry(){
        Question question = new Question(
                "In Half-Blood Prince, what was on the Christmas jumper that Mrs Weasley knitted for Harry that year?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("A large Golden Snitch", true, question));
        answerRepo.save(new Answer("A Firebolt", false, question));
        answerRepo.save(new Answer("Harry's face", false, question));
        answerRepo.save(new Answer("A Hungarian Horntail", false, question));
    }
    public void createKreachersPresent(){
        Question question = new Question(
                "In Half-Blood Prince, what present did Harry unwrap from Kreacher on Christmas morning?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("A pile of Flobberworms", false, question));
        answerRepo.save(new Answer("Rotten fish heads", false, question));
        answerRepo.save(new Answer("Maggots", true, question));
        answerRepo.save(new Answer("A mouldy slab of cheese", false, question));
    }
    public void createPercyStormingOut(){
        Question question = new Question(
                "In Half-Blood Prince, when Percy stormed out of the house on Christmas Day, what were his glasses covered in?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Mashed parsnip", true, question));
        answerRepo.save(new Answer("Bread sauce", false, question));
        answerRepo.save(new Answer("Pureed sprouts", false, question));
        answerRepo.save(new Answer("Stuffing", false, question));
    }
    public void createFleursDragon(){
        Question question = new Question(
                "What dragon did Fleur Delacour face in the first task of the Triwizard tournament?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("A Hebridean Black", false, question));
        answerRepo.save(new Answer("A Welsh Green", true, question));
        answerRepo.save(new Answer("A Swedish Short-Snout", false, question));
        answerRepo.save(new Answer("Chinese Fireball", false, question));
    }
    public void createSmallestDragon(){
        Question question = new Question(
                "What is the smallest of all known dragons?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Peruvian Vipertooth", true, question));
        answerRepo.save(new Answer("Antipodean Opaleye", false, question));
        answerRepo.save(new Answer("Welsh Green", false, question));
        answerRepo.save(new Answer("Ukrainian Ironbelly", false, question));
    }
    public void createChineseFireballEggs(){
        Question question = new Question(
                "What colour are the eggs of a Chinese Fireball?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Crimson speckled with gold", true, question));
        answerRepo.save(new Answer("Orange with maroon swirls", false, question));
        answerRepo.save(new Answer("Pure gold", false, question));
        answerRepo.save(new Answer("Silver with gold streaks", false, question));
    }
    public void createHagridFeedingNorbert(){
        Question question = new Question(
                "What did Hagrid feed Norbert when he hatched, based on the advice from the book Dragon-Breeding for Pleasure and Profit?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Three live mice and three dead rats every hour", false, question));
        answerRepo.save(new Answer("A pint of Firewhisky mixed with duck livers every two hours", false, question));
        answerRepo.save(new Answer("One bootle of rooster blood every twenty minutes", false, question));
        answerRepo.save(new Answer("A bucket of brandy mixed with chicken blood every half hour", true, question));
    }
    public void createColorsRomanianLonghorn(){
        Question question = new Question(
                "What colour are the scales of a Romanian Longhorn?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Slate grey", false, question));
        answerRepo.save(new Answer("Blood red", false, question));
        answerRepo.save(new Answer("Deep blue", false, question));
        answerRepo.save(new Answer("Dark green", true, question));
    }
    public void createHarryEatingAtHalloween(){
        Question question = new Question(
                "And in the Philosopher’s Stone book, what food was Harry helping himself to from the feast when Quirrell burst in?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Treacle tart", false, question));
        answerRepo.save(new Answer("Pumpkin pie", false, question));
        answerRepo.save(new Answer("A jacket potato", true, question));
        answerRepo.save(new Answer("Roast chicken", false, question));
    }
    public void createFirstTriwizardChamp(){
        Question question = new Question(
                "On Hallowe’en night, who was the first Triwizard Champion to be announced?"
        );
        questionRepo.save(question);

        answerRepo.save(new Answer("Harry Potter", false, question));
        answerRepo.save(new Answer("Viktor Krum ", true, question));
        answerRepo.save(new Answer("Cedric Diggory", false, question));
        answerRepo.save(new Answer("Fleur Delacour", false, question));
    }
//    public void create(){
//        Question question = new Question(
//                ""
//        );
//        questionRepo.save(question);
//
//        answerRepo.save(new Answer("", true, question));
//        answerRepo.save(new Answer("", false, question));
//        answerRepo.save(new Answer("", false, question));
//        answerRepo.save(new Answer("", false, question));
//    }
//    public void create(){
//        Question question = new Question(
//                ""
//        );
//        questionRepo.save(question);
//
//        answerRepo.save(new Answer("", true, question));
//        answerRepo.save(new Answer("", false, question));
//        answerRepo.save(new Answer("", false, question));
//        answerRepo.save(new Answer("", false, question));
//    }
//    public void create(){
//        Question question = new Question(
//                ""
//        );
//        questionRepo.save(question);
//
//        answerRepo.save(new Answer("", true, question));
//        answerRepo.save(new Answer("", false, question));
//        answerRepo.save(new Answer("", false, question));
//        answerRepo.save(new Answer("", false, question));
//    }





}
