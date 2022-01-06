package fr.metz.iut.film.dao.falseData;

import fr.metz.iut.film.structure.Film;
import fr.metz.iut.film.structure.type.FilmType;

import java.time.LocalDate;
import java.time.Month;

import static fr.metz.iut.crud.GenerateID.generateNewId;
import static fr.metz.iut.film.dao.falseData.DirectorData.*;

class FilmData {

  static final Film FIGHT_CLUB = new Film(
    generateNewId(),
    "Fight Club",
    LocalDate.of(1999, Month.SEPTEMBER, 10),
    DAVID_FINCHER,
    """
    Insomniaque, désillusionné par sa vie personnelle et professionnelle, un jeune cadre expert en assurances, mène une vie monotone et sans saveur.
    Face à la vacuité de son existence, son médecin lui conseille de suivre une thérapie afin de relativiser son mal-être.
    Lors d'un voyage d'affaires, il fait la connaissance de Tyler Durden, une sorte de gourou anarchiste et philosophe.
    Ensemble, ils fondent le Fight Club.Cercle très fermé, où ils organisent des combats clandestins et violents, destinés à évacuer l'ordre établi.""",
    FilmType.ACTION,
    "tt0137523");

  static final Film THE_SOCIAL_NETWORK = new Film(
    generateNewId(),
    "The Social Network",
    LocalDate.of(2010, Month.OCTOBER, 13),
    DAVID_FINCHER,
    """
      En 2003, l'étudiant à l'université Harvard Mark Zuckerberg est largué par
      sa copine Erica Albright durant une soirée. Il revient ivre à sa résidence
      d'étudiants et rédige un blog pour la discréditer. Cela lui donne l'idée de
      créer un site interactif nommé Facemash qui permettra aux utilisateurs du campus
      d'élire l'étudiante la plus jolie par le biais de leurs photos piratées sur les
      trombinoscopes des différentes résidences. Pour obtenir un classement unique de
      toutes les étudiantes à partir des comparaisons deux à deux de leur attractivité,
      il s'inspire du classement Elo, utilisé pour les joueurs d'échecs. L'idée fonctionne,
      le succès est immédiat et conduit au crash du réseau local du campus au milieu de la nuit.
      
      La popularité de Facemash ainsi que Mark attirent l'attention de Cameron et Tyler Winklevoss
      par ailleurs rameurs olympiques dans l'équipe d'aviron des États-Unis, et leur partenaire
      Divya Narendra. Les jumeaux Winklevoss invitent Mark à leur club où Mark accepte un travail
      en tant que programmeur pour un projet de site de rencontres nommé Harvard Connection. Mark
      voit son ami Eduardo Saverin et lui parle de son idée d'un projet qu'il nomme The Facebook,
      un site Internet de réseau social exclusivement réservé aux étudiants de l'université Harvard.
      Il explique que ça pourrait relancer la popularité de FaceMash. Eduardo accepte d'aider Mark,
      et réussit à regrouper 1 000 dollars pour aider à la fondation du site. Le site lancé, les
      jumeaux Winklevoss et Narendra sont persuadés que Zuckerberg a volé leur idée, l'accusant
      d'avoir été baladés. Les jumeaux et Diyva désirent poursuivre Mark en justice, après les tentatives
      infructueuses d'une injonction judiciaire ou d'un entretien avec le directeur d'Harvard.""",
    FilmType.BIOGRAPHY,
    "tt1285016");


  static final Film BABYLON = new Film(generateNewId(),
    "Babylon",
    LocalDate.of(2017, Month.JANUARY, 25),
    DAMIEN_CHAZELLE,
    "Un drame situé à Hollywood, durant l'apparition du cinéma parlant.",
    FilmType.ROMANCE,
    "tt10640346");

  static final Film LA_LA_LAND = new Film(generateNewId(),
    "La La Land",
    LocalDate.of(2022, Month.DECEMBER, 25),
    DAMIEN_CHAZELLE,
    """
      Au cœur de Los Angeles, une actrice en devenir prénommée Mia sert des cafés entre deux auditions.
      De son côté, Sebastian, passionné de jazz, joue du piano dans des clubs miteux pour assurer sa subsistance.
      Tous deux sont bien loin de la vie rêvée à laquelle ils aspirent…
      Le destin va réunir ces doux rêveurs, mais leur coup de foudre résistera-t-il aux tentations, aux déceptions,
      et à la vie trépidante d’Hollywood ?""",
    FilmType.ROMANCE,
    "tt3783958");


  static final Film INCEPTION = new Film(generateNewId(),
    "Inception",
    LocalDate.of(2010, Month.JULY, 21),
    CHRISTOPHER_NOLAN,
    """
    Un voleur qui s'approprie des secrets d'entreprise à l'aide d'une technique
    de partage de rêves se voit contraint d'effectuer la tâche inverse :
    implanter une idée dans l'esprit d'un PDG, pour revoir ses enfants.""",
    FilmType.SCIFI,
    "tt1375666");

  static final Film INTERSTELLAR = new Film(generateNewId(),
    "Interstellar",
    LocalDate.of(2014, Month.NOVEMBER, 5),
    CHRISTOPHER_NOLAN,
    """
      Le film raconte les aventures d’un groupe d’explorateurs qui utilisent une faille
      récemment découverte dans l’espace-temps afin de repousser les limites humaines et
      partir à la conquête des distances astronomiques dans un voyage interstellaire.""",
    FilmType.SCIFI,
    "tt0816692");

  static final Film TENET = new Film(generateNewId(),
    "Tenet",
    LocalDate.of(2020, Month.AUGUST, 26),
    CHRISTOPHER_NOLAN,
    """
      Muni d'un seul mot – Tenet – et décidé à se battre pour sauver le monde,
      notre protagoniste sillonne l'univers crépusculaire de l'espionnage international.
      Sa mission le projettera dans une dimension qui dépasse le temps. Pourtant, il ne
      s'agit pas d'un voyage dans le temps, mais d'un renversement temporel…""",
    FilmType.SCIFI,
    "tt6723592");

  static final Film PULP_FICTION = new Film(generateNewId(),
    "Pulp Fiction",
    LocalDate.of(1994, Month.OCTOBER, 14),
    QUENTIN_TARANTINO,
    """
    Les vies de deux hommes de main, d'un boxeur, de la femme d'un gangster et
    de deux braqueurs s'entremêlent dans quatre histoires de violence et de rédemption.""",
    FilmType.ACTION,
    "tt0110912");


  static final Film ONCE_UPON_A_TIME_IN_HOLLYWOOD = new Film(generateNewId(),
    "Once Upon a Time In Hollywood",
    LocalDate.of(2019, Month.JULY, 26),
    QUENTIN_TARANTINO,
    """
    Un acteur de télé has-been et sa doublure se lancent dans une odyssée pour se
    faire un nom dans l'industrie cinématographique lors des meurtres de Charles
    Manson en 1969 à Los Angeles.""",
    FilmType.ACTION,
    "tt7131622");

  static final Film PARASITE = new Film(generateNewId(),
    "Parasite",
    LocalDate.of(2019, Month.JUNE, 5),
    BONG_JOON_HO,
    """
    Toute la famille de Ki-taek est au chômage, et s’intéresse fortement au train de
    vie de la richissime famille Park. Un jour, leur fils réussit à se faire recommander
    pour donner des cours particuliers d’anglais chez les Park. C’est le début d’un
    engrenage incontrôlable, dont personne ne sortira véritablement indemne...""",
    FilmType.THRILLER,
    "tt6751668");
}
