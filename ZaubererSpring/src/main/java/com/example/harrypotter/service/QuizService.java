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
